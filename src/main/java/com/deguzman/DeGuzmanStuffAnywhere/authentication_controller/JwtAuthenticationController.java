//package com.deguzman.DeGuzmanStuffAnywhere.authentication_controller;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.deguzman.DeGuzmanStuffAnywhere.authentication_models.JwtRequest;
//import com.deguzman.DeGuzmanStuffAnywhere.authentication_models.JwtResponse;
//import com.deguzman.DeGuzmanStuffAnywhere.authentication_service.JwtUserDetailsService;
//import com.deguzman.DeGuzmanStuffAnywhere.model.Users;
//
//@RestController
//@CrossOrigin
//public class JwtAuthenticationController {
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@Autowired
//	private JwtUserDetailsService jwtUserDetailsService;
//	
//	Date date = new Date();
//	
//	
//	@RequestMapping(value = "/login", method = RequestMethod.POST,consumes={"application/json"})
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//		
//		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//		final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//		
//		Users user = jwtUserDetailsService.checkingLoggingInUser(authenticationRequest.getUsername());
//		
//		System.out.println(user.username + " " + "is logging in!");
//		
//		String token = "";
//
//		return ResponseEntity.ok(new JwtResponse(token));
//	}
//	
//	@CrossOrigin
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public ResponseEntity<?> saveUser(@RequestBody Users user) throws Exception {
//		return ResponseEntity.ok(jwtUserDetailsService.save(user));
//	}
//
//	@CrossOrigin
//	private void authenticate(String username, String password) throws Exception {
//		try {
//			
//			UserDetails authenticatingUser = jwtUserDetailsService.loadUserByUsername(username);
//			System.out.println(authenticatingUser.getPassword() + "this is the user");
//			
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//			
//		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);
//		}
//	}
//}
