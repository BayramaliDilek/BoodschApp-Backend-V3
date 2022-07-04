package nl.novi.eindopdracht.boodschappbackendv3.dtos;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.novi.eindopdracht.boodschappbackendv3.models.Authority;

import java.util.Set;

public class UserDto {

    public String username;
    public String password;
    public String apikey;

    @JsonSerialize
    public Set<Authority> authorities;





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

    public Set<Authority> getAuthorities() { return authorities; }

    public void setAuthorities(Set<Authority> authorities) { this.authorities = authorities; }
}
