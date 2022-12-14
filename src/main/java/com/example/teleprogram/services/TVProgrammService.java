package com.example.teleprogram.services;

import com.example.teleprogram.entities.Teleprogram;
import com.example.teleprogram.repositories.TVProgrammRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TVProgrammService {
    private TVProgrammRepository tvProgrammRepository;
    @Autowired
    public TVProgrammService(TVProgrammRepository tvProgrammRepository) {
        this.tvProgrammRepository = tvProgrammRepository;
    }

    public List<Teleprogram> getAllProgram () {return tvProgrammRepository.getAllProgram();}

    public Teleprogram getProgrammById(long id) {
        return tvProgrammRepository.getProgrammById(id);
    }

    public int getSize(){return tvProgrammRepository.getSize();}


}
