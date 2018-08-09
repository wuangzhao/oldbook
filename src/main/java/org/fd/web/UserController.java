package org.fd.web;

import org.fd.entity.UserEntity;
import org.fd.entity.UserInfoEntity;
import org.fd.service.UserInfoService;
import org.fd.service.UserService;
import org.fd.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @RequestMapping("checkLogin")
    public R checkLogin(String username, String password, HttpServletRequest request) {
        UserEntity user = userService.checkLogin(username, password);
        if (user == null) {
            return R.ok();
        } else {
            UserInfoEntity userInfoEntity = userInfoService.getUserInfoById(user.getUserId());
            request.getSession().setAttribute("user",userInfoEntity);
            return R.ok();
        }
    }

    @RequestMapping("outLogin")
    public String outLogin(HttpSession session) {
        session.invalidate();
        return "toLogin";
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public @ResponseBody UserInfoEntity findUserById(@PathVariable("id") Integer userId) {
        UserInfoEntity user = userInfoService.getUserInfoById(userId);
        return user;
    }

//    @RequestMapping(value = "tel/{Tel}", method = RequestMethod.GET)
//    public @ResponseBody UserInfoEntity findUserByTel(@PathVariable String Tel){
//        return userInfoService.getUserInfoById(userService.getUserByTel(Tel).getUserId());
//    }

}
