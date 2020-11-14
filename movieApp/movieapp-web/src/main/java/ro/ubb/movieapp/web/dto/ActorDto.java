package ro.ubb.movieapp.web.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class ActorDto extends BaseDto{
    private String name;
    private int rating;
}
