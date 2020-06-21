package pl.michalzadrozny.asweek6.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class Movie {

    @NotNull(message = "Title field cannot be empty")
    private String title;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @NotNull(message = "Date field cannot be empty")
    private LocalDate releaseDate;

    @NotNull(message = "Director field cannot be empty")
    private String director;

    public Movie(String title, LocalDate releaseDate, String director) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.director = director;
    }

    public Movie() {
    }
}
