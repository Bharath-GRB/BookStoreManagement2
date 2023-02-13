package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Book;
import com.cg.exception.BookNotFoundException;
import com.cg.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public String addBook(Book b) {
		bookRepository.saveAndFlush(b);
		return "Books Added Successfully";
	}

	public List<Book> listAllBooks() {

		return bookRepository.findAll();
	}

	public void delete(int bookId) {
		bookRepository.deleteById(bookId);

	}

	public Book editBookbyId(int bookId) {
		if (!bookRepository.existsById(bookId)) {
			throw new BookNotFoundException("Book Not Found");
		} else {
			Book book = bookRepository.getReferenceById(bookId);
			book.setTitle(book.getTitle());
			book.setAuthor(book.getAuthor());
			book.setCategory(book.getCategory());
			book.setDescription(book.getDescription());
			book.setIsbn(book.getIsbn());
			book.setPrice(book.getPrice());
			book.setPublishDate(book.getPublishDate());
			book.setLastUpdatedOn(book.getLastUpdatedOn());

			bookRepository.save(book);
			return book;
		}
	}

	public Book viewById(int bookId) {
		return bookRepository.findById(bookId).get();
	}

	public List<Book> listBooksByCategory(String category) {
		return bookRepository.findBooksByCategory(category);

	}

}
