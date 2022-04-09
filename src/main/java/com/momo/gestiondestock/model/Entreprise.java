package com.momo.gestiondestock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="entreprise")
public class Entreprise  extends AbstractEntity{


    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Embedded
    private Adresse adresse;

    @Column(name = "codefiscal")
    private String codeFiscal;

    @Column(name = "email")
    private String email;

    @Column(name = "numtel")
    private Instant numTel;

    @Column(name = "siteweb")
    private String siteWeb;;

    @Column(name = "photo")
    private String photo;

    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateur;
}
