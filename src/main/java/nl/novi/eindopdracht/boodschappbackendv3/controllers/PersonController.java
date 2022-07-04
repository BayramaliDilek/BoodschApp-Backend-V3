//package nl.novi.eindopdracht.boodschappbackendv3.controllers;
//
//import nl.novi.eindopdracht.boodschappbackendv3.models.Person;
//import nl.novi.eindopdracht.boodschappbackendv3.models.User;
//import nl.novi.eindopdracht.boodschappbackendv3.services.PersonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/userprofile")
//public class PersonController {
//
//    private final PersonService personService;
//
//    @Autowired
//    public PersonController(PersonService personService) {
//        this.personService = personService;
//    }
//
//    @GetMapping("{id}")
//    public List<Person> getPerson() {
//        return personService.getPerson();
//
//    }
//
//    @PostMapping
//    public void createNewPerson(@RequestBody Person person) {
//        personService.addNewPerson(person);
//    }
//
////    @DeleteMapping(path = "/user/{id}")
////    public void deletePerson(
////            @PathVariable("user/{Id}") Long personId) {
////        personService.deletePerson(personId);
////    }
//
//
//}