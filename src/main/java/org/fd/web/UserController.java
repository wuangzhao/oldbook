package org.fd.web;

import org.fd.entity.UserEntity;
import org.fd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("toLogin")
    public String toLoginPage() {
        return "user/login";
    }

    @RequestMapping("login")
    public String login(Model model, String username, String password) {
        UserEntity user = userService.checkLogin(username, password);
        if (user == null) {
            return "user/login";
        } else {
            return "user/success";
        }
    }

}
