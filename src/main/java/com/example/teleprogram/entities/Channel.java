package com.example.teleprogram.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Scope("prototype")
public class Channel {

    private Long id;

    private String name;

    private String description;



}
