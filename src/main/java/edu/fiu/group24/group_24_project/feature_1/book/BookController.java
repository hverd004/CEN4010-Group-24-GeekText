package edu.fiu.group24.group_24_project.feature_1.genre.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Requirement #1: Get books by a specific genre
    @GetMapping("/genre/{genreName}")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String genreName) {
        return ResponseEntity.ok(bookService.getBooksByGenre(genreName));
    }

    // Requirement #2: Get the top 10 best-selling books
    @GetMapping("/top-sellers")
    public ResponseEntity<List<Book>> getTopSellers() {
        return ResponseEntity.ok(bookService.getTopSellers());
    }
}