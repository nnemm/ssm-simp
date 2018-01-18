package service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import mapper.UserMapper;
import model.User;

@Service
public class UserService {
	
	@Autowired
	UserMapper mapper;
	
	public User findSelectByName(User user){
		return  mapper.selectByName(user);
		
	}
}
