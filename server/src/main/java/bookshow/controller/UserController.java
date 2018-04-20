package bookshow.controller;

import bookshow.domain.users.User;
import bookshow.service.MailService;
import bookshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by Ivan V.
 */
@RestController
public class UserController {
    @Autowired
    private UserService UserService;
    @Autowired
    private MailService mailService;


    @PreAuthorize("hasAuthority('ADMINSYS')")
    @RequestMapping(
            value = "/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAdminFans() {
        List<User> Users = UserService.findAll();
        return new ResponseEntity<>(Users, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/users/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getAdminFan(@PathVariable("id") Long id) {
        User User = UserService.findOne(id);
        return new ResponseEntity<>(User, HttpStatus.OK);
    }
    @RequestMapping(
            value = "/users/by-username",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByUsername(@RequestParam("username") String username) {
        User user = UserService.findByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/users",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createAdminFan(@RequestBody User user) {
        user.setPoints(0L);
        user.setPasswordHash(new BCryptPasswordEncoder().encode(user.getPasswordHash()));
        User savedUser = UserService.save(user);
        mailService.sendActivationMail(user.getUsername(),user.getEmail());
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @RequestMapping(
            value = "/users/change-password",
            method = RequestMethod.GET)
    public ResponseEntity<User> changePassword(@RequestParam("oldPw") String oldPw, @RequestParam("newPw") String newPw, Principal principal) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        String username = principal.getName();
        User user = UserService.findByUsername(username);
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        if(bc.matches(oldPw,user.getPasswordHash())){
            user.setPasswordHash(bc.encode(newPw));
            UserService.save(user);
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(user,status);
    }

    @RequestMapping(
            value = "/users",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updateAdminFan(@RequestBody User User) {
        HttpStatus status;
        User updatedUser = UserService.save(User);
        if(updatedUser != null){
            status = HttpStatus.OK;
        }else { status = HttpStatus.CONFLICT; };

        return status;
    }

    @RequestMapping(
            value = "/user/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        UserService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
