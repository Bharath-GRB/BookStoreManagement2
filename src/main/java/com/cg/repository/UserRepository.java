package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
User findByUserId(int userId);
	
}
