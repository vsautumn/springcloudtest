package com.dxm.test.springboot.dao;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.dxm.test.springboot.domain.Person;

@Service
public class PersonDao {

	@Autowired
	RedisTemplate<Object, Object> redisTemplate;

	@Resource(name = "redisTemplate")
	ValueOperations<Object, Object> valOps;

	public void save(Person person) {
		valOps.set(person.getId(), person);
	}

	public Person getPerson(String id) {
		return (Person) valOps.get(id);
	}
}
