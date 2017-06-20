package com.dxm.test.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxm.test.springboot.domain.Person;
import com.dxm.test.springboot.mapper.PersonMapper;
import com.dxm.test.springboot.repository.PersonRepository;
  
@RestController  
public class DataController {  
      
    protected static Logger logger=LoggerFactory.getLogger(DataController.class);  
  
    @Autowired  
    PersonRepository personRepository;  
    
    @Autowired
    PersonMapper PersonMapper;
      
    @RequestMapping("/save")  
    public Person save(String name,String address,Integer age){  
        logger.debug("save 开始");  
        Person p=personRepository.save(new Person(null,name,age,address));  
        logger.debug("save 结束");  
        return p;  
    }  
      
    @RequestMapping("/q1")  
    public List<Person> q1(String address){  
        logger.debug("q1 开始");  
        logger.debug("q1 接收参数address={}",address);  
        List<Person> people=personRepository.findByAddress(address);  
        return people;  
    }  
      
    @RequestMapping("/q2")  
    public List<Person> q2(String name,String address){  
        logger.debug("q2 开始");  
        logger.debug("q2接收参数name={},address={}",name,address);  
        return personRepository.findByNameAndAddress(name, address);  
    }  
      
    @RequestMapping("/q3")  
    public List<Person> q3(String name,String address){  
        logger.debug("q3 开始");  
        logger.debug("q3接收参数name={},address={}",name,address);  
        return personRepository.withNameAndAddressQuery(name, address);  
    }  
      
    @RequestMapping("/sort")  
    public List<Person> sort(){  
        logger.debug("sort 开始");  
        List<Person> people=personRepository.findAll(new Sort(Direction.ASC,"age"));  
        return people;  
    }  
      
    @RequestMapping("/page")  
    public Page<Person> page(){  
        logger.debug("page 开始");  
        Page<Person> people=personRepository.findAll(new PageRequest(1,2));  
        return people;  
    }  
    
    /**
     * 离职证明23号才能拿到
     * @return
     */
    @RequestMapping("/getbymybatis")
    public List<Person> getByMybatis(String address){ 
    	logger.debug("getByMybatis 开始"); 
    	return PersonMapper.findByCountry(address);
    }
}  