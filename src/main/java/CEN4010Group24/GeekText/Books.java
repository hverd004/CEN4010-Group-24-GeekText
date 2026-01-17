package CEN4010Group24.GeekText;

import java.util.ArrayList;
import java.util.List;

//Holds a list of books, may change later with database not sure yet
public class Books {
    private List<Book> allBooks;

    //getter of list
    public List<Book> getAllBooks(){
        if(allBooks == null){
            allBooks = new ArrayList<>();
        }
        return allBooks;
    }
    //setter of new list
    public void setBookList(List<Book> newList){
        allBooks = newList;
    }
}
