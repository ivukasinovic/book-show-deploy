package bookshow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.users.Request;
import bookshow.domain.users.User;
import bookshow.domain.users.Friendship;
import bookshow.service.UserService;
import bookshow.service.FriendshipService;
import bookshow.service.RequestService;

@RestController
public class FriendsController {

	@Autowired
	private UserService UserService;

	@Autowired
	private RequestService RequestService;
	
	@Autowired
	private FriendshipService FriendshipService;

	@RequestMapping(value = "/searchPeople/{usernamePart}/{namePart}/{surnamePart}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<String>> searchPeople(@PathVariable("usernamePart") String usernamePart,
			@PathVariable("namePart") String namePart, @PathVariable("surnamePart") String surnamePart) {
		
		List<User> lista = UserService.findAll();
		ArrayList<String> retVal = new ArrayList<String>();
		
		for(User u : lista) {
			if(u.getUsername().toLowerCase().contains(usernamePart.toLowerCase().trim())
					&& u.getName().toLowerCase().contains(namePart.toLowerCase().trim())
					&& u.getSurname().toLowerCase().contains(surnamePart.toLowerCase().trim())){
				retVal.add(u.getUsername());
			}
		}
		
		return new ResponseEntity<>(retVal,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/checkFriendship/{username}/{korisnik}",
					method = RequestMethod.GET)
	public boolean checkFriendship(@PathVariable("username") String username,
								  @PathVariable("korisnik") String korisnik) {
		List<Friendship> friendships = FriendshipService.findAll();
		for(Friendship f : friendships) {
			if(f.getPrijatelj1().equals(username) && f.getPrijatelj2().equals(korisnik)) {
				return true;
			}
		}
		return false;	
	}
	
	
	@RequestMapping(value = "/sendRequest/{username}/{korisnik}",
	method = RequestMethod.GET)
	public ResponseEntity<User> sendRequest(@PathVariable("username") String username,
											@PathVariable("korisnik") String korisnik){
		Request r = new Request();
		r.setPoslao(username);
		r.setPrimio(korisnik);
		
		RequestService.save(r);
		return new ResponseEntity<>(UserService.findByUsername(username),HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/checkPadding/{username}/{korisnik}", method = RequestMethod.GET)
	public boolean checkPadding(@PathVariable("username") String username, @PathVariable("korisnik") String korisnik) {
		List<Request> request = RequestService.fintAll();	
		for(Request r : request) {
			if(r.getPoslao().equals(username) && r.getPrimio().equals(korisnik)) {
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping(value = "/checkRequested/{username}/{korisnik}", method = RequestMethod.GET)
	public boolean checkRequested(@PathVariable("username") String username, @PathVariable("korisnik") String korisnik) {
		List<Request> request = RequestService.fintAll();	
		for(Request r : request) {
			if(r.getPoslao().equals(korisnik) && r.getPrimio().equals(username)) {
				return true;
			}
		}
		return false;
	}

	@RequestMapping(value = "/confirmRequest/{username}/{korisnik}", method = RequestMethod.GET)
	public ResponseEntity<User> confirmRequest(@PathVariable("username") String username, @PathVariable("korisnik") String korisnik) {
		
		List<Request> requests = RequestService.fintAll();
		for(Request r : requests) {
			if(r.getPrimio().equals(username) && r.getPoslao().equals(korisnik)) {
				RequestService.delete(r.getId());
				break;
			}
		}
		
		FriendshipService.save(new Friendship(username,korisnik));
		return new ResponseEntity<>(UserService.findByUsername(username), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/removeFriend/{username}/{korisnik}", method = RequestMethod.GET)
	public ResponseEntity<User> removeFriend(
			@PathVariable("username") String username,
			@PathVariable("korisnik") String korisnik){
		
		List<Friendship> friendships = FriendshipService.findAll();
		
		for(Friendship f : friendships) {
			if((f.getPrijatelj1().equals(username) && f.getPrijatelj2().equals(korisnik))
					|| f.getPrijatelj2().equals(username) && f.getPrijatelj1().equals(korisnik)) {
				FriendshipService.delete(f.getId());
				break;
			}
		}
		
		return new ResponseEntity<>(UserService.findByUsername(username), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/declineRequest/{username}/{korisnik}", method = RequestMethod.GET)
	public ResponseEntity<List<Request>> declineRequest(
			@PathVariable("username") String username,
			@PathVariable("korisnik") String korisnik){
		
		List<Request> requests = RequestService.fintAll();	
		for(Request r : requests) {
			if(r.getPrimio().equals(username) && r.getPoslao().equals(korisnik)) {
				RequestService.delete(r.getId());
				break;
			}
		}
		return new ResponseEntity<>(RequestService.fintAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getRequests/{username}", method = RequestMethod.GET)
	public ResponseEntity<List<Request>> getRequests(@PathVariable("username") String username){
		
		List<Request> retVal = new ArrayList<Request>();
		//retVal = RequestService.fintAll();
		for(Request r : RequestService.fintAll()) {
			if(r.getPrimio().equals(username)) {
				retVal.add(r);
			}
		}	
		return new ResponseEntity<>(retVal,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/getPending/{username}", method = RequestMethod.GET)
	public ResponseEntity<List<Request>> getPending(@PathVariable("username") String username){
		List<Request> retVal = new ArrayList<Request>();
		//retVal = RequestService.fintAll();
		for(Request r : RequestService.fintAll()) {
			if(r.getPoslao().equals(username)) {
				retVal.add(r);
			}
		}	
		return new ResponseEntity<>(retVal,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cancelRequest/{username}/{korisnik}", method = RequestMethod.GET)
	public ResponseEntity<List<Request>> cancelRequest(@PathVariable("username") String username,
			@PathVariable("korisnik") String korisnik){
		List<Request> requests = RequestService.fintAll();	
		for(Request r : requests) {
			if(r.getPrimio().equals(korisnik) && r.getPoslao().equals(username)) {
				RequestService.delete(r.getId());
				break;
			}
		}
		return new ResponseEntity<>(RequestService.fintAll(),HttpStatus.OK);
	}
}

