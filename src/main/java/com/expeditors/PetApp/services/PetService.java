package com.expeditors.PetApp.services;

import com.expeditors.PetApp.models.Pet;
import com.expeditors.PetApp.models.Adopter;
import com.expeditors.PetApp.repositorios.PetRepositorio;
import com.expeditors.PetApp.repositorios.AdopterRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    PetRepositorio petRepositorio;

    public List<Pet> getByNameAndId(String name){
        return this.petRepositorio.findByNameContaining(name);
    }

    public Pet add(Pet pet){
        return this.petRepositorio.save(pet);
    }

    public void update(Pet pet){
        this.petRepositorio.findById(pet.getId())
                .ifPresent(petToUpdate -> {
                    petToUpdate.setName(pet.getName());
                    petToUpdate.setPetTypeId(pet.getPetTypeId());
                    petToUpdate.setBreedType(pet.getBreedType());
                    petToUpdate.setAdoptionDate(pet.getAdoptionDate());
                    this.petRepositorio.save(petToUpdate);
                });
    }

    public void delete(int id){
        this.petRepositorio.deleteById(id);
    }
}
