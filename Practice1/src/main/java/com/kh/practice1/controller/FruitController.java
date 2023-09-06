package com.kh.practice1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.practice1.model.Fruit;
import com.kh.practice1.service.FruitService;

@Controller
public class FruitController {
	@Autowired
	private FruitService service;
	
	@GetMapping("/insert")
	public void insert() {
		
	}
	@PostMapping("/insert")
	public String insert(Fruit fruit) {
		
		service.insertFruit(fruit);
		return "home.jsp";
	}
	
}
