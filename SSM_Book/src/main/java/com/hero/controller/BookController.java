package com.hero.controller;

import com.hero.pojo.Books;
import com.hero.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Heroxin
 * @create 2022-03-27-21:24
 * @Description:
 */


// 点击页面按钮 --> contrloller --> 返回视图与模型
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

//    查询所有书籍的请求
    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<Books> booksList = bookService.findAll();

        modelAndView.addObject("bookList",booksList);

        modelAndView.setViewName("findAll");
        return modelAndView;
    }

//    跳转到添加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddBook(Books book){
        return "insert";
    }

//    添加书籍请求
    @RequestMapping("/addbook")
    public String addBook(Books books){
        bookService.insertBook(books);
        return "redirect:/book/findAll";
    }

//    删除书籍请求
    @RequestMapping("/del/{bookId}")
    public String delBook(@PathVariable(value = "bookId") int bookId){
        bookService.deleteBook(bookId);
        return "redirect:/book/findAll";
    }

//    跳转到修改页面
    @RequestMapping("/toUpdateBook/{bookId}")
    public ModelAndView toUpdateBook(@PathVariable("bookId") int bookId){
        ModelAndView modelAndView = new ModelAndView();
        Books bookById = bookService.findBookById(bookId);
        modelAndView.addObject("qbook",bookById);
        modelAndView.setViewName("update");
        return modelAndView;
    }

//    修改书籍请求
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println(books);
       bookService.updateBook(books);
        return "redirect:/book/findAll";
    }


}
