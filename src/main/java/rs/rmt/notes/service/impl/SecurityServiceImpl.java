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
	
	
	public UserEntity authenticateUser(HttpServletRequest request, int userId) throws AuthorizationException{
		final String username = request.getHeader("AUTH_USERNAME");
		final String password = request.getHeader("AUTH_PASSWORD");
		
//		System.out.println(username + "   " + password);
		
		List<UserEntity> users = userRepository.findByUsername(username);
		
		if(users == null || users.size() != 1) 
			throw new AuthorizationException("User with this username doesn't exist.");
		
		UserEntity user = users.get(0);
		
		if(user.getId() != userId) 
			throw new AuthorizationException("URL and auth params don't match.");

		if(!user.getPassword().equals(password))
			throw new AuthorizationException("Wrong password");
		
		return user;

	}
}
