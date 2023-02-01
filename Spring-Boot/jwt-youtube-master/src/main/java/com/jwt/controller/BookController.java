package com.jwt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.entity.Books;
import com.jwt.service.BookService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	@PostMapping("/newBook")
	public Books registerNewBook(@RequestBody Books book) {
		return bookService.newBookRegister(book);
	}
	
	@GetMapping("/getBookById/{id}")
	public Optional<Books> getBookById(@PathVariable("id") long id) {
		return bookService.getBookById(id);
	}
	
	@GetMapping("/getAllBooks")
	public List<Books> getAllBooks(){
		return bookService.getAllBook();
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public void deleteBook(@PathVariable("id") long id) {
		bookService.deleteBook(id);
	}
	@PutMapping("/editBookById/{id}")
	public void updateBook(@RequestBody Books book,@PathVariable("id") long id) {
		System.out.println(book+""+id);
		bookService.updateBook(book);
	}
//	@PutMapping("/sendRequest/{id}")
//	public void sendRequest(@RequestBody Books book,@PathVariable("id") long id) {
//		Books bookDetails=bookService.getBookById(id).get();
//		 bookService.editBookAvailable(Integer.parseInt(bookDetails.getBookAvailable()),id);
//	}

}