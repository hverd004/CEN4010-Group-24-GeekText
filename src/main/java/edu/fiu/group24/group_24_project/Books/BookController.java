package edu.fiu.group24.group_24_project.Books;

import edu.fiu.group24.group_24_project.Authors.Author;
import edu.fiu.group24.group_24_project.Authors.AuthorRepository;
import edu.fiu.group24.group_24_project.Genres.Genre;
import edu.fiu.group24.group_24_project.Genres.GenreRepository;
import edu.fiu.group24.group_24_project.Publishers.Publisher;
import edu.fiu.group24.group_24_project.Publishers.PublisherRepository;
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
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private PublisherRepository publisherRepository;

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
    public ResponseEntity<?> addBook(@RequestBody Book book) {

        if (book == null || book.getIsbn() == null) {
            return ResponseEntity.badRequest().body("ISBN is required.");
        }

        Author author = authorRepository.findById(book.getBookAuthor().getAuthorId()).orElse(null);
        if (author == null) {
            return ResponseEntity.status(404).body("Author not found with ID: " + book.getBookAuthor().getAuthorId());
        }

        String genreName = book.getBookGenre().getGenre();
        Genre genre = genreRepository.findById(genreName).orElseGet(() -> genreRepository.save(book.getBookGenre()));

        String publisherName = book.getBookPublisher().getPublisher_name();
        Publisher publisher = publisherRepository.findById(publisherName).orElse(null);
        if (publisher == null) {
            return ResponseEntity.status(404).body("Publisher not found: " + publisherName);
        }

        book.setBookAuthor(author);
        book.setBookGenre(genre);
        book.setBookPublisher(publisher);

        bookRepository.save(book);

        return ResponseEntity.status(201).body("Book created successfully.");
    }
}
