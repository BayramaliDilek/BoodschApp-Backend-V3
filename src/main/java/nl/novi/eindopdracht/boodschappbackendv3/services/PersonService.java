//package nl.novi.eindopdracht.boodschappbackendv3.services;
//
//import nl.novi.eindopdracht.boodschappbackendv3.models.Person;
//import nl.novi.eindopdracht.boodschappbackendv3.repositorys.PersonRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//@Service
//public class PersonService{
//
//    private final PersonRepository personRepository;
//
//    @Autowired
//    public PersonService(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
//
//    public List<Person> getPersons() {
//        return personRepository.findAll();
//    }
//
//    public List<Person> getPerson() {
//        return personRepository.findById();
//    }
//
//
//
//    public void deletePerson(Long id) {
//        boolean exists = personRepository.existsById(id);
//        if (!exists) {
//            throw new IllegalStateException(
//                    "gebruiker met id " + id + " bestaat niet");
//        }
//        personRepository.deleteById(id);
//    }
//
//    public void addNewPerson(Person person) {
//        Optional<Person> personOptional = personRepository
//                .findPersonByEmail(person.getEmail());
//        if (personOptional.isPresent()) {
//            throw new IllegalStateException("oei er ging iets fout.. Controleer uw gegevens, het kan zijn dat uw email al in gebruik is..");
//        }
//        personRepository.save(person);
//    }
//}
