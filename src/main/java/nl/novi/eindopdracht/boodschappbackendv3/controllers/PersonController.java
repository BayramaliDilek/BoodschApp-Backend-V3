package nl.novi.eindopdracht.boodschappbackendv3.controllers;

import nl.novi.eindopdracht.boodschappbackendv3.dtos.PersonDto;
import nl.novi.eindopdracht.boodschappbackendv3.dtos.PersonInputDto;
import nl.novi.eindopdracht.boodschappbackendv3.models.Person;
import nl.novi.eindopdracht.boodschappbackendv3.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    @GetMapping("/users")
    @Transactional
    public List<PersonDto> getPersonList(@RequestParam(value = "firstname", required = false, defaultValue = "")String personFirstname,
                                         @RequestParam(value = "lastname", required = false, defaultValue = "")String personLastname){

        var dtos = new ArrayList<PersonDto>();

        List<Person> personList;

        if (personFirstname == null && personLastname == null) {
            personList = personService.getPersonList();

        } else if (personFirstname != null && personLastname == null) {
            personList = personService.findPersonListByPersonFirstname(personFirstname);

        }else {
            personList = personService.findPersonListByPersonLastname(personLastname);
        }

        for (Person person : personList) {
            dtos.add(PersonDto.fromPerson(person));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable("id")Long id) {

        var person = personService.getPerson(id);

        return PersonDto.fromPerson(person);

    }

    @PostMapping
    public PersonDto savePerson(@RequestBody PersonInputDto dto) {

        var person = personService.savePerson(dto.toPerson());

        return PersonDto.fromPerson(person);
    }

    @PutMapping("/{id}")
    public PersonDto updatePerson(@PathVariable Long id,
                                  @RequestBody Person person) {
        personService.updatePerson(id, person);

        return PersonDto.fromPerson(person);
    }


    @DeleteMapping(path = "{id}")
    public void deletePerson(
            @PathVariable("id") Long personId) {
        personService.deletePerson(personId);
    }












}