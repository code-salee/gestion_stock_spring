package com.momo.gestiondestock.service;

import com.momo.gestiondestock.dto.CommandeClientDto;
import com.momo.gestiondestock.model.CommandeClient;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface CommandeClientService {

    CommandeClientDto save(CommandeClientDto dto);

    List<CommandeClientDto> findAll();

    CommandeClientDto findById(Integer id);

    Optional<CommandeClient> findByCodeAndIdNot(String code, Long id);

    Optional<CommandeClient> findByDateCommande(Instant dateCommande);

    CommandeClientDto findByCode(String code);

    CommandeClientDto put(CommandeClientDto dto, Integer id);

     void delete(Integer id);
}