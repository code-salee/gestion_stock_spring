package com.momo.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.momo.gestiondestock.model.AbstractEntity;

import com.momo.gestiondestock.model.Entreprise;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder

public class EntrepriseDto  extends AbstractEntity {

    private Integer id;


    private String nom;

    private String description;

    private AdresseDto adresse;

    private String codeFiscal;

    private String email;

    private Instant numTel;

    private String siteWeb;;

    private String photo;

    @JsonIgnore
    private List<UtilisateurDto> utilisateur;

    public static EntrepriseDto fromEntity(Entreprise entreprise){
        if(entreprise == null){
            return null;
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .codeFiscal(entreprise.getCodeFiscal())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())
                .photo(entreprise.getPhoto())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if( entrepriseDto == null){ return null;}
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setNumTel(entrepriseDto.getNumTel());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        return entreprise;
    }
}

