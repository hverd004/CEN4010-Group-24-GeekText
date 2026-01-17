package CEN4010Group24.GeekText;

import org.springframework.stereotype.Repository;

//this handles adding and retrieving the books
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
