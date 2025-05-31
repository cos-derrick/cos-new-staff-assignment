package com.cosmos.assignment.web.controller;

import com.cosmos.assignment.domain.entity.Category;
import com.cosmos.assignment.service.CategoryService;
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
public class CategoryController {
  
    @Autowired
    CategoryService categoryService;  //Service which will do all data retrieval/manipulation work
  
     
    //-------------------Retrieve All Categories--------------------------------------------------------
      
    @RequestMapping(value = "/category-moderator/", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllCategory() {
        List<Category> categories = categoryService.findAllCategory();
        if(categories.isEmpty()){
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }
  
  
     
    //-------------------Retrieve Single Category--------------------------------------------------------
      
    @RequestMapping(value = "/category-moderator/{categoryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCategory(@PathVariable("id") String categoryId) {
        System.out.println("Fetching category with categoryId " + categoryId);
        Category category = categoryService.getCategoryById(categoryId);
        if (category == null) {
            System.out.println("category with categoryId " + categoryId + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a category--------------------------------------------------------
      
    @RequestMapping(value = "/category-moderator/", method = RequestMethod.POST)
    public ResponseEntity<Void> addCategory(@RequestBody Category category,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating category " + category.getCategoryName());
  
/*        if (authorService.isUserExist(author)) {
            System.out.println("A author with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
  
        categoryService.addCategory(category);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/category-moderator/{categoryId}").buildAndExpand(category.getCategoryId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a category --------------------------------------------------------
      
    @RequestMapping(value = "/category-moderator/{categoryId}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable("categoryId") String categoryId, @RequestBody Category category) {
        System.out.println("Updating category " + categoryId);
          
        Category currenctCategory = categoryService.getCategoryById(categoryId);
          
        if (currenctCategory==null) {
            System.out.println("category with id " + categoryId + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
  
        currenctCategory.setCategoryName(category.getCategoryName());
        currenctCategory.setCategoryDescription(category.getCategoryDescription());
          
        categoryService.updateCategory(currenctCategory);
        return new ResponseEntity<Category>(currenctCategory, HttpStatus.OK);
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
