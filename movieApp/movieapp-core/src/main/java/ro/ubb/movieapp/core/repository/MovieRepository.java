package ro.ubb.movieapp.core.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import ro.ubb.movieapp.core.model.Movie;

import java.util.List;

public interface MovieRepository extends MovieAppRepository<Movie, Long> {
    @Query("select distinct m from Movie m")
    @EntityGraph(value = "movieWithActors", type =
            EntityGraph.EntityGraphType.LOAD)
    List<Movie> findAllWithActors();

    @Query("select distinct m from Movie m")
    @EntityGraph(value = "movieWithActors", type =
            EntityGraph.EntityGraphType.FETCH)
    List<Movie> findAll1();
}
