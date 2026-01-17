package CEN4010Group24.GeekText.Authors;

import java.util.ArrayList;
import java.util.List;

public class Authors {
    private List<Author> allAuthors;

    //getter of list
    public List<Author> getAllAuthors(){
        if(allAuthors == null){
            allAuthors = new ArrayList<>();
        }
        return allAuthors;
    }
    //setter of new list
    public void setBookList(List<Author> newList){
        allAuthors = newList;
    }
}
