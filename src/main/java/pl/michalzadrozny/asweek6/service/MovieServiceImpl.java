package pl.michalzadrozny.asweek6.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.michalzadrozny.asweek6.model.Movie;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {


    @Getter
    private final List<Movie> movieList;

    public MovieServiceImpl() {

        movieList = new ArrayList<>();

        Movie ironMan = new Movie("Iron Man", LocalDate.of(2008, Month.APRIL,14), "Jon Favreau");
        Movie theShawshankRedemption = new Movie("The Shawshank Redemption", LocalDate.of(1994, Month.SEPTEMBER,10),"Frank Darabont");
        Movie joker = new Movie("Joker", LocalDate.of(2019, Month.AUGUST,31), "Todd Phillips");
        Movie intouchables = new Movie("Intouchables", LocalDate.of(2011, Month.SEPTEMBER,23), "Olivier Nakache / Éric Toledano");
        Movie zohan = new Movie("You Don't Mess with the Zohan", LocalDate.of(2008, Month.JUNE,6),"Dennis Dugan");

        movieList.add(ironMan);
        movieList.add(theShawshankRedemption);
        movieList.add(joker);
        movieList.add(intouchables);
        movieList.add(zohan);
    }

    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        return movieList.stream().filter(movie -> movie.getTitle().equalsIgnoreCase(title)).findFirst();
    }

    @Override
    public boolean add(Movie movie) {
        if (findMovieByTitle(movie.getTitle()).isPresent()){
            return false;
        }else {
            movieList.add(movie);
            return true;
        }
    }
}
