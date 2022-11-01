package com.example.teleprogram.services;

import com.example.teleprogram.repositories.TVProgrammRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private TVProgrammRepository tvProgrammRepository;

    public List<String> showProgramm(){
        List<String> programms = new ArrayList<>();
        for (int i = 0; i < tvProgrammRepository.getSize(); i++) {
            programms.add(tvProgrammRepository.getProgrammById(i).getDate());
            String [] descript = tvProgrammRepository.getProgrammById(i).getDescription().split("\n");
            for (int j = 0; j < descript.length ; j++) {
                programms.add(descript[j]);
            }
        }
        return programms;
    }

    public void editProg(long id, String string){
        tvProgrammRepository.getProgrammById(id).setDescription(string);
    }

}
