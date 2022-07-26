package com.example.borrowbooks.controller;

import com.example.borrowbooks.model.Book;
import com.example.borrowbooks.model.UserBorrow;
import com.example.borrowbooks.service.IBookService;
import com.example.borrowbooks.service.IUserBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IUserBorrowService userBorrowService;


    @GetMapping("")
    public String showList(Model model) {
        List<Book> bookList = bookService.findAllBook();
        model.addAttribute("bookList", bookList);
        return "list";
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        List<Book> bookList = bookService.findAllBook();
        model.addAttribute("bookList", bookList);
        model.addAttribute("userBorrow", new UserBorrow());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("userBorrow") UserBorrow userBorrow, RedirectAttributes redirectAttributes) {
        Book book = bookService.findById(userBorrow.getBook().getBookId());
        if (book.getQuantity() == 0) {
            redirectAttributes.addFlashAttribute("messaga", "M??n th?t b?i, sách ?ã h?t");
        } else {
            book.setQuantity(book.getQuantity() - 1);
            bookService.save(book);
            userBorrowService.save(userBorrow);
            redirectAttributes.addFlashAttribute("message", "M??n thành công");

        }
        return "redirect:/book";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "view";
    }

    @GetMapping("pay")
    public String payBook(@RequestParam("payBook") Long code, RedirectAttributes redirectAttributes) {
        UserBorrow userBorrow = userBorrowService.findByCode(code);
        if (userBorrow == null) {
            redirectAttributes.addFlashAttribute("message", "Mã sách không t?n t?i!");
        } else {
            Book book = bookService.findById(userBorrow.getBook().getBookId());
            book.setQuantity(book.getQuantity() + 1);
            userBorrowService.remove(userBorrow);
            redirectAttributes.addFlashAttribute("message", "Tr? sách thành công!");
        }
        return "redirect:/book";
    }
}
