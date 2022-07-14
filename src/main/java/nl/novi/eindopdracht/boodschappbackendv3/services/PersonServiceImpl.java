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
    public List<Person> getPersonList() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findPersonListByPersonFirstname(String personFirstname) {

        var optionalPersonList = personRepository.findByPersonFirstnameContainingIgnoreCase(personFirstname);

        if (optionalPersonList.isEmpty()) {
            throw new RecordNotFoundException("oeps er ging iets fout.. Gebruiker met voornaam" + personFirstname + "bestaat niet..");
        }

        return optionalPersonList;
    }

    @Override
    public List<Person> findPersonListByPersonLastname(String personLastname) {

        var optionalPersonList = personRepository.findByPersonLastnameContainingIgnoreCase(personLastname);

        if (optionalPersonList.isEmpty()) {
            throw new RecordNotFoundException("oeps er ging iets fout.. Gebruiker met achternaam" + personLastname + "bestaat niet..");
        }

        return optionalPersonList;
    }

    @Override
    public Person getPerson(Long id) {

        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return person.get();

        } else {
            throw new RecordNotFoundException("persoon niet gevonden..");
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
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void updatePerson(Long id, Person person) {

        Optional<Person> optionalPerson = personRepository.findById(id);

        if (optionalPerson.isEmpty()) {
            throw new RecordNotFoundException("persoon bestaat niet..");
        }else {

            Person person1 = optionalPerson.get();
            person1.setId(person1.getId());
            person1.setPersonFirstname(person.getPersonFirstname());
            person1.setPersonLastname(person.getPersonLastname());
            person1.setPersonStreetName(person.getPersonStreetName());
            person1.setPersonHouseNumber(person.getPersonHouseNumber());
            person1.setPersonHouseNumberAdd(person.getPersonHouseNumberAdd());
            person1.setPersonCity(person.getPersonCity());
            person1.setPersonZipcode(person.getPersonZipcode());
            person1.setPersonRadius(person.getPersonRadius());

            personRepository.save(person1);
        }

    }

}

