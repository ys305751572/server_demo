package com.leoman.admin.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leoman.admin.login.entity.LoginCommand;

@RequestMapping
@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public void login(LoginCommand command) {
		
	}
}
