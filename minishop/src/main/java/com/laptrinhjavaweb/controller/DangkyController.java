package com.laptrinhjavaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DangkyController {
	@RequestMapping("/dangky")
	public String dangky() {
		return "dangky";
	}
}
