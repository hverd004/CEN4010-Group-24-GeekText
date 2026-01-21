package CEN4010Group24.GeekText.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    //I KNOW THIS NAME IS WEIRD BUT ITS LIKE THIS BECAUSE OF HOW NAMING CONVENTIONS WORK
    //THE METHOD NAME LIKE THIS TELLS THE CODE TO LOOK FOR "bookAuthor" (name of the local variable) VIA THE "authorId"
    List<Book> findByBookAuthor_AuthorID(Long authorId);
}
