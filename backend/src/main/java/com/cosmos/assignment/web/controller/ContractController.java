package com.cosmos.assignment.web.controller;

import com.cosmos.assignment.domain.entity.Book;
import com.cosmos.assignment.domain.entity.Contract;
import com.cosmos.assignment.domain.entity.User;
import com.cosmos.assignment.service.BookService;
import com.cosmos.assignment.service.ContractService;
import com.cosmos.assignment.service.UserService;
import com.cosmos.assignment.util.Constant;
import com.cosmos.assignment.web.webform.ContractForm;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import java.util.*;

@RequestMapping(value = "/")
@RestController
public class ContractController {
  
    @Inject
    BookService bookService;  //Service which will do all data retrieval/manipulation work
    @Inject
    UserService userService;
    @Inject
    ContractService contractService;
  
     
    //-------------------Retrieve All Contracts--------------------------------------------------------
      
    @RequestMapping(value = "/contract-moderator/", method = RequestMethod.GET)
    public ResponseEntity<List<Contract>> listAllContract() {
        List<Contract> contracts = contractService.findAllContract();
        if(contracts.isEmpty()){
            return new ResponseEntity<List<Contract>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Contract>>(contracts, HttpStatus.OK);
    }
    
  //-------------------Retrieve User Contracts--------------------------------------------------------
    
    @RequestMapping(value = "/contract-user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Contract>> listUserContract(@PathVariable("userId") String userId) {
        List<Contract> contracts = contractService.findUserContracts(userId);
        System.out.println("listUserContract size - "+contracts.size());
        if(contracts.isEmpty()){
            return new ResponseEntity<List<Contract>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Contract>>(contracts, HttpStatus.OK);
    }
       
/*    //-------------------Retrieve Single book--------------------------------------------------------
      
    @RequestMapping(value = "/book-list/{bookId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable("id") String bookId) {
        System.out.println("Fetching book with bookId " + bookId);
        Book book = bookService.getBookById(bookId);
        if (book == null) {
            System.out.println("book with bookId " + bookId + " not found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }*/
  
      
      
    //-------------------Create a contract--------------------------------------------------------
      
    @RequestMapping(value = "/contract-add/", method = RequestMethod.POST)
    public ResponseEntity<Void> addContract(@RequestBody ContractForm contractForm, UriComponentsBuilder ucBuilder) {
    	String userId = contractForm.getUserId();
    	String paymentMethod = contractForm.getPaymentMethod();
    	String[] booksId = contractForm.getBooksId();
    	
    	User user = userService.getById(userId);
    	Contract contract = new Contract();
    	List<Book> book = new ArrayList<Book>();
    	Book temp = null;
    	for(int i = 0; i < booksId.length; i++) {
    		temp = bookService.getBookById(booksId[i]);
    		book.add(temp);
    	}
    	Set<Book> books = new HashSet<Book>(book);
    	Date date = new Date();
    	
    	contract.setContractUser(user);
    	contract.setContractCreatedDate(date);
    	contract.setContractPaymentMethod(paymentMethod);
    	contract.setBooks(books);
    	contract.setContractStatus(Constant.CONTRACT_STATUS_PENDING);
    	
    	contractService.addContract(contract);
    	
/*        if (authorService.isUserExist(author)) {
            System.out.println("A author with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
    	
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/contract-user/{contractId}").buildAndExpand(contract.getContractNumber()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
/*    //------------------- Update a book --------------------------------------------------------
      
    @RequestMapping(value = "/book-moderator/{bookId}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@PathVariable("bookId") String bookId, @RequestBody Book book) {
        System.out.println("Updating book " + bookId);
          
        Book currentBook = bookService.getBookById(bookId);
          
        if (currentBook==null) {
            System.out.println("book with id " + bookId + " not found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
  
        currentBook.setBookSubject(book.getBookSubject());
        currentBook.setBookDescription(book.getBookDescription());
        currentBook.setBookIsbn(book.getBookIsbn());
        currentBook.setBookAuthor(book.getBookAuthor());
        currentBook.setBookPublisher(book.getBookPublisher());
        currentBook.setBookCategory(book.getBookCategory());
        currentBook.setBookContent(book.getBookContent());
        currentBook.setBookContentType(book.getBookContentType());
        currentBook.setBookPrice(book.getBookPrice());
          
        bookService.updateBook(currentBook);
        return new ResponseEntity<Book>(currentBook, HttpStatus.OK);
    }
  
     */
     
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
