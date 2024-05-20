package com.expeditors.PetApp.controllers;

import com.expeditors.PetApp.models.Adopter;
import com.expeditors.PetApp.services.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/adopter")
public class AdopterController {
    @Autowired
    AdopterService adopterService;

    @GetMapping("/getByName/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name){
        List<Adopter> adopters = this.adopterService.getByNameAndId(name, 3);
        return ResponseEntity.ok(adopters);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        List<Object> adopters = this.adopterService.getInformationById(id);
        return ResponseEntity.ok(adopters);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Adopter adopter){
        Adopter newAdopter = this.adopterService.add(adopter);
        return ResponseEntity.ok(newAdopter);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Adopter adopter){
        this.adopterService.update(adopter);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> update(@PathVariable int id){
        this.adopterService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
