package com.example.teleprogram.repositories;

import com.example.teleprogram.entities.Channel;
import com.example.teleprogram.entities.Teleprogram;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TVProgrammRepository {
    private List<Teleprogram> programms = new ArrayList<>();


    public TVProgrammRepository () {
        programms.add (new Teleprogram (2L, "Телегазета", "Середа 02 листопада", "1. Футбол 1 - ФК ХарківГазВидобича - ДЮСШ 26" +"\n"+ "2. ICTV - Ментівські війни (цілий день)" +"\n"+ "3. СТБ - Вагітна у 16"));
        programms.add (new Teleprogram (3L, "Телегазета", "Четвер 03 листопада", "1. Футбол 1 - ФК ХарківГазВидобича - ДЮСШ 26 2 тайм" +"\n"+ "2. ICTV - Пес 2 серія 6 сезон" +"\n"+ "3. СТБ - Слідство ведуть екснтрасенси"));
    }

    public List<Teleprogram> getAllProgram () {
        return programms;
    }

    public Teleprogram getProgrammById(long id) {
        return programms.get ((int) id);
    }

    public int getSize(){return  programms.size();}


    public void addTvProgram (Teleprogram teleprogram) {
        programms.add (teleprogram);
    }

    public void deleteProgramById (Long id) {
        programms = programms.stream()
                .filter (channel -> !channel.getId ().equals (id))
                .collect (Collectors.toList ());
    }

    public void updateProgram (Teleprogram teleprogram1) {
        programms = programms.stream()
                .filter (teleprogram -> !teleprogram.getId ().equals (teleprogram1.getId ()))
                .collect (Collectors.toList ());
        programms.add (teleprogram1);
    }

}
