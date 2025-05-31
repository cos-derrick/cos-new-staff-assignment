package com.cosmos.assignment.web.controller;

import com.cosmos.assignment.domain.entity.Moderator;
import com.cosmos.assignment.service.ModeratorService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import java.util.List;

@RequestMapping(value = "/")
@RestController
public class ModeratorController {

	@Inject
	ModeratorService moderatorService;
	
    //-------------------Retrieve All Users--------------------------------------------------------
    
    @RequestMapping(value = "/moderator/", method = RequestMethod.GET)
    public ResponseEntity<List<Moderator>> listAllUser() {
        List<Moderator> moderator = moderatorService.findAllModerator();
        if(moderator.isEmpty()){
            return new ResponseEntity<List<Moderator>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Moderator>>(moderator, HttpStatus.OK);
    }
  
  
     
    //-------------------Retrieve Single moderator--------------------------------------------------------
      
    @RequestMapping(value = "/moderator/{moderatorId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Moderator> getModerator(@PathVariable("id") String moderatorId) {
        System.out.println("Fetching moderator with modratorId " + moderatorId);
        Moderator moderator = moderatorService.getById(moderatorId);
        if (moderator == null) {
            System.out.println("moderator with moderatorId " + moderatorId + " not found");
            return new ResponseEntity<Moderator>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Moderator>(moderator, HttpStatus.OK);
    }
    
    //-------------------Moderator login--------------------------------------------------------
    @RequestMapping(value = "/moderator-login/", method = RequestMethod.GET)
    public ResponseEntity<Moderator> getModeratorId(@RequestParam(value = "username") String moderatorUsername, @RequestParam(value = "pw") String moderatorPw) {
        System.out.println("Login moderator with username -"+moderatorUsername+",pw -"+moderatorPw);
        String id = moderatorService.getModeratorId(moderatorUsername, moderatorPw);
        if(id == null || id.isEmpty() || id.equals("")) {
        	System.out.println("Login status : N");
            return new ResponseEntity<Moderator>(HttpStatus.NOT_FOUND);
        }
        Moderator moderator = moderatorService.getById(id);
    	System.out.println("Login status : Y");
    	return new ResponseEntity<Moderator>(moderator, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a moderator--------------------------------------------------------
      
    @RequestMapping(value = "/moderator-new/", method = RequestMethod.POST)
    public ResponseEntity<Void> addModerator(@RequestBody Moderator moderator,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating moderator " + moderator.getModeratorUsername());
  
/*        if (authorService.isUserExist(author)) {
            System.out.println("A author with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
  
        moderatorService.addModerator(moderator);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/moderator/{moderatorId}").buildAndExpand(moderator.getModeratorId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
