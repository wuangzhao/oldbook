package org.fd.web;

import org.fd.entity.SellEntity;
import org.fd.entity.ShoppingCartEntity;
import org.fd.entity.UserInfoEntity;
import org.fd.model.BookAndSellQryModel;
import org.fd.service.BookService;
import org.fd.service.SellService;
import org.fd.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("shoppingCart")
@Controller
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    BookService bookService;

    @Autowired
    SellService sellService;

    @RequestMapping("list")
    public @ResponseBody
    List<BookAndSellQryModel> getShoppingCartDetailList(HttpSession session) {
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
        if (user == null) {
            return null;
        }
        List<BookAndSellQryModel> bookAndSellQryModelList = new ArrayList<>();
        List<ShoppingCartEntity> shoppingCartEntityList = shoppingCartService.getUserShoppingCartList(user.getUserId());
        for (ShoppingCartEntity shoppingCartEntity : shoppingCartEntityList) {
            BookAndSellQryModel temp = new BookAndSellQryModel();
            SellEntity sellEntity = sellService.getBySellId(shoppingCartEntity.getSellId());
            temp.setBook(bookService.getById(sellEntity.getBookId()));
            temp.setSell(sellEntity);
            bookAndSellQryModelList.add(temp);
        }
        return bookAndSellQryModelList;
    }

    @RequestMapping("insert")
    public @ResponseBody ShoppingCartEntity addToShoppingCart(ShoppingCartEntity shoppingCartEntity) {
        if (shoppingCartService.addToShoppingCart(shoppingCartEntity)) {
            return null;
        } else {
            return shoppingCartEntity;
        }
    }

    @RequestMapping("delete")
    public boolean deleteShoppingCart(ShoppingCartEntity shoppingCartEntity) {
        return shoppingCartService.deleteShoppingCart(shoppingCartEntity);
    }

}
