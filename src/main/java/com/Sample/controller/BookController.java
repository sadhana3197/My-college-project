package com.Sample.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Sample.entity.Book;
import com.Sample.service.BookService;
import com.Sample.service.MyBookListService;
import com.Sample.entity.MyBookList;

@Controller
public class BookController 
{
	  @Autowired
	  private BookService service;
	  
	  @Autowired
	  private MyBookListService myBookService;
	  
	  
      @GetMapping("/")
      public String home()
      {
    	  return "home";
      }
      @GetMapping("/book_register")
      public String bookRegister()
      {
    	  return "bookRegister";
      }
      @GetMapping("/available_books")
      public ModelAndView getAllBook()
      {
    	  List<Book>list=service.getAllBook();
//    	  ModelAndView m=new ModelAndview();
//    	  m.setViewName("bookList");
//    	  m.addObject("book",list);
    	  return new ModelAndView("bookList","book",list);
      }
      
      @PostMapping("/save")
      public String addBook(@ModelAttribute Book b)
      {
    	  service.save(b);
    	  return "redirect:/available_books";
      }
      @GetMapping("/my_books")
      public String getMyBooks(Model model)
      {
    	  List<MyBookList>list=myBookService.getAllMyBooks();
    	  model.addAttribute("book", list);

    	  return "myBooks";
      }
      @RequestMapping("/mylist/{id}")
      public String getMyList(@PathVariable("id") int id)
      {
    	  Book b=service.getBookById(id);
    	  MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
    	  myBookService.saveMyBooks(mb);
    	  return "redirect:/my_books";
      }
      
      
}
