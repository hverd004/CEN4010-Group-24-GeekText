package edu.fiu.group24.group_24_project.Genres;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @Column(name = "genre_name")
    private String genre;

    public Genre(){

    }
    public Genre(String genre) {
        this.genre = genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getGenre(){
        return genre;
    }

    @Override
    public String toString(){
        return "Genre= " + genre;
    }
}
