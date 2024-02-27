package org.dnyanyog.services;

import java.util.List;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.dto.User;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements  LoginService{
	@Autowired
	UsersRepository userRepo;
	
	public LoginResponse validateUser(LoginRequest loginRequest) {
		LoginResponse response =new LoginResponse();
		List<User>liUser =userRepo.findByUsernameAndPassword(loginRequest.getUser_name(), loginRequest.getPassword());
		if(liUser.size()==1) {
			response.setStatus("Success");
			response.setMessage("Login Successfull");
		}else {
			response.setStatus("Fail");
			response.setMessage("Login Failed");
			
		}
		return response;
		
	}
}

