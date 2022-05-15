package red.kalos.usersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import red.kalos.usersystem.entity.Data;
import red.kalos.usersystem.service.DataService;
import red.kalos.usersystem.util.SHA256Password;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("login")
    public String login(Data data, HttpSession httpSession){
        SHA256Password sha256Password = new SHA256Password();
        Data user = dataService.queryById(data.getId());

        if (user==null){
            System.out.println("没有这个用户！");
        }else {
            if (sha256Password.getHandling(user.getPassword(),data.getPassword())){

                System.out.println("登录成功！"+user.getName());
                httpSession.setAttribute("UserLoginSession",data);
                httpSession.setMaxInactiveInterval(6000);
                return "redirect:mainView";
            }
            System.out.println("密码错误！");
        }

        return "redirect:loginView";
    }

    @GetMapping("register")
    public String register(Data data){
        SHA256Password sha256Password = new SHA256Password();
        Data user = dataService.queryById(data.getId());

        if (user==null){
            System.out.println("注册成功！"+data.getName());
            data.setPassword(sha256Password.setHandling(data.getPassword()));
            data.setRegtime(new Date(System.currentTimeMillis()));
            dataService.insert(data);
            return "redirect:loginView";
        }else {
            System.out.println("该用户已存在！");
        }

        dataService.insert(data);
        return "redirect:registerView";
    }


    @GetMapping("updateRegister")
    public String updateRegister(Data data){
        SHA256Password sha256Password = new SHA256Password();
        Data user = dataService.queryById(data.getId());

        if (user==null){
            System.out.println("该用户不存在！");
        }else {
            if (sha256Password.getHandling(user.getPassword(),data.getPassword())){
                user.setAge(data.getAge());
                user.setName(data.getName());
                user.setSex(data.getSex());
                dataService.update(user);
                System.out.println("修改成功！"+user.getName());
            }
            System.out.println("密码错误！");
        }
        return "redirect:loginView";
    }

    @RequestMapping("mainView")
    public String logout(Data data, Model model){
        model.addAttribute("userList", dataService.queryByPage(data,0,10));
        return "mainView";
    }
}
