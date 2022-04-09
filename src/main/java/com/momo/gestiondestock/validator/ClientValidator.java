package com.momo.gestiondestock.validator;

import com.momo.gestiondestock.dto.ArticleDto;
import com.momo.gestiondestock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> Articlevalidate(ClientDto clientDto) {
        return getValidate(clientDto == null, clientDto.getPrenom(), clientDto.getNom(), clientDto.getPhoto(),
                clientDto.getEmail(), clientDto.getNumTel());
    }

    private static List<String> getValidate(boolean client, String prenom, String nom, String photo, String email,  String numTel) {
        List<String> errors = new ArrayList<>();
        if (client){
            errors.add("Veuillez renseigner le prenom du client");
            errors.add("Veuillez renseigner le nom du client");
            errors.add("Veuillez renseigner le photo du client");;
            errors.add("Veuillez renseigner l'email du client");
            errors.add("Veuillez renseigner le numero telephone du client");
            return errors;
        }
        if(!StringUtils.hasLength(prenom)){
            errors.add("Veuillez renseigner le prenom du client");
        }
        if(!StringUtils.hasLength(nom)){
            errors.add("Veuillez renseigner le nom du client");
        }
        if(!StringUtils.hasLength(photo)){
            errors.add("Veuillez renseigner le photo du client");;
        }
        if(!StringUtils.hasLength(email)){
            errors.add("Veuillez renseigner l'email du client");
        }
        if(!StringUtils.hasLength(numTel)){
            errors.add("Veuillez renseigner le numero telephone du client");
        }
        return errors;
    }
}
