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
    private String numTel;

    @Column(name = "siteweb")
    private String siteWeb;;

    @Column(name = "photo")
    private String photo;

    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateur;

    public Entreprise(String nom, String description, Adresse adresse, String codeFiscal, String email, String numTel, String siteWeb, String photo){
        this.nom = nom;
        this.description = description;
        this.adresse = adresse;
        this.codeFiscal = codeFiscal;
        this.email = email;
        this.numTel = numTel;
        this.siteWeb = siteWeb;
        this.photo = photo;
    }
}
