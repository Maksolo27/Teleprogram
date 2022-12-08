package com.example.teleprogram.repositories;

import com.example.teleprogram.entities.Teleprogram;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TVProgrammRepository {
    private final List<Teleprogram> programms = new ArrayList<>();


    public TVProgrammRepository () {
        programms.add (new Teleprogram (0,  "Четвер 07 грудня", "1. Футбол 1 - ФК ХарківГазВидобича - ДЮСШ 26|2. ICTV - Ментівські війни (цілий день)|3. СТБ - Вагітна у 16"));
        programms.add (new Teleprogram (1, "П'ятниця 08 грудня", "1. Футбол 1 - ФК ХарківГазВидобича - ДЮСШ 26 2 тайм|2. ICTV - Пес 2 серія 6 сезон|3. СТБ - Слідство ведуть екснтрасенси"));
    }

    public List<Teleprogram> getAllProgram () {
        return programms;
    }

    public Teleprogram getProgrammById(int id) {
        return programms.get(Math.toIntExact(id));
    }


    public int getSize(){return programms.size();}

    public void add(Teleprogram teleprogram){programms.add(teleprogram);}

    public void delete(int id){programms.removeIf(p->p.getId() == id);}

}
