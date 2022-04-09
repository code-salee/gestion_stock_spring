package com.momo.gestiondestock.dto;


import com.momo.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder

public class VentesDto {

    private Integer id;

    private String code;

    private Instant dateVente;

    private String commentaire;

    public static VentesDto fromEntity(Ventes ventes) {
        if (ventes == null) {
            return null;
        }

        return VentesDto.builder()
                .id(ventes.getId())
                .code(ventes.getCode())
                .dateVente(ventes.getDateVente())
                .commentaire(ventes.getCommentaire())
                .build();
    }

    public Ventes toEntity(VentesDto ventesDto) {
        if(ventesDto == null) {
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(ventesDto.getId());
        ventes.setCode(ventesDto.getCode());
        ventes.setDateVente(getDateVente());
        ventes.setCommentaire((ventesDto.getCommentaire()));
        return ventes;
    }
}
