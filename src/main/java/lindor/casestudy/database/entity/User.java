package lindor.casestudy.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "display_name")
    private String displayName;

    @NonNull
    @Column(name = "region")
    private String region;

    @NonNull
    @Column(name = "password")
    private String password;

    @NonNull
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate = new Date();
}