package com.example.teleprogram.repositories;

import com.example.teleprogram.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersRepository {

    private final List<User> users = new ArrayList<>();

    public UsersRepository () {
        users.add (new User(0,"viewer", "123","viewer"));
        users.add (new User(1,"admin", "321", "admin"));
    }

    public User getUserById(long id) {
        return users.get ((int) id);
    }

    public int getSize(){
        return users.size();
    }
}
