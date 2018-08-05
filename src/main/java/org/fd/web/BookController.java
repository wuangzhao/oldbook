package org.fd.web;

import org.fd.entity.BookEntity;
import org.fd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 获取所有书籍控制器
     * @param model
     * @return 视图名
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String bookList(Model model) {
        List<BookEntity> bookEntityList = bookService.getAll();
        model.addAttribute("list", bookEntityList);
        return "book/list";
    }

    /**
     * 书籍详细信息控制器
     * @param model
     * @param bookId
     * @return 视图名
     */
    @RequestMapping(value = "detail")
    public String queryByBookId(Model model, @RequestParam(value = "bookName", defaultValue = "") String bookName,
                               @RequestParam(value = "bookId", defaultValue = "") Integer bookId
                               ) {
        if (bookId == null && bookName == null) {
            return "redirect:/book/list";
        }
        List<BookEntity> bookEntityList = null;
        if (bookId == null) {
            bookEntityList = bookService.getByName(bookName);
        } else {
            bookEntityList = Collections.singletonList(bookService.getById(bookId));
        }
        if (bookEntityList == null) {
            return "redirect:/book/list";
        }
        model.addAttribute("bookEntityList", bookEntityList);
        return "book/detail";
    }

    /**
     * 获取前端UserId
     * @param model
     * @param bookid
     */
    @RequestMapping(value = "getId", method = RequestMethod.POST)
    public void getByBookId(Model model, Integer[] bookid) {
        for (Integer i : bookid) {
            System.out.println(i);
        }
    }
}
