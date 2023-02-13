package com.cg.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.entity.Book;
import com.cg.repository.BookRepository;
import com.cg.service.BookService;


@ExtendWith(MockitoExtension.class)
public class TestBookService {
	@Mock
	BookRepository brepo;

	@InjectMocks
	private BookService bookService;

	@Test
	public void getAllBookTest() {
		List<Book> list = new ArrayList<Book>();
		Book  b1 = new Book();
		Book b2 = new Book();
		list.add(b1);
		list.add(b2);
		when(bookService.listAllBooks()).thenReturn(list);
		assertEquals(2,bookService.listAllBooks().size());

	}

}
