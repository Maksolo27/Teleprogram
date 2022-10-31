package com.example.teleprogram.repositories;

import com.example.teleprogram.entities.Teleprogram;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TVProgrammRepository {
    private final List<Teleprogram> programms = new ArrayList<>();


    public TVProgrammRepository () {
        programms.add (new Teleprogram (0L, "Телегазета", "Середа 02 листопада", "1. Футбол 1 - ФК ХарківГазВидобича - ДЮСШ 26" +"\n"+ "2. ICTV - Ментівські війни (цілий день)" +"\n"+ "3. СТБ - Вагітна у 16"));
        programms.add (new Teleprogram (0L, "Телегазета", "Четвер 03 листопада", "1. Футбол 1 - ФК ХарківГазВидобича - ДЮСШ 26 2 тайм" +"\n"+ "2. ICTV - Пес 2 серія 6 сезон" +"\n"+ "3. СТБ - Слідство ведуть екснтрасенси"));
    }

    public List<Teleprogram> getAllProgram () {
        return programms;
    }

    public Teleprogram getProgrammById(long id) {
        return programms.get ((int) id);
    }

    public int getSize(){return  programms.size();}
}
