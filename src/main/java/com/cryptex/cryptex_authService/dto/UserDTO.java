package com.cryptex.cryptex_authService.dto;

public class UserDTO {
    private String email;
    private String password;

    //no-arg constructor req by jackson lib in order to convert it into json
    public UserDTO() {}

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
