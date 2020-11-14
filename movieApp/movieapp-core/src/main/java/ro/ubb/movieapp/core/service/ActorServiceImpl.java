package ro.ubb.movieapp.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.movieapp.core.model.Actor;
import ro.ubb.movieapp.core.model.Movie;
import ro.ubb.movieapp.core.repository.ActorRepository;
import ro.ubb.movieapp.core.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAllWithMovie();
    }

    @Override
    public List<Actor> getAllAvailableActors() {
        List<Actor> actors = new ArrayList<>();
        List<Movie> movies = movieRepository.findAll();
        AtomicBoolean found = new AtomicBoolean(false);
        actorRepository.findAll().forEach(actor -> {
            movies.forEach(movie -> {
                if (movie.getActorList().contains(actor))
                    found.set(true);
                else
                    found.set(false);
            });
            if (!found.get())
                actors.add(actor);
        });
        return actors;
        //return actorRepository.findAll().stream().filter(actor -> actor.getMovie() == null).collect(Collectors.toList());
    }
}
