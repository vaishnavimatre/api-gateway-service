package org.dnyanyog.services;







import java.util.ArrayList;
import java.util.List;


import java.util.Optional;

import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.dto.User;

import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserManagementServiceImpl implements UserManagementService{

@Autowired
UsersRepository userRepo;

@Autowired
AddUserResponse userresponse;

@Autowired
AddUserResponse userIds;



public AddUserResponse  addUpdateUser(AddUserRequest request){
	
	  
	Users UsersTable= Users.getInstance()
		.setAge(request.getAge())
	    .setEmail(request.getEmail())
	     .setPassword(request.getPassword())
	      .setUser_name(request.getUser_name());
	
	UsersTable =userRepo.save(UsersTable);
	
	userresponse.setMessage("user added Successfully");
	userresponse.setStatus("Success");
	userresponse.setUser_id(UsersTable.getUser_id());
	userresponse.setAge(UsersTable.getAge());
	userresponse.setEmail(UsersTable.getEmail());
	userresponse.setPassword(UsersTable.getPassword());
	userresponse.setUser_name(UsersTable.getUser_name());
		
	return userresponse;
	
	
	
}
public AddUserResponse  UpdateUser(Long user_id, AddUserRequest request){
	
	  
	Optional<Users>receivedData=userRepo.findById(user_id);
	if(receivedData.isPresent()) {
			Users UsersTable=Users.getInstance()
				 .setAge(request.getAge())
				 .setEmail(request.getEmail())
			     .setPassword(request.getPassword())
				 .setUser_name(request.getUser_name())
			      .setUser_id(user_id);
	UsersTable =userRepo.save(UsersTable);
	
	userresponse.setMessage("user updated Successfully");
	userresponse.setStatus("Success");
	userresponse.setUser_id(UsersTable.getUser_id());
	userresponse.setAge(UsersTable.getAge());
	userresponse.setEmail(UsersTable.getEmail());
	userresponse.setPassword(UsersTable.getPassword());
	userresponse.setUser_name(UsersTable.getUser_name());
			}
	return userresponse;
	
	
	
	
	
}



public User getSingleUser(Long userId) {
	User userResponse =new User();
	
	Optional<Users>receivedData=userRepo.findById(userId);
	if(receivedData.isEmpty()) {
		userResponse.setStatus("Fail");
		userResponse.setMessage("User  not Found");
			}else {
				Users user=receivedData.get();
				userResponse.setStatus("Success");
				userResponse.setMessage("User Found");
				userResponse.setUser_id(user.getUser_id());
				userResponse.setAge(user.getAge());
				userResponse.setEmail(user.getEmail());
				userResponse.setPassword(user.getPassword());
				userResponse.setUser_name(user.getUser_name());
				//return userResponse;
			}
	return userResponse;
}



public void deletetSingleUser(Long user_id) {
	User userResponse =new User();
	
	Optional<Users>receivedData=userRepo.findById(user_id);
	if(receivedData.isPresent()) {
		userRepo.deleteById(user_id);
		userResponse.setUser_id(user_id);		
				userResponse.setStatus("Success");
				userResponse.setMessage("User deleted");
		
				//return userResponse;
			}
	
	
}
public List<Users>getAllUser(){
	return userRepo.findAll();
}
@Override
public List<Long> getAllUserIds() {
	
	return null;
}

}