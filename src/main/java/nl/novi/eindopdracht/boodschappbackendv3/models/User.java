package nl.novi.eindopdracht.boodschappbackendv3.models;

import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String emailAdress;

    @Column
    private String password;

    @Column
    private String apikey;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
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


}
