package com.mobydigitalrrhh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

	@GetMapping("/")
	public String prueba() {
		return "HOLAXD";
	}
	
	@GetMapping("/restricted")
	public String restricted() {
		return "bien ahí crack entraste";
	}
	

}
