package edu.fiu.group24.group_24_project.Publishers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @Column(name = "publisher_name")
    private String publisher_name;

    public Publisher(){

    }
    public Publisher(String publisherName) {
        publisher_name = publisherName;
    }

    public String getPublisher_name(){
        return publisher_name;
    }

    public void setPublisher_name(String publisherName){
        publisher_name = publisherName;
    }

    @Override
    public String toString() {
        return "Publisher Name: " + publisher_name;
    }
}
