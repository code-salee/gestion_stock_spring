package com.momo.gestiondestock.service;


import com.momo.gestiondestock.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto dto);
    ClientDto findById(Integer id);

    ClientDto findByNumTel(String numtel);

    ClientDto findByEmail(String email);

    List<ClientDto> findAll();

    ClientDto put(ClientDto dto, Integer id);

    void delete(Integer id);
}
