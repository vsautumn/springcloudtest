package com.dxm.test.springboot.mapper;

import java.util.List;

import com.dxm.test.springboot.domain.Person;

public interface PersonMapper {
	public List<Person> findByCountry(String address);
}
