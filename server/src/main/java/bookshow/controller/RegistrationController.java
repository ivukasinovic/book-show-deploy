package bookshow.controller;



import bookshow.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.users.Role;
import bookshow.domain.users.User;
import bookshow.service.UserService;

@RestController
public class RegistrationController {

	@Autowired
    private UserService UserService;

	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		User newUser = UserService.findByUsername(user.getUsername());
		User mailUser = UserService.findByEmail(user.getEmail());
		
		if(newUser != null){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		if(mailUser!=null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		newUser = user;
		newUser.setActivated(false);
		newUser.setRole(Role.USER);
		//newUser.setIstorijaPoseta("");
		newUser.setPasswordHash(new BCryptPasswordEncoder().encode(user.getPasswordHash()));	
		newUser.setPoints((long) 0);
		newUser.setChangedPassword(false);
		mailService.sendActivationMail(newUser.getUsername(),newUser.getEmail());
		UserService.save(newUser);

		return new ResponseEntity<>(newUser,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/accountActivation/{username}", method = RequestMethod.GET)
	public ResponseEntity<User> activateUser(@PathVariable("username") String username) {
		User activatedUser = UserService.findByUsername(username);
		activatedUser.setActivated(true);
		UserService.save(activatedUser);
		return new ResponseEntity<>(activatedUser,HttpStatus.OK);
		
	}
	

}
