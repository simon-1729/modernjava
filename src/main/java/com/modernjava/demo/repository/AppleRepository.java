package com.modernjava.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.modernjava.demo.model.Apple;
import com.modernjava.demo.model.AppleColor;

public interface AppleRepository extends CrudRepository<Apple, Long> {

	List<Apple> findByColor(AppleColor appleColor);

	List<Apple> findAll();
}