package com.example.teleprogram.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teleprogram {


    private Integer id;

    private String date;

    private String description;


}
