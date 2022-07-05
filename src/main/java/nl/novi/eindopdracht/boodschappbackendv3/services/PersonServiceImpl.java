package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.exceptions.RecordNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.models.Person;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPerson(Long id) {

        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {

            return person.get();

        } else {

            throw new RecordNotFoundException("Gebruiker niet gevonden");

        }
    }

    @Override
    public void deletePerson(Long id) {
        boolean exists = personRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "gebruiker met id " + id + " bestaat niet");
        }
        personRepository.deleteById(id);
    }

    @Override
    public void createPerson(Person person) {
        personRepository.save(person);
    }
}
