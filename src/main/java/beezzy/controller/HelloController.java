package beezzy.controller;

import beezzy.domain.entities.RoleEntity;
import beezzy.domain.entities.UserEntity;
import beezzy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");

        List<UserEntity> users = userService.get(0, 10);
        users.size();

		return "hello";
	}

    @RequestMapping("/add")
    public String add(){

        UserEntity user = new UserEntity();
        user.setEmail("email");
        user.setPassword("pass");
        RoleEntity role = new RoleEntity();
        role.setId(1);
        user.setRole(role);
        try {
            userService.merge(user);
        } catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/";
    }

    @RequestMapping("/admin")
    @PreAuthorize("@Secure.isAdmin()")
    public @ResponseBody String admin(){
        return "admin";
    }

    @RequestMapping("/owner")
    @PreAuthorize("@Secure.isOwner()")
    public @ResponseBody String owner(){
        return "owner";
    }
}