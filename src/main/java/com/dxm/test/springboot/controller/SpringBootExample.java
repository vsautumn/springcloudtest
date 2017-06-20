package com.dxm.test.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
 * 等同效果
 * @SpringBootApplication=@Configuration + @EnableAutoConfiguration +
 * @ComponentScan 　
 * @Configuration,@ComponentSca这俩注解语法是spring框架中的。起步于spring 3.x
 * @EnableAutoConfiguration是spring boot语法，表示自动配置。
 */
public class SpringBootExample {
	protected static Logger logger = LoggerFactory
			.getLogger(SpringBootExample.class);

	@ResponseBody
	@RequestMapping(value = "/")
	String location() {
		logger.debug("###location");
		return "主站地址";
	}

	@RequestMapping("/hello/{myName}")
	String index(@PathVariable String myName) {
		logger.debug("###index");
		return "Hello " + myName + "!!!";
	}
}
