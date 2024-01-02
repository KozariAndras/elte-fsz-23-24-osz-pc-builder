package elte.project.pcbuilder.domain.user;

import elte.project.pcbuilder.domain.user.User;
import jakarta.persistence.*;

@Entity
@Table(name="Credentials")
public class Credential {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private User user;
    private String username;
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return this.username;
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

}
