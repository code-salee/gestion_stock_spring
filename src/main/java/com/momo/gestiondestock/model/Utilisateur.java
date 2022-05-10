package com.momo.gestiondestock.model;

import javax.persistence.*;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="utilisateur")

public class Utilisateur extends AbstractEntity{

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "email")
    private String email;

    @Column(name = "datedenaissance")
    private Date dateDeNaissance;

    @Column(name = "motdepasse")
    private String motDepasse;

    @Embedded
    private Adresse adresse;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "id_entreprise")
    private Entreprise entreprise;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Roles roles;

    public Utilisateur (String prenom, String nom, String email, Date dateDeNaissance, String motDepasse, Adresse adresse, String photo, Entreprise entreprise, Roles roles){
        this.prenom = prenom;
        this.nom =nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.motDepasse = motDepasse;
        this.adresse = adresse;
        this.photo = photo;
        this.entreprise = entreprise;
        this.roles = roles;
    }
}
