package com.expeditors.PetApp.models;
import com.expeditors.PetApp.types.BreedType;
import com.expeditors.PetApp.types.PetType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@ToString
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="adopterid", nullable=false)
    @Getter(AccessLevel.NONE)
    private Adopter adopter;

    @Column(name = "adoptiondate")
    private LocalDate adoptionDate;

    @Column(name = "pettypeid")
    @Enumerated
    private PetType petTypeId;

    @Column(name = "breedtypeid")
    @Enumerated
    private BreedType breedType;

    private String name;
}
