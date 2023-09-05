package com.kh.practice1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.practice1.service.FruitService;

@Controller
public class FruitController {
	
	public FruitService service;
	
	@GetMapping("/insert")
	public void insert() {}
}
