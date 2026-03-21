package edu.fiu.group24.group_24_project.feature_1;

import edu.fiu.group24.group_24_project.Books.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookBrowsingController {

    private final BookBrowsingService bookBrowsingService;

    public BookBrowsingController(BookBrowsingService bookService) {
        this.bookBrowsingService = bookService;
    }

    // Requirement #1: Get books by a specific genre
    @GetMapping("/genre/{genreName}")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String genreName) {
        return ResponseEntity.ok(bookBrowsingService.getBooksByGenre(genreName));
    }

    // Requirement #2: Get the top 10 best-selling books
    @GetMapping("/top-sellers")
    public ResponseEntity<List<Book>> getTopSellers() {
        return ResponseEntity.ok(bookBrowsingService.getTopSellers());
    }

    // Requirement #3: Get books by particular rating or higher
    @GetMapping("/rating/{minRating}")
    public ResponseEntity<List<Book>> getBooksByMinRating(@PathVariable BigDecimal minRating) {
        return ResponseEntity.ok(bookBrowsingService.getBooksByMinRating(minRating));
    }
}