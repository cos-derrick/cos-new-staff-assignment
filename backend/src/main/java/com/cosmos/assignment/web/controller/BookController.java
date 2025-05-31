package com.cosmos.assignment.web.controller;

import com.cosmos.assignment.domain.entity.Author;
import com.cosmos.assignment.domain.entity.Book;
import com.cosmos.assignment.domain.entity.Category;
import com.cosmos.assignment.domain.entity.Publisher;
import com.cosmos.assignment.service.AuthorService;
import com.cosmos.assignment.service.BookService;
import com.cosmos.assignment.service.CategoryService;
import com.cosmos.assignment.service.PublisherService;
import com.cosmos.assignment.web.webform.BookForm;
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
public class BookController {
  
    @Inject
    BookService bookService;  //Service which will do all data retrieval/manipulation work
    @Inject
    AuthorService authorService;
    @Inject
    PublisherService publisherService;
    @Inject
    CategoryService categoryService;
  
     
    //-------------------Retrieve All Books--------------------------------------------------------
      
    @RequestMapping(value = "/book-list/", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> listAllBook() {
        List<Book> books = bookService.findAllBook();
        if(books.isEmpty()){
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
    
  //-------------------Retrieve Books By Criteria--------------------------------------------------------
    
    @RequestMapping(value = "/search-book/", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> listSearchBook(@RequestParam(value="criteria") String criteria, @RequestParam(value="value") String value) {
    	List<Book> books = null;
    	if("Subject".equals(criteria))
    		books = bookService.findBookBySubject(value);
    	else if("Author".equals(criteria))
    		books = bookService.findBookByAuthor(value);
    	else if("Publisher".equals(criteria))
    		books = bookService.findBookByPublisher(value);
    	else if("Category".equals(criteria))
    		books = bookService.findBookByCategory(value);
    
        if(books.isEmpty()){
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
  
  
     
    //-------------------Retrieve Single book--------------------------------------------------------
      
    @RequestMapping(value = "/book-list/{bookId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable("id") String bookId) {
        System.out.println("Fetching book with bookId " + bookId);
        Book book = bookService.getBookById(bookId);
        if (book == null) {
            System.out.println("book with bookId " + bookId + " not found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a book--------------------------------------------------------
      
    @RequestMapping(value = "/book-moderator/", method = RequestMethod.POST)
    public ResponseEntity<Void> addBook(@RequestBody BookForm bookForm , UriComponentsBuilder ucBuilder) {
    	System.out.println(bookForm);
    	Book book = new Book();
    	Date date = new Date();

    	Author author = authorService.getAuthorById(bookForm.getAuthorId());
		Publisher publisher = publisherService.getPublisherById(bookForm.getPublisherId());
    	Category category = categoryService.getCategoryById(bookForm.getCategoryId());

    	System.out.println(author);
    	System.out.println(publisher);
    	System.out.println(category);
    	
    	book.setBookSubject(bookForm.getBookSubject());
    	book.setBookDescription(bookForm.getBookDescription());
    	book.setBookIsbn(bookForm.getBookIsbn());
    	book.setBookAuthor(author);
    	book.setBookPublisher(publisher);
    	book.setBookCategory(category);
    	book.setBookCreatedDate(date);
    	book.setBookContent(bookForm.getBookContent());
    	book.setBookContentType(bookForm.getBookContentType());
    	book.setBookPrice(bookForm.getBookPrice());
    	
/*        if (authorService.isUserExist(author)) {
            System.out.println("A author with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/

    	System.out.println(book);
        bookService.addBook(book);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/book-moderator/{bookId}").buildAndExpand(book.getBookId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a book --------------------------------------------------------
      
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
