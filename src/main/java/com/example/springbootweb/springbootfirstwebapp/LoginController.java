package com.example.springbootweb.springbootfirstwebapp;


import com.example.springbootweb.springbootfirstwebapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    LoginService service;

    @GetMapping("/login")
    @ResponseBody
    public  String showLoginPage(@RequestParam String name){
        return  "Welcome get  " + name;
    }

    @PostMapping("/login")
    @ResponseBody
    public  String showWelcomePage(@RequestParam String name, @RequestParam String password){
        boolean isValidUser = service.validateUser(name, password);

        if (isValidUser){
            return "User login Successfully";
        }else{
            return "User login Failed";
        }
     }
}