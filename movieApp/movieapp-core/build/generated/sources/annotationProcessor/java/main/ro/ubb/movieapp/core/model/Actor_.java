package ro.ubb.movieapp.core.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Actor.class)
public abstract class Actor_ extends ro.ubb.movieapp.core.model.BaseEntity_ {

	public static volatile SingularAttribute<Actor, String> name;
	public static volatile SingularAttribute<Actor, Integer> rating;

	public static final String NAME = "name";
	public static final String RATING = "rating";

}

