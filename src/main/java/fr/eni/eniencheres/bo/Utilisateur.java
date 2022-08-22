package fr.eni.eniencheres.bo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String pseudo;

    @NotBlank
    @Column(nullable = false)
    private String nom;

    @NotBlank
    @Column(nullable = false)
    private String prenom;

    @Email
    @Column(nullable = false)
    private String email;

    private String telephone;
    private String rue;
    private String codePostal;
    private String ville;

    @NotBlank
    private String motDePasse;

    @CreditCardNumber
    long credit;

    private boolean admin;

    @OneToMany
    @JoinColumn(name = "utilisateur_id")
    @JsonManagedReference
    private List<Enchere> enchereList;

    @OneToMany
    @JoinColumn(name = "acheteur_id")
    @JsonManagedReference
    private  List <Article> articleAcheteList;

    @OneToMany
    @JoinColumn(name = "vendeur_id")
    @JsonManagedReference
    private  List <Article> articleVenduList;


    @Override
    public boolean equals(Object utilisateur) {
        String pseudo = ((Utilisateur) utilisateur).getPseudo();
        return this.pseudo.equals(pseudo);
    }

    public Utilisateur(String pseudo, String nom, String prenom, String email,
                       String telephone, String rue, String codePostal, String ville,
                       String motDePasse, long credit, boolean admin,
                       List<Enchere> enchereList, List<Article> articleAcheteList, List<Article> articleVenduList) {
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.motDePasse = motDePasse;
        this.credit = credit;
        this.admin = admin;
        this.enchereList = enchereList;
        this.articleAcheteList = articleAcheteList;
        this.articleVenduList = articleVenduList;

    }
}
