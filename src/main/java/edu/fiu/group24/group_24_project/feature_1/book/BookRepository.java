package edu.fiu.group24.group_24_project.feature_1.genre.book;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    //Books by specific genre
    List<Book> findByGenreNameIgnoreCaseOrderByTitleAsc(String genreName);

    //Top 10 sellers
    List<Book> findTop10ByOrderByCopiesSoldDesc();
}
