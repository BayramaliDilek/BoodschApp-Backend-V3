package nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.novi.eindopdracht.boodschappbackendv3.models.Authority;
import nl.novi.eindopdracht.boodschappbackendv3.models.FileUploadResponse;
import nl.novi.eindopdracht.boodschappbackendv3.models.User;

import java.util.Set;

public class UserDto {

    public String username;
    public String password;
    public String apikey;
    public String email;
    public Boolean enabled;

    @JsonSerialize
    public Set<Authority> authorities;

    @JsonSerialize
    FileUploadResponse picture;


//    public static UserDto fromUser(User user) {
//
//        var dto = new UserDto();
//
//        dto.username = user.getUsername();
//        dto.password = user.getPassword();
//        dto.apikey = user.getApikey();
//        dto.email = user.getEmail();
//        dto.enabled = user.isEnabled();
//        dto.authorities = user.getAuthorities();
//        dto.picture = user.getPicture();
//
//        return dto;
//
//    }


    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authority> getAuthorities() { return authorities; }

    public void setAuthorities(Set<Authority> authorities) { this.authorities = authorities; }

    public FileUploadResponse getPicture() {
        return picture;
    }

    public void setPicture(FileUploadResponse picture) {
        this.picture = picture;
    }
}
