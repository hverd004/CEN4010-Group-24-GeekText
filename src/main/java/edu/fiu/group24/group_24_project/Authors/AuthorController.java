package edu.fiu.group24.group_24_project.Authors;

import edu.fiu.group24.group_24_project.Books.Book;
import edu.fiu.group24.group_24_project.Books.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/{authorId}/books")
    public ResponseEntity<List<Book>> getAllBooksByAuthor(@PathVariable Integer authorId){
        if (!authorRepository.existsById(authorId)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(bookRepository.findByBookAuthor_AuthorId(authorId));
    }

    @PostMapping("/")
    public ResponseEntity<Void> addAuthor(@RequestBody Author author){
        // Validate input
        if (author == null) {
            return ResponseEntity.badRequest().build();
        }

        // Add author to system
        System.out.println("Received author: " + author);
        authorRepository.save(author);

        // Success, no response body
        return ResponseEntity.status(201).build(); // CREATED
    }
}
