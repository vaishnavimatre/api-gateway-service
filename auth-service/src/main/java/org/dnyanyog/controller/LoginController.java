package org.dnyanyog.controller;

import org.dnyanyog.dto.LoginRequest;

import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.services.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
	@Autowired
	LoginServiceImpl loginService;
@PostMapping(path="/auth/validate")
public LoginResponse validate(@RequestBody LoginRequest loginRequest)
{
	LoginResponse response=new LoginResponse();
	if(loginRequest.getUser_name().equalsIgnoreCase("vaishnavi")&&loginRequest.getPassword().equals("Pass@123")) {
		response.setStatus("Success");
		response.setMessage("Login Successful");
		
	}
	else {
		response.setStatus("fail");
		response.setMessage("Login Failure");
	}
	return response;
}

}
