package org.fd.web;

import org.fd.entity.BookEntity;
import org.fd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<BookEntity> bookEntityList = bookService.getByName("");
        model.addAttribute("list", bookEntityList);
        return "book/list";
    }

    @RequestMapping(value = "{bookId}", method = RequestMethod.GET)
    public @ResponseBody BookEntity queryBookById(@PathVariable("bookId") Integer bookId) {
        return bookService.getById(bookId);
    }

    @RequestMapping(value = "addBook", method = RequestMethod.POST)
    public @ResponseBody BookEntity addBook(BookEntity book) {
        return bookService.addBook(book);
    }

    @RequestMapping(value = "bookManage/{id}", method = RequestMethod.DELETE)
    public String deleteBookById(@PathVariable Integer id) {
        if (bookService.deleteBook(id)) {
            return "success";
        } else {
            return "fail";
        }
    }

}
