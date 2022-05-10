package com.momo.gestiondestock.controller;

import com.momo.gestiondestock.controller.api.CommandeClientApi;
import com.momo.gestiondestock.dto.CommandeClientDto;
import com.momo.gestiondestock.service.CommandeClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class CommandeClientController implements CommandeClientApi {

    private CommandeClientService commandeClientService;


    @Override
    public CommandeClientDto save(CommandeClientDto dto){return commandeClientService.save(dto);};

    @Override
    public CommandeClientDto findById(Integer id){
        return commandeClientService.findById(id);
    };

    @Override
    public CommandeClientDto findByCode(String code) {
        return commandeClientService.findByCode(code);
    }

    @Override
    public List<CommandeClientDto> findAll() {return commandeClientService.findAll();}


    @Override
    public void put(CommandeClientDto dto, Integer id){
        commandeClientService.put(dto, id);
    };

    @Override
    public void delete(Integer id){
        commandeClientService.delete(id);
    };
}
