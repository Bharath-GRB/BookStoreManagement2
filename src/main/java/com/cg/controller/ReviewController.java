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
import com.cg.entity.Customer;
import com.cg.entity.Review;
import com.cg.service.ReviewService;

@RequestMapping("/reviewapi")
@RestController
public class ReviewController {
	@Autowired

	private ReviewService reviewservice;

	@PostMapping("/addReview")

	public String addReview(@Valid @RequestBody Review review)
	{
		return reviewservice.addReview(review);

	}
	@GetMapping("/getAll")
	public List<Review> getAll()
	{
		return reviewservice.getAllReviews();
	}
	@GetMapping("/getById/{id}")
	public Review getReview(@PathVariable("id") int rid)
	{
		return reviewservice.getReviewById(rid);
	}
	@DeleteMapping("/deleteById/{id}")
	public void deleteReview(@PathVariable("id") int id)
	{
		reviewservice.delete(id);	
	}
	@PutMapping("/update")
	public Review updateReview(@Valid @RequestBody Review review)
	{
		return reviewservice.updateReview(review);
	}
	@GetMapping("/listAllReviewsByBook/{id}")
	public List<Review> listAllReviewsByBook(@PathVariable("id")Book book)
	{
		
		return reviewservice.listAllReviewsByBook(book);
	}
	@GetMapping("/listAllReviewsByCustomer/{id}")
	public List<Review> listAllReviewsByCustomer(@PathVariable("id")Customer customer)
	{
		return reviewservice.listAllReviewsByCustomer(customer); 
	}
}
