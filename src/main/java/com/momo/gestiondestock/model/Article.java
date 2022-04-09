package com.momo.gestiondestock.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="article")

public class Article extends AbstractEntity{

    @Column(name = "codearticle")
    private String codearticle;


    @Column(name = "designation")
    private String designation;


    @Column(name = "prixunitaireht")
    private String prixunitaireht;


    @Column(name = "tauxtva")
    private String tauxtva;


    @Column(name = "prixunitairettc")
    private String prixunitairettc;


    @Column(name = "photo")
    private String photo;


    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
}
