package com.momo.gestiondestock.controller.api;

import com.momo.gestiondestock.dto.ClientDto;
import com.momo.gestiondestock.dto.CommandeClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.momo.gestiondestock.utils.Constants.APP_ROOT;

public interface CommandeClientApi {

    @PostMapping(value = APP_ROOT + "/commandeclients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto save(CommandeClientDto dto);

    @GetMapping(value = APP_ROOT + "/commandeclients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto findById(Integer id);

    @GetMapping(value = APP_ROOT + "/commandeclients/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto findByCode(@PathVariable("code") String code);

    @GetMapping(value = APP_ROOT + "/commandeclients", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CommandeClientDto> findAll();

    @PutMapping(value = APP_ROOT + "/commandeclients/{idCmdCli}", produces = MediaType.APPLICATION_JSON_VALUE)
    void put(CommandeClientDto dto, @PathVariable("idCmdCli") Integer id);

    @DeleteMapping(value = APP_ROOT + "/commandeclients/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(Integer id);
}
