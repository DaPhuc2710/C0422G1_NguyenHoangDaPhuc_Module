package com.example.library.controller;

import com.example.library.model.BookManager;
import com.example.library.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LibraryController {
    @Autowired
    private ILibraryService iLibraryService;

    @RequestMapping("/")
    public String goList(Model model) {
        model.addAttribute("bookList", iLibraryService.findAll());
        return "/list";
    }

    @GetMapping("/detailList")
    public String goDetail(@RequestParam int id, Model model) {
        BookManager manager = iLibraryService.findById(id);
        model.addAttribute("book", manager);
        return "/detail";
    }

    @GetMapping("/borrow")
    public String goBorrow(@RequestParam int id, RedirectAttributes redirectAttributes) throws Exception {
        BookManager bookManager = iLibraryService.findById(id);
        if (bookManager.getRemaining() == 0) {
            throw new Exception();
        }
        iLibraryService.borrowBook(id);
        redirectAttributes.addFlashAttribute("msg", "Mượn thành công");
        return "redirect:/";
    }

    @GetMapping("/payBack")
    public String goPayback(@RequestParam int id, RedirectAttributes redirectAttributes) throws Exception {
        BookManager bookManager = iLibraryService.findById(id);
        if (bookManager.getRemaining() == 0) {
            throw new Exception();
        }
        iLibraryService.payBack(id);
        redirectAttributes.addFlashAttribute("msg", "Trả thành công");
        return "redirect:/";
    }

    @ExceptionHandler(value = Exception.class)
    public String errors() {
        return "/errors";
    }

}
