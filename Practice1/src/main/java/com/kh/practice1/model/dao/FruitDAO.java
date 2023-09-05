package com.kh.practice1.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.practice1.model.Fruit;

@Repository
public class FruitDAO {
	
	private SqlSessionTemplate session;
	
	public int insertFruit(Fruit fruit) {
		return session.insert("fruit.insert", fruit);
	}
	
}
