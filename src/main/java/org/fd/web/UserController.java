package org.fd.web;

import org.fd.entity.UserEntity;
import org.fd.entity.UserInfoEntity;
import org.fd.service.UserInfoService;
import org.fd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("toLogin")
    public String toLoginPage() {
        return "user/login";
    }

    @RequestMapping("login")
    public String login(Model model, String username, String password, HttpServletRequest request) {
        UserEntity user = userService.checkLogin(username, password);
        if (user == null) {
            return "user/login";
        } else {
            UserInfoEntity userInfoEntity = userInfoService.getUserInfoById(user.getUserId());
            request.getSession().setAttribute("user",userInfoEntity);
            return "user/success";
        }
    }

}
