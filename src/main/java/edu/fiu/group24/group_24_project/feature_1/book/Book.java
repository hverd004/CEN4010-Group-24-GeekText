package edu.fiu.group24.group_24_project.feature_1.genre.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title", nullable = false)
    private  String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "year_published")
    private int yearPublished;

    @Column(name = "copies_sold")
    private int copiesSold;

    @Column(name = "avg_rating")
    private BigDecimal avgRating;

    @Column(name = "genre_name")
    private String genreName;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "author_id")
    private int authorId;

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public BigDecimal getAvgRating() {
        return avgRating;
    }

    public String getGenreName() {
        return genreName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public int getAuthorId() {
        return authorId;
    }

}
