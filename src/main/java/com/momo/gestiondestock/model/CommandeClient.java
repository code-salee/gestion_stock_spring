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
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="commandeclient")
public class CommandeClient extends AbstractEntity {

    @Column(name = "code")
    private String code;


    @Column(name = "datecommande")
    private Instant dateCommande;


    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;


    @OneToMany(mappedBy = "commandeClient")
    private List <LigneCommandeClient> ligneCommandeClient;


}
