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

import com.cg.entity.Review;
import com.cg.repository.ReviewRepository;
import com.cg.service.ReviewService;

@ExtendWith(MockitoExtension.class)
public class TestReviewService {
	@Mock
	ReviewRepository rrepo;

	@InjectMocks
	private ReviewService reviewService;

	@Test
	public void getAllReviewTest() {
		List<Review> list = new ArrayList<Review>();
		Review r1 = new Review();
		Review r2 = new Review();
		list.add(r1);
		list.add(r2);
		when(reviewService.getAllReviews()).thenReturn(list);
		assertEquals(2,reviewService.getAllReviews().size());

	}

}
