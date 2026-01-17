package CEN4010Group24.GeekText;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//THIS IS ONE OF THE MOST IMPORTANT CLASSES
//IT HANDLES THE API ENDPOINTS (GET,POST,ETC.)
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BooksDAO bookDAO;

    //THE GET ENDPOINT FOR ALL BOOKS
    @GetMapping("/")
    public Books getBooks(){
        System.out.println("Pulling book");
        return bookDAO.getAllBooks();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable int isbn){
        for(Book b : bookDAO.getAllBooks().getAllBooks()){
            if(b.getBookISBN() == isbn){
                return ResponseEntity.ok(b);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //THE POST ENDPOINT
    @PostMapping("/")
    public ResponseEntity<Void> addBook(@RequestBody Book book){
        // Validate input
        if (book == null || book.getBookISBN() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        // Add book to system
        System.out.println("Received book: " + book);
        bookDAO.addABook(book);

        // Success, no response body
        return ResponseEntity.status(201).build(); // CREATED
    }
}
