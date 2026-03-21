package edu.fiu.group24.group_24_project.Authors;

import edu.fiu.group24.group_24_project.Books.Book;
import edu.fiu.group24.group_24_project.Books.BookRepository;
import edu.fiu.group24.group_24_project.Publishers.PublisherRepository;
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
    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping("/{authorId}/books")
    public ResponseEntity<List<Book>> getAllBooksByAuthor(@PathVariable Long authorId){
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

        // Add author & publisher to system
        System.out.println("Received author: " + author);
        if(!publisherRepository.existsById(author.getPublisher().getPublisher_name())){
            System.out.println("Creating Publisher: " + author.getPublisher().getPublisher_name());
            publisherRepository.save(author.getPublisher());
        }
        authorRepository.save(author);

        // Success, no response body
        return ResponseEntity.status(201).build(); // CREATED
    }
}
