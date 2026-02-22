package edu.fiu.group24.group_24_project.Genres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/add")
    public ResponseEntity<?> addGenre(Genre genre){
        if (genre == null || genre.getGenre() == null) {
            return ResponseEntity.badRequest().body("Genre is Incomplete.");
        }
        genreRepository.save(genre);
        return ResponseEntity.status(201).body("Genre created successfully.");
    }
}
