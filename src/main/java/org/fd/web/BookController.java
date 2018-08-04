package org.fd.web;

import org.fd.entity.BookEntity;
import org.fd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 获取所有书籍控制器
     * @param model
     * @return 视图名
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        List<BookEntity> bookEntityList = bookService.getAll();
        model.addAttribute("list", bookEntityList);
        return "list";
    }

    /**
     * 书籍详细信息控制器
     * @param model
     * @param bookId
     * @return 视图名
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    private String queryBookId(Model model, @RequestParam(value = "bookName", defaultValue = "") String bookName,
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
        for (BookEntity bookEntity : bookEntityList) {
            System.out.println(bookEntity.getBookName());
        }
        if (bookEntityList == null) {
            return "redirect:/book/list";
        }
        model.addAttribute("bookEntityList", bookEntityList);
        return "detail";
    }
}
