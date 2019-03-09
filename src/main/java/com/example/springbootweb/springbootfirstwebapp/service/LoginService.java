package com.example.springbootweb.springbootfirstwebapp.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean validateUser(String user_id, String password) {
        return user_id.equalsIgnoreCase("santy") && password.equalsIgnoreCase("santy@123");
    }
}
