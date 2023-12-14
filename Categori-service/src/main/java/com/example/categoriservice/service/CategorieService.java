package com.example.categoriservice.service;

import com.example.categoriservice.model.Categorie;
import com.example.categoriservice.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Optional<Categorie> getCategorieById(Long id) {
        return categorieRepository.findById(id);
    }

    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie updateCategorie(Long id, Categorie updatedCategorie) {
        Optional<Categorie> existingCategorieOptional = categorieRepository.findById(id);
        if (existingCategorieOptional.isPresent()) {
            updatedCategorie.setId(id);
            return categorieRepository.save(updatedCategorie);
        }
        return null; // Gérer le cas où la catégorie n'existe pas
    }

    public boolean deleteCategorie(Long id) {
        Optional<Categorie> existingCategorieOptional = categorieRepository.findById(id);
        if (existingCategorieOptional.isPresent()) {
            categorieRepository.deleteById(id);
            return true;
        }
        return false; // Gérer le cas où la catégorie n'existe pas
    }
}