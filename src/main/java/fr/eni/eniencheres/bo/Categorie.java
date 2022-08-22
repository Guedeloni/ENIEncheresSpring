package fr.eni.eniencheres.bo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long noCategorie;

    private String libelle;

    public Categorie(long noCategorie, String libelle) {
        this.noCategorie = noCategorie;
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object categorie) {
        String libelle = ((Categorie) categorie).getLibelle();
        return this.libelle.equals(libelle) ;
    }
}
