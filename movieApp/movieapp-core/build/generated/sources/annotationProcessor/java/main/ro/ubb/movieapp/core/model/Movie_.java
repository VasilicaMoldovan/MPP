package ro.ubb.movieapp.core.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Movie.class)
public abstract class Movie_ extends ro.ubb.movieapp.core.model.BaseEntity_ {

	public static volatile SingularAttribute<Movie, Integer> year;
	public static volatile ListAttribute<Movie, Actor> actorList;
	public static volatile SingularAttribute<Movie, String> title;

	public static final String YEAR = "year";
	public static final String ACTOR_LIST = "actorList";
	public static final String TITLE = "title";

}

