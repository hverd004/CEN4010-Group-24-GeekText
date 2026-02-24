package edu.fiu.group24.group_24_project.feature_1.genre.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksByGenre(String genre) {
        if(genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("genre is required");
        }
        return bookRepository.findByGenreNameIgnoreCaseOrderByTitleAsc(genre.trim());
    }

    public List<Book> getTopSellers() {
        return bookRepository.findTop10ByOrderByCopiesSoldDesc();
    }
}
