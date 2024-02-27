package org.dnyanyog.controller;


import java.util.List;



import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.dto.User;
import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.entity.Users;
//import org.dnyanyog.services.LoginServiceImpl;
import org.dnyanyog.services.UserManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController {

	@Autowired
	UserManagementServiceImpl userService;
	
	
	@PostMapping
	(path="/auth/user",consumes={"application/json","application/xml"},
			produces={"application/json","application/xml"})
	public AddUserResponse addUpdateUser(@RequestBody AddUserRequest userRequest)
	{
		return userService.addUpdateUser(userRequest);
	}
	@GetMapping(path="/auth/user/{userId}")
	public User getSignalUser(@PathVariable Long userId) {
		return userService.getSingleUser(userId);
	}
	@DeleteMapping(path="/auth/deleteuser/{userId}")
	public void deletetSignalUser(@PathVariable Long userId) {
		 userService.deletetSingleUser(userId);
	}
	@PostMapping
	(path="/auth/updateuser/{userId}",consumes={"application/json","application/xml"},
			produces={"application/json","application/xml"})
	public AddUserResponse UpdateUser(@RequestBody AddUserRequest userRequest,@PathVariable Long userId)
	{
		return userService.UpdateUser( userId,userRequest);
	}
	@GetMapping(path="/auth/user")
	public List<Users>getAllUser(){
		return userService.getAllUser();
	}
	@GetMapping(path="/auth/user_ids")
	public List<Long>getAllIds(){
		return userService.getAllUserIds();
	}
	
}
