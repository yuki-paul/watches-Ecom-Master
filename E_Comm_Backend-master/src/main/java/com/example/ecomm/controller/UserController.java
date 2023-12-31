package com.example.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.entity.LoginRequest;
import com.example.ecomm.entity.SignupRequest;
import com.example.ecomm.entity.User;
import com.example.ecomm.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/Login")
	public ResponseEntity<?> loginController(@RequestBody LoginRequest loginCredentials) {
		User user = userService.loginService(loginCredentials.getEmail(), loginCredentials.getPassword());
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.badRequest().body("User name or password wrong");
		}
	}

	@PostMapping("/Register")
	public ResponseEntity<?> signupControllerCustomer(@RequestBody SignupRequest signupRequest) {
		return ResponseEntity.ok(userService.signupServiceCustomer(signupRequest));
	}

	@PostMapping("/AdminRegister")
	public ResponseEntity<?> signupControllerAdmin(@RequestBody SignupRequest signupRequest) {
		return ResponseEntity.ok(userService.signupService(signupRequest));
	}

}
