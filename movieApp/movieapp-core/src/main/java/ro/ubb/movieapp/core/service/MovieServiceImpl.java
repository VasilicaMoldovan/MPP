package ro.ubb.movieapp.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.movieapp.core.model.Actor;
import ro.ubb.movieapp.core.model.Movie;
import ro.ubb.movieapp.core.repository.ActorRepository;
import ro.ubb.movieapp.core.repository.MovieRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MovieServiceImpl implements MovieService {
    public static final Logger log= LoggerFactory.getLogger(MovieServiceImpl.class);
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll1();
    }

    @Override
    public Movie getMovieWithActors(Long movieId) {
        return movieRepository.findById(movieId).get();
    }

    @Override
    @Transactional
    public Movie addActor(Long movieId, Long actorId) {
        log.trace("addActor - booom, movie={}, actor={}", movieId, actorId);
        Movie movie = movieRepository.findById(movieId).get();
        log.trace("movie={}", movie);
        Actor actor = actorRepository.findById(actorId).get();
        log.trace("actor={}", actor);
        Movie result = movie.addActor(actor);
        log.trace("addActor - method finished, result={}", result);
        return result;
        //return movieRepository.findById(movieId).get().addActor(actorRepository.findById(actorId).get());
    }
}