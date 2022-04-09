package com.momo.gestiondestock.dto;


import com.momo.gestiondestock.model.AbstractEntity;
import com.momo.gestiondestock.model.Fournisseur;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder

public class FournisseurDto extends AbstractEntity {

    private Integer id;

    private String prenom;


    private String nom;


    private AdresseDto adresse;


    private String photo;


    private String email;


    private String numTel;


    private List<CommandeFournisseurDto> commandeFournisseur;

    public static FournisseurDto fromEntity(Fournisseur fournisseur){
        if(fournisseur == null){
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .prenom(fournisseur.getPrenom())
                .nom(fournisseur.getNom())
                .photo(fournisseur.getPhoto())
                .email(fournisseur.getEmail())
                .numTel(fournisseur.getNumTel())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto fournisseurDto){
        if(fournisseurDto == null){
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setPrenom(fournisseur.getPrenom());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setEmail(fournisseurDto.getEmail());
        fournisseur.setNumTel(fournisseur.getNumTel());
        if (fournisseurDto.getCommandeFournisseur() != null){
            fournisseur.setCommandeFournisseur(fournisseurDto.getCommandeFournisseur().stream().map(CommandeFournisseurDto::toEntity).collect(Collectors.toList()));
        }
        return fournisseur;
    }
}
