package com.revature.services;

import java.util.Optional;
import java.util.Scanner;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

/**
 * The UserService should handle the processing and retrieval of Users for the ERS application.
 *
 * {@code getByUsername} is the only method required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create User</li>
 *     <li>Update User Information</li>
 *     <li>Get Users by ID</li>
 *     <li>Get Users by Email</li>
 *     <li>Get All Users</li>
 * </ul>
 */
public class UserService {

	/**
	 *     Should retrieve a User with the corresponding username or an empty optional if there is no match.
     */
 	UserDAO userDAO = new UserDAO();

	public Optional<User> getByUsername(String username) {
		return Optional.empty();
	}

	public void updateEmployee(User updatedEmployee){}


	public User create(User userToBeRegistered) {

		UserDAO ru = new UserDAO();
		ru.create(userToBeRegistered);

		return userToBeRegistered;
	}
public User getByIdUser(int userId){
		return userDAO.getbyIDUser(userId);
}


	}

