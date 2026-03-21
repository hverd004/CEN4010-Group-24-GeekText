package edu.fiu.group24.group_24_project.feature_1;

import edu.fiu.group24.group_24_project.Books.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface BookBrowsingRepository extends JpaRepository<Book, String> {
    //Books by specific genre
    List<Book> findByBookGenre_GenreIgnoreCaseOrderByBookNameAsc(String bookGenre);

    //Top 10 sellers
    List<Book> findTop10ByOrderByBookCopiesSoldDesc();

    //Books by particular rating or higher
    List<Book> findByAvgRatingGreaterThanEqualOrderByAvgRatingDesc(BigDecimal minRating);
}
