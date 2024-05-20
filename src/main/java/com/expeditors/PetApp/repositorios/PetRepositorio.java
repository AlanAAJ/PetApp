package com.expeditors.PetApp.repositorios;
import com.expeditors.PetApp.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PetRepositorio extends JpaRepository<Pet, Integer>{
    List<Pet> findByNameContaining(String name);
}
