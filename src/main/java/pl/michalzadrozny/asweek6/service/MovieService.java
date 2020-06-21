package pl.michalzadrozny.asweek6.service;

import pl.michalzadrozny.asweek6.model.Movie;

import java.util.Optional;

public interface MovieService {

    Optional<Movie> findMovieByTitle(String title);
    boolean add(Movie movie);
}
