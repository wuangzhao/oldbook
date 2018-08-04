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

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        List<BookEntity> bookEntityList = bookService.getAll();
        model.addAttribute("list", bookEntityList);
        return "list";
    }

//    @RequestMapping(value = "/detail/{bookId}", method = RequestMethod.GET, params = "bookId")
//    private String bookId(Model model, @PathVariable("bookId") Integer bookId) {
//        if (bookId == null) {
//            return "redirect:/book/list";
//        }
//        BookEntity book = bookService.getById(bookId);
//        if (book == null) {
//            return "redirect:/book/list";
//        }
//        model.addAttribute("book", book);
//        return "detail";
//    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    private String bookId(Model model, @RequestParam(value = "bookId", defaultValue = "") Integer bookId) {
        if (bookId == null) {
            return "redirect:/book/list";
        }
        BookEntity book = bookService.getById(bookId);
        if (book == null) {
            return "redirect:/book/list";
        }
        model.addAttribute("book", book);
        return "detail";
    }

    @RequestMapping(value = "bookName", method = RequestMethod.GET)
    private void bookName(Model model, @PathVariable("bookName") String bookName) {
        List<BookEntity> bookNameList = bookService.getByName(bookName);
        model.addAttribute("bookNameList", bookNameList);
    }
}
