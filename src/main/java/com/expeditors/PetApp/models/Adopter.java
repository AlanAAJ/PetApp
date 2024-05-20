package com.expeditors.PetApp.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Set;
@Entity
@Data
@ToString
public class Adopter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @OneToMany(mappedBy="adopter")
    private Set<Pet> pets;

    public Adopter() {
        this.name = name;
    }
}
