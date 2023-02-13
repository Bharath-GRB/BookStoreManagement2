package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Book;
import com.cg.service.BookService;

@RequestMapping("/bookapi")
@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBook")
	public String addBook(@Valid @RequestBody Book b) {
		
		return bookService.addBook(b);
	}
	
	@GetMapping("/getAll")
	public List<Book> getAll(){
		return bookService.listAllBooks();
	}
	
	@DeleteMapping("/deleteById/{id}")
	   public void deleteBook(@PathVariable("id") int bookId)   
	   {  
			bookService.delete(bookId);  
	   } 
	
	@PutMapping("/edit/{id}")
	   public Book editBookById(@Valid @PathVariable("id")int bookId)
	   {
		   return bookService.editBookbyId(bookId);
	   }
	
	@GetMapping("/viewById/{id}")
	public Book viewById(@PathVariable("id") int bookId ) {
		return bookService.viewById(bookId);
	}
	
	@GetMapping("/getbooksBycategory/{stk}")
	public List<Book> getAllBooksByCategory(@PathVariable("stk") String category){
		return bookService.listBooksByCategory(category);
	}
}
