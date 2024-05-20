package com.expeditors.PetApp.repositorios;

import com.expeditors.PetApp.models.Adopter;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Repository
public interface AdopterRepositorio extends JpaRepository<Adopter, Integer>{
    List<Adopter> findByNameContainingAndId(String name, int id);

    @Query("SELECT pet.adopter.name FROM Pet pet WHERE pet.adopter.id = :id")
    List<Object> getInformationById(int id);
}
