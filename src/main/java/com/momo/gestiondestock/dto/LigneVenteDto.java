package com.momo.gestiondestock.dto;


import com.momo.gestiondestock.model.AbstractEntity;
import com.momo.gestiondestock.model.LigneVente;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder


public class LigneVenteDto extends AbstractEntity {

    private Integer id;


    private VentesDto vente;


    private BigDecimal quantite;

    public LigneVenteDto fromEntity(LigneVente ligneVente){
        if(ligneVente == null){
            return null;
        }

        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .quantite(ligneVente.getQuantite())
                .vente(VentesDto.fromEntity(ligneVente.getVente()))
                .build();
    }

    public LigneVente toEntity (LigneVenteDto ligneVenteDto){
        if(ligneVenteDto == null){
            return null;
        }

        LigneVente lignevente = new LigneVente();
        lignevente.setId(ligneVenteDto.getId());
        lignevente.setQuantite(ligneVenteDto.getQuantite());
        lignevente.setVente(VentesDto.toEntity(ligneVenteDto.getVente()));
        return lignevente;
    }
}
