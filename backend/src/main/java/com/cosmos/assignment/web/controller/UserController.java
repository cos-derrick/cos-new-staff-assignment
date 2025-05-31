package com.cosmos.assignment.web.controller;

import com.cosmos.assignment.domain.entity.User;
import com.cosmos.assignment.service.UserService;
import com.cosmos.assignment.util.Constant;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/")
@RestController
public class UserController {
  
    @Inject
    UserService userService;  //Service which will do all data retrieval/manipulation work
  
     
    //-------------------Retrieve All Users--------------------------------------------------------
      
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUser() {
        List<User> users = userService.findAllUser();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
  
  
     
    //-------------------Retrieve Single user--------------------------------------------------------
      
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId) {
        System.out.println("Fetching user with userId " + userId);
        User user = userService.getById(userId);
        if (user == null) {
            System.out.println("user with userId " + userId + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    
/*  //-------------------Retrieve Single user acct balance--------------------------------------------------------
    
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<double> getUserAcctBalance(@PathVariable("id") String userId) {
        System.out.println("Fetching user with userId " + userId);
        double acctBalance = userService.getUserAcctBalance(userId);
        if (acctBalance == -1) {
            System.out.println("user with userId " + userId + " not found");
            return new ResponseEntity<double>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<double>(acctBalance, HttpStatus.OK);
    }*/
    
    //-------------------User login--------------------------------------------------------
    @RequestMapping(value = "/user-login/", method = RequestMethod.GET)
    public ResponseEntity<User> getUserId(@RequestParam(value = "username") String userUsername, @RequestParam(value = "pw") String userPw) {
        System.out.println("Login user with username -"+userUsername+",userPw -"+userPw);
        String id = userService.getUserId(userUsername, userPw);
        if(id == null || id.isEmpty() || id.equals("")) {
        	System.out.println("Login status : N");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        User user = userService.getById(id);
    	System.out.println("Login status : Y");
    	return new ResponseEntity<User>(user, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a user--------------------------------------------------------
      
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating user " + user.getUserName());
  
/*        if (authorService.isUserExist(author)) {
            System.out.println("A author with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
		Date today = new Date();
		user.setUserCreatedDate(today);
		user.setUserStatus(Constant.USER_STATUS_PENDING);
        userService.addUser(user);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{userId}").buildAndExpand(user.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a user --------------------------------------------------------
      
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("userId") String userId, @RequestBody User user) {
        System.out.println("Updating author " + userId);
          
        User currentUser = userService.getById(userId);
          
        if (currentUser==null) {
            System.out.println("user with id " + userId + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
  
        currentUser.setUserPw(user.getUserPw());
        currentUser.setUserName(user.getUserName());
        currentUser.setUserEmail(user.getUserEmail());
        currentUser.setUserTelephone(user.getUserTelephone());
        currentUser.setUserMobile(user.getUserMobile());
        currentUser.setUserAddress(user.getUserAddress());
   
        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
  
     
     
/*    //------------------- Delete a author --------------------------------------------------------
      
    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.DELETE)
    public ResponseEntity<Author> deleteAuthor(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
  
        User user = authorService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
  
        authorService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
  
      
     
    //------------------- Delete All author --------------------------------------------------------
      
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        System.out.println("Deleting All Users");
  
        authorService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }*/
  
}
