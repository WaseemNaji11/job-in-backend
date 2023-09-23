package com.jobin.jobin.users.controllers;



import com.jobin.jobin.users.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class LoginController {
    @Autowired
    LoginService loginService ;
    @GetMapping("/login")
    public Map<String , Object> login(@RequestParam String email , @RequestParam String password){
       return loginService.login(email , password)  ;
    }
}
