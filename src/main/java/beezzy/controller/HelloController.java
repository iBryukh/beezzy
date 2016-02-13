package beezzy.controller;

import beezzy.domain.entities.RoleEntity;
import beezzy.domain.entities.UserEntity;
import beezzy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private UserService userService;

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
}