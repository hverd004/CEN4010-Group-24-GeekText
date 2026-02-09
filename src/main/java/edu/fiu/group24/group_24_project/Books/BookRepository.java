package edu.fiu.group24.group_24_project.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    //I KNOW THIS NAME IS WEIRD BUT ITS LIKE THIS BECAUSE OF HOW NAMING CONVENTIONS WORK
    //THE METHOD NAME LIKE THIS TELLS THE CODE TO LOOK FOR "bookAuthor" (name of the local variable) VIA THE "author_id"
    List<Book> findByBookAuthor_AuthorId(Integer author_id);
}
