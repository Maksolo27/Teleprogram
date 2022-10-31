package com.example.teleprogram.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;

@Data
public class User {

    private final int id;
    private final String login;
    private final String password;
    private final String status;

}
