package com.cosmos.assignment.web.controller;

import com.cosmos.assignment.domain.entity.Author;
import com.cosmos.assignment.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping(value = "/")
@RestController
public class AuthorController {
  
    @Autowired
    AuthorService authorService;  //Service which will do all data retrieval/manipulation work
  
     
    //-------------------Retrieve All Users--------------------------------------------------------
      
    @RequestMapping(value = "/author-moderator/", method = RequestMethod.GET)
    public ResponseEntity<List<Author>> listAllAuthor() {
        List<Author> authors = authorService.findAllAuthor();
        if(authors.isEmpty()){
            return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
    }
  
  
     
    //-------------------Retrieve Single author--------------------------------------------------------
      
    @RequestMapping(value = "/author-moderator/{authorId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> getUser(@PathVariable("id") String authorId) {
        System.out.println("Fetching author with authorId " + authorId);
        Author author = authorService.getAuthorById(authorId);
        if (author == null) {
            System.out.println("author with authorId " + authorId + " not found");
            return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Author>(author, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a author--------------------------------------------------------
      
    @RequestMapping(value = "/author-moderator/", method = RequestMethod.POST)
    public ResponseEntity<Void> addAuthor(@RequestBody Author author,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating author " + author.getAuthorName());
  
/*        if (authorService.isUserExist(author)) {
            System.out.println("A author with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
  
        authorService.addAuthor(author);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/author/{authorId}").buildAndExpand(author.getAuthorId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a author --------------------------------------------------------
      
    @RequestMapping(value = "/author-moderator/{authorId}", method = RequestMethod.PUT)
    public ResponseEntity<Author> updateUser(@PathVariable("authorId") String authorId, @RequestBody Author author) {
        System.out.println("Updating author " + authorId);
          
        Author currentAuthor = authorService.getAuthorById(authorId);
          
        if (currentAuthor==null) {
            System.out.println("author with id " + authorId + " not found");
            return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
        }
  
        currentAuthor.setAuthorName(author.getAuthorName());
        currentAuthor.setAuthorEmail(author.getAuthorEmail());
        currentAuthor.setAuthorCountry(author.getAuthorCountry());
          
        authorService.updateAuthor(currentAuthor);
        return new ResponseEntity<Author>(currentAuthor, HttpStatus.OK);
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
