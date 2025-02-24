package lindor.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import lindor.casestudy.database.entity.User;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User findById(@Param("id") Integer id);


    // JPA/HQL Query: @Query("select u from users u where u.email = :email")
    @Query(value = "select * from users where email = :email", nativeQuery = true)
    User findByEmail(@Param("email") String email);
    List<User> findByDisplayNameIgnoreCaseContaining(@Param("displayName") String displayName);

    List<User> findByDisplayNameIgnoreCaseAndRegionIgnoreCase(@Param("displayName") String displayName, @Param("region") String region);


}