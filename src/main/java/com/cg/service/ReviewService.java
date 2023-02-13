package com.cg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Book;
import com.cg.entity.Customer;
import com.cg.entity.Review;
import com.cg.exception.ReviewNotFoundException;
import com.cg.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepository;

	public String addReview(Review review) {
		reviewRepository.saveAndFlush(review);
		return "Reviews Added Successfully";
	}

	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}

	public Review getReviewById(int id) {
		return reviewRepository.findById(id).get();
	}

	public void delete(int id) {
		reviewRepository.deleteById(id);
	}

	public List<Review> listAllReviewsByBook(Book book) {
		return reviewRepository.listAllReviewsByBook(book);
	}

	public List<Review> listAllReviewsByCustomer(Customer customer) {
		return reviewRepository.listAllReviewsByCustomer(customer);
	}

	public Review updateReview(@RequestBody Review review) {
		if (!reviewRepository.existsById(review.getReviewId())) {
			throw new ReviewNotFoundException("review not found");
		} else {
			Review r = reviewRepository.findById(review.getReviewId()).get();
			r.setHeadline(review.getHeadline());
			r.setComment(review.getComment());
			r.setRating(review.getRating());
			r.setReviewOn(review.getReviewOn());

			reviewRepository.save(r);

			return r;
		}
	}
}