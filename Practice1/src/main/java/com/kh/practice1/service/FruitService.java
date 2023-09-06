package com.kh.practice1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.practice1.model.Fruit;
import com.kh.practice1.model.dao.FruitDAO;

@Service
public class FruitService {
	
	@Autowired
	private FruitDAO dao;
	
	public int insertFruit(Fruit fruit) {
		return dao.insertFruit(fruit);
	}
	
}
