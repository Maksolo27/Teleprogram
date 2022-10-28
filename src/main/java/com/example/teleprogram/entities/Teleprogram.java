package com.example.teleprogram.entities;

import lombok.Data;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Data
@Scope("singleton")
public class Teleprogram {


    private Long id;

    private String name;

    private Date date;

    private String description;


}
