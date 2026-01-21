package CEN4010Group24.GeekText.Authors;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id; //This will be the id of the author because it needs to be unique and names may not be (also databases like numbers)
    String firstName;
    String lastName;
    @Column(length = 2000)
    String biography;
    String publisher;

    @Column(unique = true)
    String authorID; //This will just be "Firstname Lastname" and is for easy access to full name for displaying it

    public Author(){

    }

    public Author(String firstName, String lastName, String biography, String publisher) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publisher = publisher;
        this.authorID = firstName + " " + lastName;
    }

    //region Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBiography() {
        return biography;
    }

    public String getPublisher() {
        return publisher;
    }
    //endregion

    public String getAuthorID(){
        return authorID;
    }

    //region Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.authorID = firstName + " " + lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        this.authorID = firstName + " " + lastName;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    //endregion

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", biography='" + biography + '\'' +
                ", publisher='" + publisher + '\'' +
                ", Id='" + authorID + '\'' +
                '}';
    }
}
