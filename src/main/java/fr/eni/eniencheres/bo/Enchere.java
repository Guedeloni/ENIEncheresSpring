package fr.eni.eniencheres.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Enchere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate dateEnchere = LocalDate.now();

    private int montantEnchere;

    @ManyToOne
    @JoinColumn(name = "article_id")
    @JsonBackReference
    private Article article;

    @ManyToOne
    @JsonBackReference
    private Utilisateur utilisateur;

    public Enchere(long id, LocalDate dateEnchere, int montantEnchere, Article article, Utilisateur utilisateur) {
        this.id = id;
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
        this.article = article;
        this.utilisateur = utilisateur;
    }
}
