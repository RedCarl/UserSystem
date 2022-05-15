package red.kalos.usersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("loginView")
    public String loginView(){
        return "loginView";
    }

    @RequestMapping("registerView")
    public String registerView(){
        return "registerView";
    }

    @RequestMapping("updateRegisterView")
    public String UpdateRegisterView(){
        return "updateRegisterView";
    }
}
