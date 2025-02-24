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
@Table(name = "pokemon_teams", uniqueConstraints = @UniqueConstraint(columnNames = {"pok_id", "team_id"}))
public class PokemonTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pok_id", nullable = false)
    private Pokemon pokemon;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
}