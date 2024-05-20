package com.expeditors.PetApp.controllers;

import com.expeditors.PetApp.models.Pet;
import com.expeditors.PetApp.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pet")
public class PetController {
    @Autowired
    PetService petService;

    @GetMapping("/getByName/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name){
        List<Pet> pets = this.petService.getByNameAndId(name);
        return ResponseEntity.ok(pets);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Pet pet){
        Pet newPet = this.petService.add(pet);
        return ResponseEntity.ok(newPet);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Pet pet){
        this.petService.update(pet);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> update(@PathVariable int id){
        this.petService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
