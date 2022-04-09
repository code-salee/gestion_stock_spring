package com.momo.gestiondestock.model;


import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper=true)
@Table(name="commandefournisseur")

public class CommandeFournisseur extends AbstractEntity{

    @Column(name = "commandefournisseur")
    private String code;


    @Column(name = "datecommande")
    private Instant dateCommande;


    @ManyToOne
    @JoinColumn(name = "id_fournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy="commandeFournisseur")
    private List<LigneCommandeFournisseur> ligneCommandFournisseurs;
}
