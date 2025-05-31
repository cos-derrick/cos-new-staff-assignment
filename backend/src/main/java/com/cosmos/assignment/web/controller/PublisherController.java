package com.cosmos.assignment.web.controller;

import com.cosmos.assignment.domain.entity.Publisher;
import com.cosmos.assignment.service.PublisherService;
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
public class PublisherController {
  
    @Autowired
    PublisherService publisherService;  //Service which will do all data retrieval/manipulation work
  
     
    //-------------------Retrieve All Publishers--------------------------------------------------------
      
    @RequestMapping(value = "/publisher-moderator/", method = RequestMethod.GET)
    public ResponseEntity<List<Publisher>> listAllPublisher() {
        List<Publisher> publishers = publisherService.findAllPublisher();
        if(publishers.isEmpty()){
            return new ResponseEntity<List<Publisher>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Publisher>>(publishers, HttpStatus.OK);
    }
  
  
     
    //-------------------Retrieve Single Publisher--------------------------------------------------------
      
    @RequestMapping(value = "/publisher-moderator/{publisherId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Publisher> getPublisher(@PathVariable("id") String publisherId) {
        System.out.println("Fetching publisher with publisherId " + publisherId);
        Publisher publisher = publisherService.getPublisherById(publisherId);
        if (publisher == null) {
            System.out.println("publisher with publisherId " + publisherId + " not found");
            return new ResponseEntity<Publisher>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Publisher>(publisher, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a publisher--------------------------------------------------------
      
    @RequestMapping(value = "/publisher-moderator/", method = RequestMethod.POST)
    public ResponseEntity<Void> addPublisher(@RequestBody Publisher publisher,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating publisher " + publisher.getPublisherName());
  
/*        if (authorService.isUserExist(author)) {
            System.out.println("A author with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
  
        publisherService.addPublisher(publisher);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/publisher-moderator/{publisherId}").buildAndExpand(publisher.getPublisherId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a publisher --------------------------------------------------------
      
    @RequestMapping(value = "/publisher-moderator/{publisherId}", method = RequestMethod.PUT)
    public ResponseEntity<Publisher> updatePublisher(@PathVariable("publisherId") String publisherId, @RequestBody Publisher publisher) {
        System.out.println("Updating publisher " + publisherId);
          
        Publisher currenctpublisher = publisherService.getPublisherById(publisherId);
          
        if (currenctpublisher==null) {
            System.out.println("publisher with id " + publisherId + " not found");
            return new ResponseEntity<Publisher>(HttpStatus.NOT_FOUND);
        }
  
        currenctpublisher.setPublisherName(publisher.getPublisherName());
        currenctpublisher.setPublisherEmail(publisher.getPublisherEmail());
        currenctpublisher.setPublisherAddress(publisher.getPublisherAddress());
        currenctpublisher.setPublisherTelephone(publisher.getPublisherTelephone());
        currenctpublisher.setPublisherFax(publisher.getPublisherFax());
          
        publisherService.updatePublisher(currenctpublisher);
        return new ResponseEntity<Publisher>(currenctpublisher, HttpStatus.OK);
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
