package com.example.teleprogram.entities;

import lombok.Data;

@Data
public class User {

    private final int id;
    private final String login;
    private final String password;
    private final String status;

}
