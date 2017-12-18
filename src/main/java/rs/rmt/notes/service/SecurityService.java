package rs.rmt.notes.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.exceptions.AuthorizationException;

@Service
public interface SecurityService {
	
	public UserEntity authenticateUser(HttpServletRequest request, int userId) throws AuthorizationException;

}
