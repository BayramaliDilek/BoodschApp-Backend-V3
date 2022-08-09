//package nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos;
//
//
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import nl.novi.eindopdracht.boodschappbackendv3.models.Authority;
//import nl.novi.eindopdracht.boodschappbackendv3.models.FileUploadResponse;
//import nl.novi.eindopdracht.boodschappbackendv3.models.Person;
//import nl.novi.eindopdracht.boodschappbackendv3.models.User;
//
//import javax.persistence.OneToOne;
//import java.util.Set;
//
//public class UserDto {
//
//    public String username;
//
//    @JsonSerialize
//    Person person;
//
//    @JsonSerialize
//    public Set<Authority> authorities;
//
//    @JsonSerialize
//    FileUploadResponse picture;
//
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public FileUploadResponse getPicture() {
//        return picture;
//    }
//
//    public void setPicture(FileUploadResponse picture) {
//        this.picture = picture;
//    }
//
//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
//}
