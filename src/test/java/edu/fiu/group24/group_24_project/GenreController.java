package edu.fiu.group24.group_24_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/practice")
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}
