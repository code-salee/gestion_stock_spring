package com.momo.gestiondestock.dto;

import com.momo.gestiondestock.model.AbstractEntity;
import com.momo.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@Builder


public class UtilisateurDto extends AbstractEntity {

    private Integer id;

    private String prenom;

    private String nom;

    private String email;

    private Date dateDeNaissance;

    private String motDepasse;

    private AdresseDto adresse;

    private String photo;

    private EntrepriseDto entreprise;

    private RolesDto roles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if(utilisateur == null){
            return null;
        }
        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .prenom(utilisateur.getPrenom())
                .nom(utilisateur.getNom())
                .email(utilisateur.getEmail())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .motDepasse(utilisateur.getMotDepasse())
                .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
                .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
                .roles(RolesDto.fromEntity(utilisateur.getRoles()))
                .photo(utilisateur.getPhoto())
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if(utilisateurDto == null){
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
        utilisateur.setMotDepasse(utilisateurDto.getMotDepasse());
        utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));
        utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntreprise()));
        utilisateur.setRoles(RolesDto.toEntity(utilisateurDto.getRoles()));
        utilisateur.setPhoto(utilisateurDto.getPhoto());
        return utilisateur;
    }
}

