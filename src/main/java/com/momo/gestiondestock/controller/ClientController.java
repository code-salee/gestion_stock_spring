package com.momo.gestiondestock.controller;

import com.momo.gestiondestock.controller.api.ClientApi;
import com.momo.gestiondestock.dto.ClientDto;
import com.momo.gestiondestock.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class ClientController implements ClientApi {

    private ClientService clientService;


    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public ClientDto findByNumTel(String numtel) {return clientService.findByNumTel(numtel);}

    @Override
    public ClientDto findByEmail(String email) {return clientService.findByEmail(email);}

    @Override
    public List<ClientDto> findAll() {return clientService.findAll();}

    @Override
    public ClientDto put(ClientDto dto, Integer id) {
        return clientService.put(dto, id);
    }
    @Override
    public void delete(Integer id) {
        clientService.delete(id);}
}
