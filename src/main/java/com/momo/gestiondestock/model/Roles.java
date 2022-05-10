package com.momo.gestiondestock.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")

public class Roles extends AbstractEntity{


    @Column(name = "libelle")
    private String libelle;

    @OneToMany(mappedBy = "roles")
    private List<Utilisateur> utilisateur;

    public Roles(String libelle){
        this.libelle = libelle;
    }
}
