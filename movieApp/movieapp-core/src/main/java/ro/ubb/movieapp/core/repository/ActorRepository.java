package ro.ubb.movieapp.core.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import ro.ubb.movieapp.core.model.Actor;
import ro.ubb.movieapp.core.model.Movie;

import java.util.List;

public interface ActorRepository extends MovieAppRepository<Actor, Long> {
    @Query("select distinct a from Actor a")
    @EntityGraph(value = "actorWithMovie", type =
            EntityGraph.EntityGraphType.LOAD)
    List<Actor> findAllWithMovie();
}

