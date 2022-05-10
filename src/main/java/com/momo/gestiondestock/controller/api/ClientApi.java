package com.momo.gestiondestock.controller.api;

import com.momo.gestiondestock.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.momo.gestiondestock.utils.Constants.APP_ROOT;

public interface ClientApi {

    @PostMapping(value = APP_ROOT + "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(ClientDto dto);

    @GetMapping(value = APP_ROOT + "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(Integer id);

    @GetMapping(value = APP_ROOT + "/clients/{numtel}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findByNumTel(@PathVariable("numtel")  String numtel);

    @GetMapping(value = APP_ROOT + "/clients/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findByEmail(@PathVariable("email") String email);

    @GetMapping(value = APP_ROOT + "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    @PutMapping(value = APP_ROOT + "/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto put(ClientDto dto, Integer id);

    @DeleteMapping(value = APP_ROOT + "/clients/delete/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idClient") Integer id);
}
