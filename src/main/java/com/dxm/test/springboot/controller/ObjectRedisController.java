package com.dxm.test.springboot.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxm.test.springboot.dao.PersonDao;
import com.dxm.test.springboot.domain.Person;

@RestController
public class ObjectRedisController {

	protected static Logger logger = LoggerFactory
			.getLogger(ObjectRedisController.class);

	@Autowired
	PersonDao personDao;

	@RequestMapping("/setPerson")
	public void set(Long id, String name, Integer age) {
		logger.debug("访问setPerson:id={},name={},age={}", id, name, age);
		Person person = new Person(id, name, age,"地址值");
		personDao.save(person);
	}

	@RequestMapping("/getPerson")
	public Person getPerson(String id) {
		return personDao.getPerson(id);
	}

}