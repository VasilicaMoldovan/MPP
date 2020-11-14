package ro.ubb.movieapp.web.dto;

import lombok.*;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class MovieDto extends BaseDto{
    private String title;
    private int year;
    private List<Long> actors;
}
