package nl.novi.eindopdracht.boodschappbackendv3.controllers;


import nl.novi.eindopdracht.boodschappbackendv3.dtos.UserDto;
import nl.novi.eindopdracht.boodschappbackendv3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{username}")
    public UserDto getUserByUsername(@PathVariable String username) {
        return userService.getUser(username);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto dto) {

        String newUsername = userService.saveUser(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("username") String username, @RequestBody UserDto dto) {

        userService.updateUser(username, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

}