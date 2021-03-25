package org.portfolio.entities;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int login_id;
    private String username;
    private String password;

    public User() {
    }

    public int getLogin_id() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }

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
}
