package com.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.BookDao;

import com.jwt.entity.Books;

@Service
public class BookService {
	@Autowired
	private BookDao bookDao;
	public Books newBookRegister(Books book) {
		return bookDao.save(book);
	}
//	
//	public Optional<Books> getBookById(long id) {
//		return bookDao.findById(id);
//	}
	public Optional<Books> getBookById(long id) {
		return bookDao.findById(id);
	}
	
	public List<Books> getAllBook() {
		return (List<Books>) bookDao.findAll();
	}
	
	public void deleteBook(long id) {
		bookDao.deleteById(id);
	}

	public Books updateBook(Books book) {
		return bookDao.save(book);
		
	}
//	public Books editBookAvailable(int bookAvailable, long id) {
//		 return bookDao.save(bookDao.updateBookAvailable( bookAvailable,id));
//	}

}