package org.fd.web;

import org.fd.entity.BookEntity;
import org.fd.entity.SellEntity;
import org.fd.entity.UserEntity;
import org.fd.entity.UserInfoEntity;
import org.fd.model.BookAndSellQryModel;
import org.fd.service.BookService;
import org.fd.service.SellService;
import org.fd.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 将Sell和Book包装类传进model
     * 查询后，通过sell中的bookId查找book属性
     * 再将sell和book装进 BookAndSellQryModel 中
     * 将userSellList属性传入model中
     * @param model
     * @param userId 用户Id
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String userSellDetail(Model model,
                                 @RequestParam(value = "userId", defaultValue = "")
                                         Integer userId) {
        List<SellEntity> sellEntityList = sellService.getByUserId(userId);
        List<BookAndSellQryModel> userSellList = new ArrayList<>();
        for (int i = 0; i < sellEntityList.size(); i++) {
            BookAndSellQryModel temp = new BookAndSellQryModel();
            temp.setBook(bookService.getById(sellEntityList.get(i).getBookId()));
            temp.setSell(sellEntityList.get(i));
            userSellList.add(temp);
        }
        model.addAttribute("userSellList", userSellList);
        return "sell/user";
    }

    @RequestMapping(value = "newSell", method = RequestMethod.POST)
    public String userNewSell(Model model, HttpSession session, BookEntity book) {
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
        if (user == null) {
            return "redirect:/user/toLogin";
        }
        System.out.println(book.getBookId());
        SellEntity sell = new SellEntity();
        if (bookService.getById(book.getBookId()) == null) {
            //TODO
        } else {
            int insertSellId = sellService.insertSell(user.getUserId(), book.getBookId());
        }

        return MessageFormat.format("redirect:user?userId={0}",user.getUserId().toString());
    }

}
