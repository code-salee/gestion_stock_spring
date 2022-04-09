package com.momo.gestiondestock.validator;

import com.momo.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate (UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList();
        if(utilisateurDto == null){
            errors.add("Veuillez renseigner le prenom de la catégorie");
            errors.add("Veuillez renseigner le nom de la catégorie");
            errors.add("Veuillez renseigner l'email de la catégorie");
            errors.add("Veuillez renseigner le mot de passe  de la catégorie");
            errors.add("Veuillez renseigner le photo de la catégorie");
            errors.add("Veuillez renseigner l'adresse de la catégorie");
            errors.add("Le champ adresse 1 est obligatoire");
            errors.add("Le champ ville  est obligatoire");
            errors.add("Le champ code postal est obligatoire");
            errors.add("Le champ pays est obligatoire");
        }
        if(StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Veuillez renseigner le prenom de la catégorie");
        }
        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("Veuillez renseigner le nom de la catégorie");
        }
        if(!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("Veuillez renseigner l'email de la catégorie");
        }
        if(!StringUtils.hasLength(utilisateurDto.getMotDepasse())){
            errors.add("Veuillez renseigner le mot de passe  de la catégorie");
        }
        if(!StringUtils.hasLength(utilisateurDto.getPhoto())){
            errors.add("Veuillez renseigner le photo de la catégorie");
        }
        if(utilisateurDto.getDateDeNaissance() == null){
            errors.add("Veuillez renseigner la date de naissance de la catégorie");
        }
        if(utilisateurDto.getAdresse() == null){
            errors.add("Veuillez renseigner l'adresse de la catégorie");
        }
        else {
            if(utilisateurDto.getAdresse().getAdresse1()  == null){
                errors.add("Le champ adresse 1 est obligatoire");
            }
            if(utilisateurDto.getAdresse().getVille()  == null){
                errors.add("Le champ ville  est obligatoire");
            }
            if(utilisateurDto.getAdresse().getCodePostale()  == null){
                errors.add("Le champ code postal est obligatoire");
            }
            if(utilisateurDto.getAdresse().getPays() == null){
                errors.add("Le champ pays est obligatoire");
            }
        }
        return errors;
    }
}
