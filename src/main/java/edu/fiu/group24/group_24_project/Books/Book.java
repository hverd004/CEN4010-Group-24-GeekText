package edu.fiu.group24.group_24_project.Books;

import edu.fiu.group24.group_24_project.Authors.Author;
import edu.fiu.group24.group_24_project.Genres.Genre;
import edu.fiu.group24.group_24_project.Publishers.Publisher;
import jakarta.persistence.*;

import java.math.BigDecimal;

//NOTE: using region NAME endregion to compress code in IntelliJ IDE
//AI Usage: Help figure out all the @ that were needed to be a JPA entity
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title", nullable = false)
    private String bookName;

    @Column(name = "description", length = 2000)
    private String bookDescription;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal bookPrice;

    @Column(name = "year_published")
    private Integer bookYearPublished;

    @Column(name = "copies_sold")
    private Integer bookCopiesSold = 0;

    @Column(name = "avg_rating", precision = 3, scale = 2)
    private BigDecimal avgRating = BigDecimal.ZERO;

    // ===== Relationships =====

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author bookAuthor;

    @ManyToOne
    @JoinColumn(name = "publisher_name")
    private Publisher bookPublisher;

    @ManyToOne
    @JoinColumn(name = "genre_name")
    private Genre bookGenre;

    //basic Constructor
    public Book(){

    }
    //book Constructor for All Information
    public Book(String bookISBN, String bookName,
                String bookDescription, BigDecimal bookPrice, Author bookAuthor,
                Genre bookGenre, Publisher bookPublisher, int bookYearPublished, int bookCopiesSold, BigDecimal AVGRating) {

        this.isbn = bookISBN;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookPublisher = bookPublisher;
        this.bookYearPublished = bookYearPublished;
        this.bookCopiesSold = bookCopiesSold;
        this.avgRating = AVGRating;
    }

    //region Getters
    public String getBookISBN() {
        return isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public Author getBookAuthor() {
        return bookAuthor;
    }

    public Genre getBookGenre() {
        return bookGenre;
    }

    public Publisher getBookPublisher() {
        return bookPublisher;
    }

    public int getBookYearPublished() {
        return bookYearPublished;
    }

    public int getBookCopiesSold() {
        return bookCopiesSold;
    }

    public BigDecimal getAvgRating(){ return avgRating;}
    //endregion

    //region Setters
    public void setBookISBN(String bookISBN) {
        this.isbn = bookISBN;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setBookAuthor(Author bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookGenre(Genre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public void setBookPublisher(Publisher bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public void setBookYearPublished(int bookYearPublished) {
        this.bookYearPublished = bookYearPublished;
    }

    public void setBookCopiesSold(int bookCopiesSold) {
        this.bookCopiesSold = bookCopiesSold;
    }

    public void setAvgRating(BigDecimal avgRating){this.avgRating = avgRating;}
    //endregion

    @Override
    public String toString() {
        return "Book{" +
                "bookISBN= " + isbn +
                ", bookName= '" + bookName + '\'' +
                ", bookDescription= '" + bookDescription + '\'' +
                ", bookPrice= " + bookPrice +
                ", bookAuthor= '" + getBookAuthor().getAuthorFullName() + '\'' +
                ", bookGenre= '" + bookGenre + '\'' +
                ", bookPublisher= '" + bookPublisher + '\'' +
                ", bookYearPublished= " + bookYearPublished +
                ", bookCopiesSold= " + bookCopiesSold +
                ", AverageRating= " + avgRating +
                '}';
    }
}
