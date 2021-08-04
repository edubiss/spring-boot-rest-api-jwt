package com.spring.crud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StatusController {
    
    @GetMapping(value = "/status")
	public ResponseEntity<String> generateAuthenticationToken() throws Exception {
		return ResponseEntity.ok("Rest API Running...");
	}
}
