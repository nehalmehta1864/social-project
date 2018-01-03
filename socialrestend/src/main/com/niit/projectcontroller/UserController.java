package com.niit.projectcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.socialbackend.dao.UsersDAO;
import com.niit.socialbackend.model.Users;

@RestController
public class UserController {

	@Autowired
	private UsersDAO userDAO;

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Users> getAllUser() {
		return userDAO.getAllUser(); 
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Users> createUser(@RequestBody Users user) {
		user.setIsOnline("N");
		user.setRole("USER");
		boolean isSaved = userDAO.saveUser(user);
		if (isSaved)
			return new ResponseEntity<Users>(user, HttpStatus.OK);
		else
			return new ResponseEntity<Users>(user, HttpStatus.METHOD_FAILURE);
	}

	@PostMapping("/login")
	public ResponseEntity <Users> checkLogin(@RequestBody Users user, HttpSession session) {		
		if (userDAO.checkLogin(user)) {
			System.out.println("logging"); 
			Users tempUser = userDAO.getUser(user.getUsername());
			userDAO.updateOnlineStatus("Y", tempUser);
			session.setAttribute("username:", user.getUsername());
			System.out.println("User Controller::"+user.getUsername());			
			return new ResponseEntity<Users>(tempUser, HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<Users>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/logout/{username}")
	public ResponseEntity<String> loggingout(@PathVariable("username") String username) {
		Users user = userDAO.getUser(username);
		if (userDAO.updateOnlineStatus("N", user)) {
			return new ResponseEntity<String>("Successful logout", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("error in logout", HttpStatus.METHOD_FAILURE);
		}
	}

}