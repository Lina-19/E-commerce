package com.example.produitservice.service;

import com.example.produitservice.model.Produit;
import com.example.produitservice.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit updateProduit(Long id, Produit updatedProduit) {
        Optional<Produit> existingProduitOptional = produitRepository.findById(id);
        if (existingProduitOptional.isPresent()) {
            updatedProduit.setId(id);
            return produitRepository.save(updatedProduit);
        }
        return null; // Gérer le cas où le produit n'existe pas
    }

    public boolean deleteProduit(Long id) {
        Optional<Produit> existingProduitOptional = produitRepository.findById(id);
        if (existingProduitOptional.isPresent()) {
            produitRepository.deleteById(id);
            return true;
        }
        return false; // Gérer le cas où le produit n'existe pas
    }
}
