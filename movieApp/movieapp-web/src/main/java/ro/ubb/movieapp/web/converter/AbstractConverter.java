package ro.ubb.movieapp.web.converter;

import ro.ubb.movieapp.core.model.BaseEntity;
import ro.ubb.movieapp.web.dto.BaseDto;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class AbstractConverter<Model extends BaseEntity<Long>, Dto extends BaseDto>
        implements Converter<Model, Dto> {

    public Collection<Dto> convertModelsToDtos(Collection<Model> models) {
        return models.stream()
                .map(this::convertModelToDto)
                .collect(Collectors.toList());
    }

    public Collection<Model> convertDtosToModel(Collection<Dto> dtos) {
        return dtos.stream()
                .map(this::convertDtoToModel)
                .collect(Collectors.toList());
    }
}