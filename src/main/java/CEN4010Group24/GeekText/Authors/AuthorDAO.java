package CEN4010Group24.GeekText.Authors;

import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAO {
    private static Authors authors = new Authors();

    public Authors getAllAuthors(){
        return authors;
    }

    public void addAnAuthor(Author newAuthor){
        authors.getAllAuthors().add(newAuthor);
    }
}
