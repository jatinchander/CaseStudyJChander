package com.casestudy.jatin.chander.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.jatin.chander.model.Categories;
import com.casestudy.jatin.chander.repository.CategoriesRepository;

@Service
public class CategoriesService {
	
	@Autowired
	CategoriesRepository categoriesRepo;
	
	public void saveCategories(Set<Categories> categories) {
		categoriesRepo.saveAll(categories);
	}
	
	public void saveCategory(Categories category) {
		categoriesRepo.save(category);
	}

}
