package ro.ubb.movieapp.web.converter;

import ro.ubb.movieapp.core.model.BaseEntity;
import ro.ubb.movieapp.web.dto.BaseDto;

public interface ConverterBaseEntity<Model extends BaseEntity<Long>, Dto extends BaseDto>
        extends Converter<Model, Dto> {

}
