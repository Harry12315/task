package task.task.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import task.task.mapper.UsersMapper;
import task.task.model.Users;
import task.task.service.User;

@Service
public class UserImpl implements User{

	@Autowired
	private UsersMapper usersMapper;

	@Override
	public List<Users> getUsers() {
		List<Users> users = usersMapper.getUsers();
		return users;
	}

	@Override
	public Users checkName(String username) {
		Users users = usersMapper.checkName(username);
		return users;
	}

	@Override
	public Users checkUser(String username,String password) {
		Users users = usersMapper.checkUser(username,password);
		return users;
	}

	@Override
	public void insert(String username, String password) {
		usersMapper.insert(username, password);

	}

	@Override
	public void delete(String username,String password) {
		usersMapper.delete(username,password);

	}

	@Override
	public void update(String username,String password,String modify) {
		usersMapper.update(username,password,modify);

	}
}
