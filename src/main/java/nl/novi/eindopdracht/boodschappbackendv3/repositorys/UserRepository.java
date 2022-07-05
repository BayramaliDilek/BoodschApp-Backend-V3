package nl.novi.eindopdracht.boodschappbackendv3.repositorys;

import nl.novi.eindopdracht.boodschappbackendv3.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByEmail(String email);
}

