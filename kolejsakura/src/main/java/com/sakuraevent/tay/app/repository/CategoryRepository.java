package com.sakuraevent.tay.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sakuraevent.tay.app.*;
import com.sakuraevent.tay.app.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
	Category findByCategoryType(String categoryType);	
}
