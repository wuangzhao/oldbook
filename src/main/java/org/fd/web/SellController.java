package org.fd.web;

import org.fd.entity.BookEntity;
import org.fd.entity.SellEntity;
import org.fd.entity.UserEntity;
import org.fd.entity.UserInfoEntity;
import org.fd.service.BookService;
import org.fd.service.SellService;
import org.fd.service.UserInfoService;
import org.fd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("sell")
public class SellController {

    @Autowired
    SellService sellService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    BookService bookService;

    /**
     * 绑定数据：Sell, Book, UserId, UserName
     * @param model
     * @param sellId
     * @return
     */
    @RequestMapping("detail")
    public String sellDetail(Model model,
                             @RequestParam(value = "sellId", defaultValue = "")
                                     Integer sellId) {
        SellEntity sellEntity = sellService.getById(sellId);
        if (sellId == null || sellEntity == null) {
            return "error/error";
        }
        model.addAttribute("sell", sellEntity);
        BookEntity bookEntity = bookService.getById(sellEntity.getBookId());
        UserInfoEntity userInfoEntity = userInfoService.getUserInfoById(sellEntity.getUserId());
        model.addAttribute("book", bookEntity);
        model.addAttribute("user", userInfoEntity);
        return "sell/detail";
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String userSellDetail(Model model,
                                 @RequestParam(value = "userId", defaultValue = "")
                                         Integer userId) {
        List<SellEntity> sellEntityList = sellService.getByUserId(userId);
        model.addAttribute("sellList", sellEntityList);
        return "sell/user";
    }

}
