package com.momo.gestiondestock.dto;

import com.momo.gestiondestock.model.AbstractEntity;
import com.momo.gestiondestock.model.CommandeClient;
import lombok.*;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder

public class CommandeClientDto extends AbstractEntity {

    private Integer id;


    private String code;


    private Instant dateCommande;



    private ClientDto client;


    private List<LigneCommandeClientDto> ligneCommandeClient;


    public static CommandeClientDto fromEntity(CommandeClient commandeClient){
        if (commandeClient == null) {
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if(commandeClientDto == null){
            return null;
        }

        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setDateCommande(commandeClientDto.getCreationDate());
        commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClient()));
        if(commandeClientDto.getLigneCommandeClient() != null){
            commandeClient.setLigneCommandeClient(commandeClientDto.getLigneCommandeClient().stream().map(LigneCommandeClientDto::toEntity).collect(Collectors.toList()));
        }
        return commandeClient;
    }
}