package beezzy.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by oleh on 14.03.2016.
 */
@Controller
@RequestMapping("/shops")
public class ShopsController {

    @RequestMapping("/my")
    public String myShops(){
        return "shops/my-shops";
    }

}
