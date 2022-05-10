package com.momo.gestiondestock.service.impl;

import com.momo.gestiondestock.dto.CommandeClientDto;
import com.momo.gestiondestock.dto.LigneCommandeClientDto;
import com.momo.gestiondestock.exception.EntityNotFoundException;
import com.momo.gestiondestock.exception.ErrorCodes;
import com.momo.gestiondestock.exception.InvalidEntityException;
import com.momo.gestiondestock.model.Article;
import com.momo.gestiondestock.model.Client;
import com.momo.gestiondestock.model.CommandeClient;
import com.momo.gestiondestock.model.LigneCommandeClient;
import com.momo.gestiondestock.repository.ArticleRepository;
import com.momo.gestiondestock.repository.ClientRepository;
import com.momo.gestiondestock.repository.CommandeClientRepository;
import com.momo.gestiondestock.repository.LigneCommandeClientRepository;
import com.momo.gestiondestock.service.CommandeClientService;
import com.momo.gestiondestock.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;


    @Autowired
    public  CommandeClientServiceImpl (  CommandeClientRepository commandeClientRepository, ClientRepository clientRepository, ArticleRepository articleRepository, LigneCommandeClientRepository ligneCommandeClientRepository){

        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.CommandeClientValidate(dto);
        if(!errors.isEmpty()){
            log.error("Commande client is not valid {}", dto);
            throw new InvalidEntityException("La commande du client n'est valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
        }

        Optional <Client> client = clientRepository.findById(dto.getClient().getId());
        if(client.isEmpty()){
            log.warn("Client with ID {} was  is not found", dto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec " + dto.getClient().getId() + "n'existe dans la base de données", ErrorCodes.CLIENT_NOT_FOUND);
        }
        List<String> articleErrors = new ArrayList<>();

        if(dto.getLigneCommandeClient() != null){
            dto.getLigneCommandeClient().forEach(lignCmdClt ->
                    {
                        if(lignCmdClt.getArticle() != null){
                            Optional <Article> article = articleRepository.findById(lignCmdClt.getArticle().getId());
                            if(article.isEmpty()){
                                throw new InvalidEntityException("L'artcile n'existe pas dans BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
                            }
                        }
                    }

            );
        }
        CommandeClient saveCmdClient = commandeClientRepository.save(CommandeClientDto.toEntity(dto));

        if(dto.getLigneCommandeClient() != null){
            dto.getLigneCommandeClient().forEach(ligneCmdClient ->{
                        LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligneCmdClient);
                        ligneCommandeClient.setCommandeClient(saveCmdClient);
                        ligneCommandeClientRepository.save(ligneCommandeClient);
                    }

            );
        }

        return CommandeClientDto.fromEntity((saveCmdClient));
    }
    @Override
    public List<CommandeClientDto> findAll() {
    return  commandeClientRepository.findAll().stream()
            .map(CommandeClientDto::fromEntity)
            .collect(Collectors.toList());
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if(id == null){
           log.error("Commande client ID is null");

           return null;
        }
        return commandeClientRepository.findById(id)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Commande client avec id "+ id +" n'existe pas", ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public Optional<CommandeClient> findByCodeAndIdNot(String code, Long id) {
        return Optional.empty();
    }


    @Override
    public Optional<CommandeClient> findByDateCommande(Instant dateCommande) {
        return Optional.empty();
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Commande client code is null");
            return null;
        }
        return commandeClientRepository.findByCode(code)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Commande client avec id "+ code +" n'existe pas", ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public CommandeClientDto put(CommandeClientDto dto, Integer id) {
        List<String> Errors = CommandeClientValidator.CommandeClientValidate(dto);
        if(!Errors.isEmpty()){
            log.error("Commande client is not valid {}", dto);
            throw new InvalidEntityException("La commande du client n'est valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, Errors);
        }

        Optional <Client> client = clientRepository.findById(dto.getClient().getId());
        if(client.isEmpty()){
            log.warn("Client with ID {} was  is not found", dto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec " + dto.getClient().getId() + "n'existe dans la base de données", ErrorCodes.CLIENT_NOT_FOUND);
        }
        List<String> articleErrors = new ArrayList<>();

        if(dto.getLigneCommandeClient() != null){
            dto.getLigneCommandeClient().forEach(lignCmdClt ->
                    {
                        if(lignCmdClt.getArticle() != null){
                            Optional <Article> article = articleRepository.findById(lignCmdClt.getArticle().getId());
                            if(article.isEmpty()){
                                throw new InvalidEntityException("L'artcile n'existe pas dans BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
                            }
                        }
                    }

            );
        }
        CommandeClient saveCmdClient = commandeClientRepository.save(CommandeClientDto.toEntity(dto));

        if(dto.getLigneCommandeClient() != null){
            dto.getLigneCommandeClient().forEach(ligneCmdClient ->{
                        LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligneCmdClient);
                        ligneCommandeClient.setCommandeClient(saveCmdClient);
                        ligneCommandeClientRepository.save(ligneCommandeClient);
                    }

            );
        }

        return CommandeClientDto.fromEntity((saveCmdClient));
    }


    @Override
    public  void delete(Integer id){
        if(id == null){
            log.error("Commande client ID is null");
            return;
        }
        commandeClientRepository.deleteAllById(Collections.singleton(id));
    }
}
