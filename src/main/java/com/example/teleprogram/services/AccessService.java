package com.example.teleprogram.services;

import com.example.teleprogram.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessService {
    @Autowired
    UsersRepository usersRepository;

    public String access(String login, String password){
        for (int i = 0; i < usersRepository.getSize(); i++) {
            if (usersRepository.getUserById(i).getLogin().equals(login) && usersRepository.getUserById(i).getPassword().equals(password)){
                return usersRepository.getUserById(i).getStatus();
            }
        }
        return "user not found";
    }
}
