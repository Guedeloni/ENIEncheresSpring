package fr.eni.eniencheres.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor

public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long noArticle;

    @NotBlank
    private String nomArticle;

    private String description;

    private LocalDate dateDebutEncheres;

    @Future
    private LocalDate dateFinEncheres;

    @Min(1)
    private int prixInitial;

    private int prixvente;

    // 1 = Creee ; 2 = En cours ; 3 = Terminee ; 4 = Retrait effectue
    @Size(min=1, max=4)
    private byte etatVente;

    private String imageURL;

    @ManyToOne
    @JsonBackReference
    private Utilisateur acheteur;

    @ManyToOne
    @JsonBackReference
    private Utilisateur vendeur;

    @OneToMany
    @JoinColumn(name = "article_id")
    @JsonManagedReference
    private List<Enchere> enchereList;

    @ManyToOne
    private Retrait retrait;

    @ManyToOne
    private Categorie categorie;


    public Article(long noArticle, String nomArticle, String description,
                   LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
                   int prixInitial, int prixvente, byte etatVente, String imageURL,
                   Utilisateur acheteur, Utilisateur vendeur, List<Enchere> enchereList,
                   Retrait retrait, Categorie categorie) {
        this.noArticle = noArticle;
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.prixInitial = prixInitial;
        this.prixvente = prixvente;
        this.etatVente = etatVente;
        this.imageURL = imageURL;
        this.acheteur = acheteur;
        this.vendeur = vendeur;
        this.enchereList = enchereList;
        this.retrait = retrait;
        this.categorie = categorie;
    }

}
