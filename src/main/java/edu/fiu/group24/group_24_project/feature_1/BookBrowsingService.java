package edu.fiu.group24.group_24_project.feature_1;

import edu.fiu.group24.group_24_project.Books.Book;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class BookBrowsingService {

    private final BookBrowsingRepository bookBrowsingRepository;

    public BookBrowsingService(BookBrowsingRepository bookBrowsingRepository){
        this.bookBrowsingRepository = bookBrowsingRepository;
    }

    public List<Book> getBooksByGenre(String genre) {
        if(genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Genre is required");
        }
        return bookBrowsingRepository.findByBookGenre_GenreIgnoreCaseOrderByBookNameAsc(genre.trim());
    }

    public List<Book> getTopSellers() {
        return bookBrowsingRepository.findTop10ByOrderByBookCopiesSoldDesc();
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

    public void applyPublisherDiscount(String publisherName, BigDecimal discountPercent) {
        List<Book> books = bookBrowsingRepository.findByPublisherName(publisherName.trim());

        for (Book book : books) {
            BigDecimal newPrice = book.getBookPrice()
                    .multiply(BigDecimal.ONE.subtract(discountPercent.divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP)));
            book.setBookPrice(newPrice.setScale(2, RoundingMode.HALF_UP));
        }

        bookBrowsingRepository.saveAll(books);
    }
}
