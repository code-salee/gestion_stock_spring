package com.momo.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.momo.gestiondestock.model.AbstractEntity;
import com.momo.gestiondestock.model.Adresse;
import com.momo.gestiondestock.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class ClientDto extends AbstractEntity {

    private Integer id;


    private String prenom;


    private String nom;


    private Adresse adresse;


    private String photo;


    private String email;


    private String numTel;


    @JsonIgnore
    private List<CommandeClientDto> commandeClient;

    public static ClientDto fromEntity(Client client){
        if (client == null){
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .prenom(client.getPrenom())
                .nom(client.getNom())
                .photo(client.getPhoto())
                .email(client.getEmail())
                .numTel(client.getNumTel())
                .build();
        }


    public static Client toEntity(ClientDto clientDto){
        if(clientDto == null){
            return null;
        }

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setPrenom(client.getPrenom());
        client.setNom(clientDto.getNom());
        client.setPhoto(clientDto.getPhoto());
        client.setEmail(clientDto.getEmail());
        client.setNumTel(clientDto.getNumTel());
        return client;
    }
}
