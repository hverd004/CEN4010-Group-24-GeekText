package edu.fiu.group24.group_24_project.Authors;

import edu.fiu.group24.group_24_project.Publishers.Publisher;
import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "biography", length = 2000)
    private String biography;

    @ManyToOne
    @JoinColumn(name = "publisher_name")
    private Publisher publisher;

    // ===== Constructors =====

    public Author() {}

    public Author(String firstName, String lastName, String biography, Publisher publisher) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publisher = publisher;
    }

    //region Getters
    public long getAuthorId() {
        return authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBiography() {
        return biography;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    @Transient
    public String getAuthorFullName(){
        return firstName + " " + lastName;
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

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    //endregion

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + getAuthorFullName() + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}
