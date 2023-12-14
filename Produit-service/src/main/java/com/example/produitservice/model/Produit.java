package com.example.produitservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double prix;
    private int quantiteStock;
    private String image_url;
    private Long categorieId; // ID de la catégorie associée
//    @ManyToOne
//    @JoinColumn(name = "categorie_id")
//    private Categorie categorie;
}
