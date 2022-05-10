package com.momo.gestiondestock.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="category")
public class Category extends AbstractEntity{


    @Column(name = "code", unique=true, nullable = false)
    private String code;


    @Column(name = "designation", nullable = false)
    private String designation;


    @OneToMany(mappedBy = "category")
    private List<Article> articles;

    public Category(String code, String designation) {

        this.code = code;
        this.designation = designation;
    }
}
