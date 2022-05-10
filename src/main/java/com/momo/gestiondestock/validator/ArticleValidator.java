package com.momo.gestiondestock.validator;


import com.momo.gestiondestock.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> Articlevalidate(ArticleDto articleDto) {
        return getValidate(articleDto == null, articleDto.getCodearticle(), articleDto.getDesignation(),articleDto.getPrixunitaireht(),articleDto.getTauxtva(),
                articleDto.getPrixunitairettc(), articleDto.getPhoto(), articleDto.getCategory() == null);
    }

    private static List<String> getValidate(boolean article, String codearticle, String designation, String prixunitaireht, String tauxtva, String prixunitairettc, String photo, boolean category) {
        List<String> errors = new ArrayList<>();
        if (article){
            errors.add("Veuillez renseigner le code article");
            errors.add("Veuillez renseigner la designation");
            errors.add("Veuillez renseigner le prix unitaire ht");;
            errors.add("Veuillez renseigner le taux tva");
            errors.add("Veuillez renseigner le prix unitaire ttc");
            errors.add("Veuillez renseigner la photo");
           // errors.add("Veuillez renseigner le cateegory");
            return errors;
        }
        if(!StringUtils.hasLength(codearticle)){
            errors.add("Veuillez renseigner le code de l'article");
        }
        if(!StringUtils.hasLength(designation)){
            errors.add("Veuillez renseigner la designation de l'article");
        }
        if(!StringUtils.hasLength(prixunitaireht)){
            errors.add("Veuillez renseigner le prix unitaire ht de l'article");
        }
        if(!StringUtils.hasLength(tauxtva)){
            errors.add("Veuillez renseigner le taux tva de l'article");
        }
        if(!StringUtils.hasLength(prixunitairettc)){
            errors.add("Veuillez renseigner le prix unitaire ttc l'article");
        }
        if(!StringUtils.hasLength(photo)){
            errors.add("Veuillez renseigner le photo de l'article");
        }
        /*if(category){
            errors.add("Veuillez renseigner le catégorie de l'article");
        }*/
        return errors;
    }
}
