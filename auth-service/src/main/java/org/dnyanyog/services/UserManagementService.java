package org.dnyanyog.services;

import java.util.List;

import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.dto.User;
import org.dnyanyog.entity.Users;

public interface UserManagementService {
	AddUserResponse  addUpdateUser(AddUserRequest request);
	AddUserResponse  UpdateUser(Long user_id, AddUserRequest request);
	 User getSingleUser(Long userId);
	 void deletetSingleUser(Long user_id);
	 List<Users>getAllUser();
	 List<Long>getAllUserIds();
}
