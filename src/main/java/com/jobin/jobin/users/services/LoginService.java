package com.jobin.jobin.users.services;


import com.jobin.jobin.users.models.User;
import com.jobin.jobin.users.repositories.UsersRepository;
import com.jobin.jobin.util.Constant;
import com.jobin.jobin.util.Security;
import org. springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    UsersRepository usersRepository;

    public Map<String , Object> login(String email, String password) {
        Map<String , Object> result  = new HashMap<>();
        try {
            User user = usersRepository.findByEmail(email);
            if (user != null) {
                if (Security.encrypt(password).equals(user.getPassword())) {
                    result.put("resultCode" , Constant.successResult);
                    result.put("resultMessage" , Constant.successLogin);
                    result.put("userType" , user.getUserTypeId());
                    return result;
                } else {
                    result.put("resultCode" , Constant.incorrectResult);
                    result.put("resultMessage" , Constant.incorrectPassword);
                    return result;
                }
            } else {
                result.put("resultCode" , Constant.emailNotFoundResult);
                result.put("resultMessage" ,Constant.emailNotFound);
                return result;
            }
        } catch (Exception e) {
            result.put("resultCode" , Constant.internalServerError);
            result.put("resultMessage" , e.getMessage());
            return result;
        }
    }
}
