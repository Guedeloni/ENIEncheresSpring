package fr.eni.eniencheres.bo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int noCategorie;

    private String libelle;

    public Categorie(String libelle) {
        libelle = libelle;
    }


    @Override
    public boolean equals(Object categorie) {
        String libelle = ((Categorie) categorie).getLibelle();
        return this.libelle.equals(libelle) ;
    }
}
