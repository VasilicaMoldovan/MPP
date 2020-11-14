package ro.ubb.movieapp.core.model;

import lombok.*;

import javax.persistence.*;

@NamedEntityGraphs({
        @NamedEntityGraph(name = "actorWithMovie",
                attributeNodes = @NamedAttributeNode(value = "movie"))
})

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
@Table(name = "actor")
@ToString(callSuper = true, exclude = "movie")
public class Actor extends BaseEntity<Long> {
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "rating", nullable = false)
    private int rating;

    //@Id
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "movie_id", nullable = true)
    //private Movie movie;
}


