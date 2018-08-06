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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;
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

    @RequestMapping("list")
    public String buyDetail(Model model, HttpSession session) {
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
        if (user == null) {
            return "redirect:/user/toLogin";
        }
        List<BuyEntity> buyEntityList = buyService.getByUserId(user.getUserId());
        List<BookAndBuyQryModel> bBList = new ArrayList<>();
        for (BuyEntity buyEntity : buyEntityList) {
            BookAndBuyQryModel temp = new BookAndBuyQryModel();
            System.out.println(buyEntity.toString());
            temp.setBuy(buyEntity);
            temp.setBook(bookService.getById(sellService.getById(buyEntity.getSellId()).getBookId()));
            bBList.add(temp);
        }
        model.addAttribute("bBList", bBList);
        return "buy/list";

    }

}
