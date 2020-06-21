package pl.michalzadrozny.asweek6.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.michalzadrozny.asweek6.model.Movie;
import pl.michalzadrozny.asweek6.service.EmailAspect;
import pl.michalzadrozny.asweek6.service.MovieServiceImpl;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/movies")
public class MovieController {

    private MovieServiceImpl movieService;

    @Autowired
    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        if (movieService.getMovieList().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(movieService.getMovieList());
        }
    }

    @EmailAspect
    @PostMapping
    public ResponseEntity addMovie(@Validated @RequestBody Movie movie) {
        if (movieService.add(movie)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(movie);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(movie);
        }
    }

}
