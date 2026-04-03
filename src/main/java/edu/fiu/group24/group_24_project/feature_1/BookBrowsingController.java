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

    // Requirement #1: GET books by a specific genre
    @GetMapping("/genre/{genreName}")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable("genreName") String genreName) {
        return ResponseEntity.ok(bookBrowsingService.getBooksByGenre(genreName));
    }

    // Requirement #2: GET the top 10 best-selling books
    @GetMapping("/top-sellers")
    public ResponseEntity<List<Book>> getTopSellers() {
        return ResponseEntity.ok(bookBrowsingService.getTopSellers());
    }

    // Requirement #3: GET books by particular rating or higher
    @GetMapping("/rating/{minRating}")
    public ResponseEntity<List<Book>> getBooksByMinRating(@PathVariable("minRating") BigDecimal minRating) {
        return ResponseEntity.ok(bookBrowsingService.getBooksByMinRating(minRating));
    }

    // Requirement #4: PATCH Publisher discount
    @PatchMapping("/discount")
    public ResponseEntity<Void> applyPublisherDiscount(
            @RequestParam("publisher") String publisherName,
            @RequestParam("discount") BigDecimal discountPercent) {
        bookBrowsingService.applyPublisherDiscount(publisherName, discountPercent);
        return ResponseEntity.noContent().build();
    }
}