package ro.ubb.movieapp.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubb.movieapp.core.model.Movie;
import ro.ubb.movieapp.core.service.MovieService;
import ro.ubb.movieapp.web.converter.MovieConverter;
import ro.ubb.movieapp.web.dto.ActorDto;
import ro.ubb.movieapp.web.dto.MovieDto;

import java.util.List;

@RestController
public class MovieController {
    public static final Logger log= LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieConverter movieConverter;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    List<MovieDto> getMovies() {
        log.trace("getMovies - method entered");
        return (List<MovieDto>) movieConverter
                .convertModelsToDtos(movieService.getAllMovies());
    }

    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.POST)
    MovieDto addActor(@PathVariable Long movieId, @RequestBody Long actorId) {
        log.trace("addActor - method entered: actor={}, movie={}", actorId, movieId);
        Movie movie = movieService.addActor(movieId, actorId);
        log.trace("controller movie={}", movie);
        MovieDto movieDto = movieConverter.convertModelToDto(movie);
        log.trace("movieDto={}", movieDto);
        return movieDto;
    }
}

