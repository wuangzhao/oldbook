package org.fd.web;

import org.fd.entity.BookEntity;
import org.fd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        List<BookEntity> bookEntityList = bookService.getByName("");
        model.addAttribute("list", bookEntityList);
        return "book/list";
    }

    @RequestMapping(value = "{bookId}", method = RequestMethod.POST)
    public @ResponseBody BookEntity queryByBookId(@PathVariable("bookId") Integer bookId) {
        BookEntity book = bookService.getById(bookId);
        return book;
    }

    @RequestMapping(value = "addBook", method = RequestMethod.POST)
    public String addFruit(Model model, BookEntity book) {
        if (bookService.insertBook(book) != null) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "deleteBook/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Integer id) {
        if (bookService.deleteBook(id)) {
            return "success";
        } else {
            return "fail";
        }
    }



    /**
     * 获取前端UserId
     * @param model
     * @param bookId
     */
    @RequestMapping(value = "getId", method = RequestMethod.POST)
    public void getByBookId(Model model, Integer[] bookId) {
        for (Integer i : bookId) {
            System.out.println(i);
        }
    }
}
