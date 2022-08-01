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


//        ResponseEntity.ok().body(personService.getPersonList());

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

    @PutMapping(value = "/{username}")
    public ResponseEntity<Object> updateUser(@PathVariable("username") String username,
                                             @RequestBody User user) {

        userService.updateUser(username, user);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping(value = "/delete/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {

        userService.deleteUser(username);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {

        return ResponseEntity.ok().body(userService.getAuthorities(username));
    }

    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            userService.addAuthority(username, authorityName);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {

        userService.removeAuthority(username, authority);

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