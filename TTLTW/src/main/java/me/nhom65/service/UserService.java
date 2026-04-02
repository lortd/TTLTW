package me.nhom65.service;

import java.util.List;

import me.nhom65.dao.UserDAO;
import me.nhom65.model.User;

public class UserService {
	
	private UserDAO userDAO;
	
	public UserService() {
		this.userDAO = new UserDAO();
	}
	
	public List<User> getAllUsers(){
		return this.userDAO.getAllUsers();
	}
	
	public User getUserByName(String username) {
        return userDAO.findByUsername(username);
    }
	public boolean addUser(String username, String password, String confirmPassword, String gmail, String phone, String address) {
		return userDAO.createUser(username, confirmPassword, gmail, phone, address);
	}
	
	
}
