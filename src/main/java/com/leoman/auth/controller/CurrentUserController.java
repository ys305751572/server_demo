package com.leoman.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
@Controller
public class CurrentUserController {

	@RequestMapping("/findAllMenuByCurrnetUser")
	public void findAllMenuByCurrnetUser() {
		
	}
}
