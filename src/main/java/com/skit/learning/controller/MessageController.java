package com.skit.learning.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skit.learning.util.DBUtil;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	@RequestMapping("/message/{userName}")
	public String getMessage(@PathVariable String userName){
		String message = "Hello, "+userName;
		return message;
	}
	
	@RequestMapping("/greetings/{name}")
	public String getGreeting(@PathVariable("name") String uname){
		return "Hello ,"+uname;
	}
	
	@RequestMapping("/goodmorning")
	public String goodMorning(@RequestParam String name){
		DBUtil.readeData();
		return "GoodMorning, "+name;
	}

}
