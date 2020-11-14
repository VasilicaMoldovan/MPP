package ro.ubb.movieapp.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraphs({
        @NamedEntityGraph(name = "movieWithActors",
                attributeNodes = @NamedAttributeNode(value = "actorList"))
})

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
@Table(name = "movie")
@ToString(callSuper = true, exclude = "actorList")
public class Movie extends BaseEntity<Long> {
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "year", nullable = false)
    private int year;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch =
            FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    List<Actor> actorList;

    public Movie addActor(Actor actor){
        actorList.add(actor);
        return this;
    }

}

