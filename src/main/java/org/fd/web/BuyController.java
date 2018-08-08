package org.fd.web;

import org.fd.entity.BuyEntity;
import org.fd.entity.UserInfoEntity;
import org.fd.model.BookAndBuyQryModel;
import org.fd.service.BookService;
import org.fd.service.BuyService;
import org.fd.service.SellService;
import org.fd.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("buy")
public class BuyController {

    @Autowired
    BuyService buyService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    BookService bookService;

    @Autowired
    SellService sellService;

    @RequestMapping("list/{userId}")
    public @ResponseBody List<BookAndBuyQryModel>
    getBuyDetailByUserId(HttpSession session, @PathVariable int userId) {
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
        if (user == null || user.getUserId() != userId) {
            return null;
        }
        List<BuyEntity> buyEntityList = buyService.getByUserId(user.getUserId());
        List<BookAndBuyQryModel> bBList = new ArrayList<>();
        for (BuyEntity buyEntity : buyEntityList) {
            BookAndBuyQryModel temp = new BookAndBuyQryModel();
            System.out.println(buyEntity.toString());
            temp.setBuy(buyEntity);
            temp.setBook(bookService.getById(sellService.getBySellId(buyEntity.getSellId()).getBookId()));
            bBList.add(temp);
        }
        return bBList;
    }

    @RequestMapping("buyBook")
    public String buyBook(HttpSession session, Integer sellId) {
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
        if (user == null) {
            return "redirect:/user/toLogin";
        }
        BuyEntity buy = buyService.addBuy(user.getUserId(), sellId).getBuyEntity();
        return MessageFormat.format("redirect:user?list={0}",user.getUserId().toString());
    }
}
