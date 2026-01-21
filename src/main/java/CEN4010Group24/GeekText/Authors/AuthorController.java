package CEN4010Group24.GeekText.Authors;

import CEN4010Group24.GeekText.Books.Book;
import CEN4010Group24.GeekText.Books.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/{authorId}/books")
    public ResponseEntity<List<Book>> getAllBooksByAuthor(@PathVariable long authorId){
        if (!authorRepository.existsById(authorId)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(bookRepository.findByBookAuthor_AuthorID(authorId));
    }

    @PostMapping("/")
    public ResponseEntity<Void> addBook(@RequestBody Author author){
        // Validate input
        if (author == null) {
            return ResponseEntity.badRequest().build();
        }

        // Add book to system
        System.out.println("Received author: " + author);
        authorRepository.save(author);

        // Success, no response body
        return ResponseEntity.status(201).build(); // CREATED
    }
}
