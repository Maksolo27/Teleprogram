package com.example.teleprogram.controllers;


import com.example.teleprogram.configuration.SwaggerConfig;
import com.example.teleprogram.entities.Teleprogram;
import com.example.teleprogram.services.TVProgrammService;


import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teleprograms")
@Tag (name = SwaggerConfig.TAG_TELEPROGRAM,
        description = "Controller for CRUD operations with teleprograms"
)
public class TeleprogramController {

    @Autowired
    private TVProgrammService tvProgrammService;

    @GetMapping
    @ApiOperation (value = "Get list of teleprograms",
            code = 200,
            tags = {SwaggerConfig.TAG_TELEPROGRAM})
    public ResponseEntity<List<Teleprogram>> getTeleprogramlList () {
        return ResponseEntity.ok (tvProgrammService.getAllProgram ());
    }

    @PutMapping ("/create")
    @ApiOperation (value = "Add new teleprogram",
            code = 200,
            tags = {SwaggerConfig.TAG_TELEPROGRAM})
    public void putTeleprogram (@RequestBody Teleprogram teleprogram) {
        tvProgrammService.add (teleprogram);
    }

    @DeleteMapping ("/remove")
    @ApiOperation (value = "Remove teleprogram",
            code = 200,
            tags = {SwaggerConfig.TAG_TELEPROGRAM})
    public void removeTeleprogram (@RequestParam Long id) {
        tvProgrammService.remove (id);
    }

    @PostMapping("/update")
    @ApiOperation (value = "Update teleprogram",
            code = 200,
            tags = {SwaggerConfig.TAG_TELEPROGRAM})
    public void updateTeleprogram (@RequestBody Teleprogram teleprogram) {
        tvProgrammService.update (teleprogram);
    }
}
