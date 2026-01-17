package CEN4010Group24.GeekText.Authors;

import CEN4010Group24.GeekText.Books.Book;
import CEN4010Group24.GeekText.Books.Books;
import CEN4010Group24.GeekText.Books.BooksDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorDAO authorDAO;
    @Autowired
    private BooksDAO booksDAO;

    @GetMapping("/{authorId}")
    public ResponseEntity<Books> getAllBooksByAuthor(@PathVariable String authorId){
        Books authorBooks = new Books();
        List<Book> authorBooksList = new ArrayList<Book>();
        for(Book b : booksDAO.getAllBooks().getAllBooks()){
            System.out.println(b.getBookAuthor() + " and " + authorId);
            if(b.getBookAuthor().equals(authorId)){
                authorBooksList.add(b);
            }
        }
        authorBooks.setBookList(authorBooksList);
        return ResponseEntity.ok(authorBooks);
    }

    @PostMapping("/")
    public ResponseEntity<Void> addBook(@RequestBody Author author){
        // Validate input
        if (author == null) {
            return ResponseEntity.badRequest().build();
        }

        // Add book to system
        System.out.println("Received author: " + author);
        authorDAO.addAnAuthor(author);

        // Success, no response body
        return ResponseEntity.status(201).build(); // CREATED
    }
}
