package ro.ubb.movieapp.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.movieapp.core.service.ActorService;
import ro.ubb.movieapp.core.service.MovieService;
import ro.ubb.movieapp.web.converter.ActorConverter;
import ro.ubb.movieapp.web.converter.MovieConverter;
import ro.ubb.movieapp.web.dto.ActorDto;
import ro.ubb.movieapp.web.dto.MovieDto;

import java.util.List;

@RestController
public class ActorController {
    public static final Logger log= LoggerFactory.getLogger(ActorController.class);

    @Autowired
    private ActorService actorService;
    @Autowired
    private ActorConverter actorConverter;

    @RequestMapping(value = "/actors", method = RequestMethod.GET)
    List<ActorDto> getActors() {
        log.trace("getActors - method entered");
        return  actorConverter
                .convertModelsToDtos(actorService.getAllActors());
    }

    @RequestMapping(value = "/actors/available", method = RequestMethod.GET)
    List<ActorDto> getAvailableActors() {
        log.trace("getAvailableActors - method entered");
        return actorConverter
                .convertModelsToDtos(actorService.getAllAvailableActors());
    }

}
