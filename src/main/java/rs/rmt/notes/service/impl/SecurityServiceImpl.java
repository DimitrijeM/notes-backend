package rs.rmt.notes.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.rmt.notes.dao.UserRepository;
import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.exceptions.AuthorizationException;
import rs.rmt.notes.service.SecurityService;


@Service
public class SecurityServiceImpl implements SecurityService{
	
	@Autowired
	UserRepository userRepository;
	
	
	public UserEntity authenticateUser(HttpServletRequest request, String username) throws AuthorizationException{
		final String auth_username = request.getHeader("AUTH_USERNAME");
		final String auth_password = request.getHeader("AUTH_PASSWORD");

		List<UserEntity> users = userRepository.findByUsername(auth_username);
//		for (UserEntity user: users) {
//			System.out.println(user.getUsername() + " " + user.getPassword());
//		}
		
		if(users == null || users.size() != 1) 
			throw new AuthorizationException("User with username " + auth_username + " doesn't exist.");
		
		UserEntity user = users.get(0);
		
		if(!user.getUsername().equals(username))
			throw new AuthorizationException("URL and auth params don't match.");

		if(!user.getPassword().equals(auth_password))
			throw new AuthorizationException("Wrong password");
		
		return user;

	}
}
