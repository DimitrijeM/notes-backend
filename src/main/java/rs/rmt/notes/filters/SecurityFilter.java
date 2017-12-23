package rs.rmt.notes.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import rs.rmt.notes.domain.UserEntity;
import rs.rmt.notes.exceptions.AuthorizationException;
import rs.rmt.notes.service.SecurityService;

@Component
public class SecurityFilter implements Filter{

	@Autowired 
	SecurityService securityService;
	
	
    private static Logger logger = LoggerFactory.getLogger(SecurityFilter.class);


	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

		System.out.println("Request URI: "+request.getRequestURI());
            if(!request.getRequestURI().contains("note")) {
            	logger.info("NO SECURE NEEDED FOR THIS API REQUEST : {} ", request.getRequestURI().toString());
                chain.doFilter(servletRequest, servletResponse);
            }
            else {

				UserEntity user;
				logger.info("USER AUTHORIZATION IS NEEEDED FOR THIS API REQUEST: {}", request.getRequestURI().toString());
				String uri = request.getRequestURI().toString();
				String[] uriParts = uri.split("/");
				// username is the second part
				String username = uriParts[2];
//				System.out.println(userId + "");

				try {
					user = securityService.authenticateUser(request, username);
				} catch (AuthorizationException e) {
					response.setStatus(401);
					response.setHeader("message", e.getMessage());
					return;
//					throw new IOException(e.getMessage());
				}

				if (user != null){
					System.out.println("User: " + user.getUsername());
					chain.doFilter(servletRequest, servletResponse);

				}
			}
	}
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
