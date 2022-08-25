package fr.eni.eniencheres.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
    @Min(1) @Max(4)
    private int etatVente;

    private String imageURL;

//    @ManyToOne
//    @JsonIgnore
//    private Utilisateur acheteur;
//
//    @ManyToOne
//    @JsonIgnore
//    private Utilisateur vendeur;

    @OneToMany
    @JoinColumn(name = "article_id")
    @JsonIgnore
    private List<Enchere> enchereList;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Retrait retrait;

    @ManyToOne
    private Categorie categorie;

}
