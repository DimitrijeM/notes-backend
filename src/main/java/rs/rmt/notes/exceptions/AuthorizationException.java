package rs.rmt.notes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.UNAUTHORIZED)
public class AuthorizationException extends Exception{
	
	public AuthorizationException(String message) {
		super(message);
	}
	
	

}
