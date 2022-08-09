package nl.novi.eindopdracht.boodschappbackendv3.controllers;


import nl.novi.eindopdracht.boodschappbackendv3.exceptions.BadRequestException;
import nl.novi.eindopdracht.boodschappbackendv3.models.User;
import nl.novi.eindopdracht.boodschappbackendv3.services.PersonService;
import nl.novi.eindopdracht.boodschappbackendv3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {


    private final UserService userService;

    private final PhotoController photoController;

    private final PersonService personService;

    @Autowired
    public UserController(UserService userService, PhotoController photoController, PersonService personService) {
        this.userService = userService;
        this.photoController = photoController;
        this.personService = personService;
    }


    @GetMapping("/all")
    public ResponseEntity<Object> getUsers() {

        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<Object> getUser(@PathVariable("username") String username) {

        return ResponseEntity.ok().body(userService.getUser(username));

    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {

        String newUsername = userService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable("username") String username) {

        userService.deleteUser(username);

        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{username}/{personId}")
    public void assignPersonToUser(@PathVariable("username") String username,
                                   @PathVariable("personId") Long personId) {

        userService.assignPersonToUser(personId, username);

    }


    @PutMapping("/{username}/picture/{fileName}")
    public void assignPictureToUser(@PathVariable("username") String username,
                                    @PathVariable("fileName") String fileName) {

        userService.assignPictureToUser(fileName, username);
    }


    @PutMapping("/{username}/picture")
    public void uploadPictureToUser(@PathVariable("username") String username,
                                    @RequestBody MultipartFile file) {

        photoController.singleFileUpload(file);
        userService.assignPictureToUser(file.getOriginalFilename(), username);
    }

}