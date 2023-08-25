package com.kh.opendata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OpenAPIController {
	
	// Json형식으로 대기오염 OpenAPI 활용하기
	
	@GetMapping("/air")
	public String airMethod(String location) {
		return null;
	}
}
