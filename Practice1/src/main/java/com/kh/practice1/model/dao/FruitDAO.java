package com.kh.practice1.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.practice1.model.Fruit;

@Repository
public class FruitDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public int insertFruit(Fruit fruit) {
		return session.insert("fruit.insert", fruit);
	}
	
	public List<Fruit> selectFruit() {
		return session.selectList("fruit.select");
	}
	
}
