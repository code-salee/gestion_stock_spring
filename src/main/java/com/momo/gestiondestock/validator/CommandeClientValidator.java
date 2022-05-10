package com.momo.gestiondestock.validator;

import com.momo.gestiondestock.dto.ClientDto;
import com.momo.gestiondestock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {
    public static List<String> CommandeClientValidate(CommandeClientDto commandeClientDto) {
        return getValidate(commandeClientDto == null, commandeClientDto.getCode(), commandeClientDto.getDateCommande(), commandeClientDto.getClient() == null);
    }

    private static List<String> getValidate(boolean commandeClient, String code, Instant dateCommande, boolean client) {
        List<String> errors = new ArrayList<>();
        if (commandeClient){
            errors.add("Veuillez renseigner le code commande du client");
            errors.add("Veuillez renseigner la date du commande du client");
            errors.add("Veuillez renseigner le client");;
            return errors;
        }
        if(!StringUtils.hasLength(code)){
            errors.add("Veuillez renseigner le code commande du client");
        }
        if(dateCommande == null){
            errors.add("Veuillez renseigner la date du commande du client");
        }
        if(client){
            errors.add("Veuillez renseigner le client");;
        }
        return errors;
    }
}
