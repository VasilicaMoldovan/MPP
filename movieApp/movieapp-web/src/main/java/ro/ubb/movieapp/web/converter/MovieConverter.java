package ro.ubb.movieapp.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubb.movieapp.core.model.Actor;
import ro.ubb.movieapp.core.model.BaseEntity;
import ro.ubb.movieapp.core.model.Movie;
import ro.ubb.movieapp.core.repository.MovieRepository;
import ro.ubb.movieapp.web.dto.MovieDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieConverter extends BaseConverter<Movie, MovieDto> {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie convertDtoToModel(MovieDto dto) {
        Movie movie = Movie.builder()
                .title(dto.getTitle())
                .year(dto.getYear())
                .actorList(movieRepository.findById(dto.getId()).get().getActorList())
                .build();
        movie.setId(dto.getId());
        return movie;
    }

    @Override
    public MovieDto convertModelToDto(Movie movie) {
        List<Long> actors = new ArrayList<>();
        List<Movie> movies = movieRepository.findAllWithActors();
        List<Actor> actorList = movies.stream().filter(movie1 -> movie1.getTitle().equals(movie.getTitle()))
                .collect(Collectors.toList()).get(0).getActorList();
        for (Actor value : actorList) {
            actors.add(value.getId());
        }
        MovieDto movieDto = MovieDto.builder()
                .title(movie.getTitle())
                .year(movie.getYear())
                .actors(actors)
                .build();
        movieDto.setId(movie.getId());
        return movieDto;
    }
}
