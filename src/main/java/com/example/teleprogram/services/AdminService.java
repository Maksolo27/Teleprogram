package com.example.teleprogram.services;

import com.example.teleprogram.entities.Teleprogram;
import com.example.teleprogram.repositories.TVProgrammRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private TVProgrammRepository tvProgrammRepository = new TVProgrammRepository();

    public String[] showProgramm(int id){
        return tvProgrammRepository.getProgrammById(id).getDescription().split("\\|");
    }

    public void editProg(int id, Teleprogram teleprogram){
        Teleprogram programmToUpdate = tvProgrammRepository.getProgrammById(id);
        programmToUpdate.setDate(teleprogram.getDate());
        programmToUpdate.setDescription(teleprogram.getDescription());
    }
}
