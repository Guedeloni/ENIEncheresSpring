package fr.eni.eniencheres.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int noArticle;

    private String nomArticle;

    private String description;

    private LocalDate dateDebutEncheres;

    private LocalDate dateFinEncheres;

    private int prixInitial;

    private int prixvente;

    private int etatVente;

    @ManyToOne
    @JsonBackReference
    private Utilisateur pseudo;

    @ManyToOne
      private Enchere enchere;

    @ManyToOne  private Retrait retrait;

    @ManyToOne private Categorie libelle;


    public Article(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, int prixInitial, int prixvente, int etatVente, Utilisateur pseudo, Enchere enchere, Retrait retrait, Categorie libelle) {
        this.noArticle = noArticle;
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.prixInitial = prixInitial;
        this.prixvente = prixvente;
        this.etatVente = etatVente;
        this.pseudo = pseudo;
        this.enchere = enchere;
        this.retrait = retrait;
        this.libelle = libelle;
    }


}
