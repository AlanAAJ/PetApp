package com.expeditors.PetApp.services;

import com.expeditors.PetApp.models.Adopter;
import com.expeditors.PetApp.repositorios.AdopterRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

public class AdopterService {
    @Autowired
    AdopterRepositorio adopterRepositorio;

    public List<Adopter> getByNameAndId(String name, int id){
        return this.adopterRepositorio.findByNameContainingAndId(name, id);
    }

    public Adopter add(Adopter adopter){
        return this.adopterRepositorio.save(adopter);
    }

    public void update(Adopter adopter){
        this.adopterRepositorio.findById(adopter.getId()) // returns Optional<User>
                .ifPresent(adopterToUpdate -> {
                    adopterToUpdate.setName(adopter.getName());
                    adopterToUpdate.setPhoneNumber(adopter.getPhoneNumber());
                    this.adopterRepositorio.save(adopterToUpdate);
                });
    }

    public void delete(int id){
        this.adopterRepositorio.deleteById(id);
    }

    public List<Object> getInformationById(int id){
        return this.adopterRepositorio.getInformationById(id);
    }
}
