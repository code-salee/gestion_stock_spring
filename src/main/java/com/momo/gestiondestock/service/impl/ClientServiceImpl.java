package com.momo.gestiondestock.service.impl;

import com.momo.gestiondestock.dto.ClientDto;
import com.momo.gestiondestock.exception.EntityNotFoundException;
import com.momo.gestiondestock.exception.ErrorCodes;
import com.momo.gestiondestock.exception.InvalidEntityException;
import com.momo.gestiondestock.model.Client;
import com.momo.gestiondestock.repository.ClientRepository;
import com.momo.gestiondestock.service.ClientService;
import com.momo.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }


    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.clientValidate(dto);
        if(!errors.isEmpty()){
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        return ClientDto.fromEntity(
                clientRepository.save(
                        ClientDto.toEntity(dto)
                )
        );
    }

    @Override
    public ClientDto findById(Integer id) {
        if(id == null){
            log.error("Client ID is null");
            return null;
        }
        Optional<Client> client = clientRepository.findById(id);
        ClientDto dto = ClientDto.fromEntity(client.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un client avec cet: " + id + " n'existe pas",
                        ErrorCodes.CLIENT_NOT_FOUND
                )
        );
    }

    @Override
    public ClientDto findByNumTel(String numtel) {

        if (!StringUtils.hasLength(numtel)){
            log.error("Numero telephone client is not valid");
            return null;
        }
        Optional<Client> client = clientRepository.findByNumTel(numtel);
        ClientDto dto = ClientDto.fromEntity(client.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un client avec ce numero telephone : " + numtel + " n'existe pas",
                        ErrorCodes.CLIENT_NOT_FOUND
                )
        );
    }

    @Override
    public ClientDto findByEmail(String email) {

        if (!StringUtils.hasLength(email)){
            log.error("Email du client is not valid");
            return null;
        }
        Optional<Client> client = clientRepository.findByEmail(email);
        ClientDto dto = ClientDto.fromEntity(client.get());

        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Un client avec cet email : " + email + " n'existe pas",
                        ErrorCodes.CLIENT_NOT_FOUND
                )
        );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto put(ClientDto dto, Integer id) {
        List<String> Errors = ClientValidator.clientValidate(dto);
        if(!Errors.isEmpty()){
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, Errors);
        }
        return ClientDto.fromEntity(
                clientRepository.save(
                        ClientDto.toEntity(dto)
                )
        );
    }


    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Article ID is null");
            return;
        }
        clientRepository.deleteById(id);
    }
}
