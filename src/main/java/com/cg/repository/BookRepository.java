package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query("select b from Book b where b.category =category")
	public List<Book> findBooksByCategory(String category);

}
