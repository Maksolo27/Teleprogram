package com.example.teleprogram.services;

import com.example.teleprogram.repositories.TVProgrammRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Scope("singleton")
public class AdminService {

    @Autowired
    private TVProgrammRepository tvProgrammRepository;

    public List<String> showProgramm(){
        List<String> programms = new ArrayList<>();
        for (int i = 0; i < tvProgrammRepository.getSize(); i++) {
            programms.add(tvProgrammRepository.getProgrammById(i).getDate());
            String [] descript = tvProgrammRepository.getProgrammById(i).getDescription().split("\n");
            programms.addAll(Arrays.asList(descript));
        }
        return programms;
    }

    public void editProg(long id, String string){
        tvProgrammRepository.getProgrammById(id).setDescription(string);
    }

}
