package CEN4010Group24.GeekText.Authors;

public class Author {
    String firstName;
    String lastName;
    String biography;
    String publisher;
    String authorID; //This will just be "Firstname Lastname"

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

    //region Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
