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
@EqualsAndHashCode(callSuper=true)
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
}
