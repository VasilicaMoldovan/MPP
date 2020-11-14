package ro.ubb.movieapp.core.service;

import ro.ubb.movieapp.core.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMovieWithActors(Long movieId);
    Movie addActor(Long movieId, Long actorId);
    //List<Movie> getMoviesByYear(int year, boolean lessThan);
    //List<Movie> getMoviesWithActorsByYear(int year, boolean lessThan);
    //void deleteActor(Long movieId, Long actorId);
}
