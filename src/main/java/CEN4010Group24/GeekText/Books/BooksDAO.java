package CEN4010Group24.GeekText.Books;

import org.springframework.stereotype.Repository;

//this handles adding and retrieving the books
//AI Usage: Helped Debug error caused by misnaming of methods
@Repository
public class BooksDAO {
    private static Books books = new Books();

    public Books getAllBooks(){
        return books;
    }

    public void addABook(Book newBook){
        books.getAllBooks().add(newBook);
    }
}
