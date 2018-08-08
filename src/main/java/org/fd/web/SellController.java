package org.fd.web;

import org.fd.entity.BookEntity;
import org.fd.entity.SellEntity;
import org.fd.entity.UserInfoEntity;
import org.fd.model.BookAndSellQryModel;
import org.fd.service.BookService;
import org.fd.service.SellService;
import org.fd.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.MessageFormat;
import java.util.ArrayList;
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
     *
     * @param sellId
     * @return
     */
    @RequestMapping("detail/{sellId}")
    public @ResponseBody BookAndSellQryModel
    sellDetail(@PathVariable Integer sellId) {
        SellEntity sellEntity = sellService.getBySellId(sellId);
        if (sellId == null || sellEntity == null) {
            return null;
        }
        BookAndSellQryModel bookAndSellQryModel = new BookAndSellQryModel();
        bookAndSellQryModel.setSell(sellEntity);
        bookAndSellQryModel.setBook(bookService.getById(sellEntity.getBookId()));
        return bookAndSellQryModel;
    }

    /**
     * 将Sell和Book包装类传进model
     * 查询后，通过sell中的bookId查找book属性
     * 再将sell和book装进 BookAndSellQryModel 中
     * 将userSellList属性传入model中
     * @param userId 用户Id
     * @return
     */
    @RequestMapping("user/{userId}")
    public @ResponseBody List<BookAndSellQryModel> userSellDetail(@PathVariable Integer userId) {
        List<SellEntity> sellEntityList = sellService.getByUserId(userId);
        List<BookAndSellQryModel> userSellList = new ArrayList<>();
        for (int i = 0; i < sellEntityList.size(); i++) {
            BookAndSellQryModel temp = new BookAndSellQryModel();
            temp.setBook(bookService.getById(sellEntityList.get(i).getBookId()));
            temp.setSell(sellEntityList.get(i));
            userSellList.add(temp);
        }
        return userSellList;
    }

    @RequestMapping(value = "newSell", method = RequestMethod.POST)
    public String userNewSell(Model model, HttpSession session, BookEntity book) {
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
        if (user == null) {
            return "redirect:/user/toLogin";
        }
        SellEntity sell = new SellEntity();
        sell.setUserId(user.getUserId());
        sell.setBookId(book.getBookId());
        sell = sellService.addSell(sell).getSellEntity();
        return MessageFormat.format("redirect:user?userId={0}",user.getUserId().toString());
    }


}
