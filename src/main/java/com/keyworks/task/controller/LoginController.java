package com.keyworks.task.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@GetMapping
	@RequestMapping("/login")
	public String login(@PathParam(value = "erro") Boolean erro, Model model) {
		model.addAttribute("erro", erro);
		return "login";
	}
}
