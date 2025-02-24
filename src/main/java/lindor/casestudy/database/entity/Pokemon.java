package lindor.casestudy.database.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pok_id")
    private Integer id;

    @Column(name = "pok_name")
    private String name;

    @Column(name = "pok_height")
    private Integer pokHeight;

    @Column(name = "pok_weight")
    private Integer pokWeight;

    @Column(name = "pok_base_experience")
    private Integer pokBaseExperience;
}