package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}