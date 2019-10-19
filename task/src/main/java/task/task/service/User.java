package task.task.service;

import java.util.List;

import task.task.model.Users;

public interface User {

	List<Users> getUsers();

	Users checkUser(String username,String password);

	Users checkName(String username);

	void insert(String username,String password);

	void delete(String username,String password);

	void update(String username,String password,String modify);

}
