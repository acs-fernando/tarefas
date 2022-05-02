package com.keyworks.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main")
public class MainController {
	
	@GetMapping("/formulario")
	public String dashboard() {
		return "main/formulario";
	}
	
}
