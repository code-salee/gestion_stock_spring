package com.momo.gestiondestock.dto;


import com.momo.gestiondestock.model.AbstractEntity;
import com.momo.gestiondestock.model.MvtStk;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder


public class MvtStkDto extends AbstractEntity {

    private Integer id;


    private Instant dateMvt;


    private String quantite;


    private String typeMvt;

    private ArticleDto article;

    public MvtStkDto fromEntity(MvtStk mvtStk){
        if(mvtStk == null){
            return null;
        }
        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .typeMvt(mvtStk.getTypeMvt())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .build();
    }

    public MvtStk toEntity (MvtStkDto mvtStkDto){
        if(mvtStkDto == null){
            return null;
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(mvtStkDto.getId());
        mvtStk.setDateMvt(mvtStkDto.getDateMvt());
        mvtStk.setQuantite(mvtStkDto.getQuantite());
        mvtStk.setTypeMvt(mvtStkDto.getTypeMvt());
        mvtStk.setArticle(ArticleDto.toEntity(mvtStkDto.getArticle()));
        return mvtStk;
    }
}
