package edu.fiu.group24.group_24_project.feature_1;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookBrowsingService {

    private final BookBrowsingRepository bookBrowsingRepository;

    public BookBrowsingService(BookBrowsingRepository bookBrowsingRepository){
        this.bookBrowsingRepository = bookBrowsingRepository;
    }

    public List<Book> getBooksByGenre(String genre) {
        if(genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("genre is required");
        }
        return bookBrowsingRepository.findByGenreNameIgnoreCaseOrderByTitleAsc(genre.trim());
    }

    public List<Book> getTopSellers() {
        return bookBrowsingRepository.findTop10ByOrderByCopiesSoldDesc();
    }

    public List<Book> getBooksByMinRating(BigDecimal minRating) {
        if(minRating == null) {
            throw new IllegalArgumentException("Rating is required");
        }
        if(minRating.compareTo(BigDecimal.ZERO) < 0 || minRating.compareTo(new BigDecimal("5.0")) >0) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        return bookBrowsingRepository.findByAvgRatingGreaterThanEqualOrderByAvgRatingDesc(minRating);
    }
}
