package com.momo.gestiondestock.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="mvtstk")

public class MvtStk extends AbstractEntity {

    @Column(name = "datemvt")
    private Instant dateMvt;


    @Column(name = "quantite")
    private String quantite;


    @Column(name = "typemvt")
    private String typeMvt;


    @ManyToOne
    @JoinColumn(name = "id_article")
    private Article article;
}