package edu.fiu.group24.group_24_project.Books;

import edu.fiu.group24.group_24_project.Authors.Author;
import edu.fiu.group24.group_24_project.Authors.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//THIS IS ONE OF THE MOST IMPORTANT CLASSES
//IT HANDLES THE API ENDPOINTS (GET,POST,ETC.)

//AI Usage: Used to explain how to send responses (ResponseEntity) and pass variables (GetMapping) as well as logic debugging
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    //THE GET ENDPOINT FOR ALL BOOKS
    @GetMapping("/")
    public List<Book> getBooks(){
        System.out.println("Pulling book");
        return bookRepository.findAll();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable String isbn){
        return bookRepository.findById(isbn).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //THE POST ENDPOINT
    @PostMapping("/")
    public ResponseEntity<Void> addBook(@RequestBody Book book, @RequestParam Integer authorId){
        // Validate input
        if (book == null || book.getBookISBN().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Author author = authorRepository.findById(authorId).orElseThrow();
        book.setBookAuthor(author);

        // Add book to system
        System.out.println("Received book: " + book);
        bookRepository.save(book);

        // Success, no response body
        return ResponseEntity.status(201).build(); // CREATED
    }
}
