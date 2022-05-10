package com.momo.gestiondestock.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper= false)
@Entity
@Table(name="article")

public class Article {

    @Id
    @GeneratedValue
    private Integer id;


    @CreatedDate
    @Column(name="creationDate", nullable=false)
    @JsonIgnore
    private Date creationDate = new Date();


    @LastModifiedDate
    @Column(name="modificationDate", nullable = true)
    @JsonIgnore
    private Date modificationDate;

    @Column(name = "codearticle", unique=true, nullable = false)
    private String codearticle;


    @Column(name = "designation", nullable = false)
    private String designation;


    @Column(name = "prixunitaireht", nullable = false)
    private String prixunitaireht;


    @Column(name = "tauxtva")
    private String tauxtva;


    @Column(name = "prixunitairettc", nullable = false)
    private String prixunitairettc;


    @Column(name = "photo", nullable = true)
    private String photo;


    @ManyToOne()
    @JoinColumn(name = "id_category")
    private Category category;

    public Article(String codearticle, String designation, String prixunitaireht, String tauxtva, String prixunitairettc, String photo, Category category) {

        this.codearticle = codearticle;
        this.designation = designation;
        this.prixunitaireht = prixunitaireht;
        this.tauxtva = tauxtva;
        this.prixunitairettc = prixunitairettc;
        this.photo = photo;
        this.category = category;
    }

}
