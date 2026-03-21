package edu.fiu.group24.group_24_project.Genres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/getAllGenres")
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<?> addGenre(@RequestBody Genre genre){
        if (genre == null){
            return ResponseEntity.badRequest().body("Genre is Missing.");
        }
        else if(genre.getGenre() == null){
            return ResponseEntity.badRequest().body("Genre is Missing.");
        }
        if(!genreRepository.existsById(genre.getGenre())) {
            genreRepository.save(genre);
            return ResponseEntity.status(201).body("Genre created successfully.");
        }
        else {
            return ResponseEntity.status(201).body("Genre Already Exists.");
        }
    }
}
