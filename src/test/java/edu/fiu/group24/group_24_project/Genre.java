package edu.fiu.group24.group_24_project;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    private String genre_name;

        public String getGenre_name() {
            return genre_name;
        }

        public void setGenre_name(String genre_name) {
            this.genre_name = genre_name;
        }


}