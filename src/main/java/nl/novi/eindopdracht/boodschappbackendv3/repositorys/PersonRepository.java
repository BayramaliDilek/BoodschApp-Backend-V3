package nl.novi.eindopdracht.boodschappbackendv3.repositorys;

import nl.novi.eindopdracht.boodschappbackendv3.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByPersonFirstnameContainingIgnoreCase(String personFirstname);

    List<Person> findByPersonLastnameContainingIgnoreCase(String personLastname);
}

