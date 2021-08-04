package com.spring.crud.controller;

import java.util.ArrayList;

import com.spring.crud.config.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JwtController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @GetMapping(value = "/jwtGenerate")
	public ResponseEntity<String> generateAuthenticationToken() throws Exception {
		UserDetails userDetails = new User("springCrudUser", "springUserPass", new ArrayList<>());
		String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(token);
	}
}
