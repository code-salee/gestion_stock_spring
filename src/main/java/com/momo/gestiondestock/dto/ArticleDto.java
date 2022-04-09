package com.momo.gestiondestock.dto;

import com.momo.gestiondestock.model.Article;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ArticleDto {

    private Integer id;

    private String codearticle;


    private String designation;


    private String prixunitaireht;


    private String tauxtva;


    private String prixunitairettc;


    private String photo;


    private CategoryDto category;

    public static ArticleDto fromEntity(Article article){
        if(article == null){
            return null;
        }

        return ArticleDto.builder()
                .id(article.getId())
                .codearticle(article.getCodearticle())
                .designation(article.getDesignation())
                .prixunitaireht(article.getPrixunitaireht())
                .tauxtva(article.getTauxtva())
                .prixunitairettc(article.getPrixunitairettc())
                .photo(article.getPhoto())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .build();
    }

    public static Article toEntity(ArticleDto articleDto){
        if(articleDto == null){
            return null;
        }

        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodearticle(articleDto.getCodearticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixunitaireht(articleDto.getPrixunitaireht());
        article.setTauxtva(articleDto.getTauxtva());
        article.setPrixunitairettc(articleDto.getPrixunitairettc());
        article.setPhoto(articleDto.getPhoto());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));

        return article;
    }
}
