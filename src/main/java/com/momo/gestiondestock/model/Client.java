package com.momo.gestiondestock.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.momo.gestiondestock.model.Adresse;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="client")
public class Client extends AbstractEntity{

    @Column(name = "prenom")
    private String prenom;


    @Column(name = "nom")
    private String nom;


    @Embedded
    private Adresse adresse;


    @Column(name = "photo")
    private String photo;


    @Column(name = "email")
    private String email;


    @Column(name = "numTel")
    private String numTel;


    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClient;

    public Client(String prenom, String nom, Adresse adresse, String photo, String email, String numTel) {
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.photo = photo;
        this.email = email;
        this.numTel = numTel;
    }
}
