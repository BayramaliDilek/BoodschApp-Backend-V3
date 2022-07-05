package nl.novi.eindopdracht.boodschappbackendv3.controllers;

import nl.novi.eindopdracht.boodschappbackendv3.dtos.PersonDto;
import nl.novi.eindopdracht.boodschappbackendv3.models.Person;
import nl.novi.eindopdracht.boodschappbackendv3.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonDto> getPersons(){

        var dtos = new ArrayList<PersonDto>();
        var persons = personService.getPersons();
        for (Person person : persons) {
            dtos.add(PersonDto.fromPerson(person));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable("id")Long id) {

        var person = personService.getPerson(id);

        return PersonDto.fromPerson(person);

    }

    @PostMapping("/createperson")
    public void createNewPerson(@RequestBody Person person) {
        personService.createPerson(person);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(
            @PathVariable("id") Long personId) {
        personService.deletePerson(personId);
    }


}