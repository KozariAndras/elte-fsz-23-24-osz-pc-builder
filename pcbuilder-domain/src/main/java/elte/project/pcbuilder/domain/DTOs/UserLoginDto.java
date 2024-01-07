package elte.project.pcbuilder.domain.DTOs;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserLoginDto {

    @NotNull
    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @NotNull
    @NotEmpty(message = "Password cannot be empty")
    private String password;

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

