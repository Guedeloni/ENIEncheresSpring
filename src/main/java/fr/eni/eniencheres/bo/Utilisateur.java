package fr.eni.eniencheres.bo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Utilisateur {

    @Id

    @Column(nullable = false)
    private String pseudo;


    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String email;

    private long telephone;
    private String rue;
    private String codePostal;
    private String ville;
    private String motDePasse;
    private long credit;
    private boolean admin;

    @OneToMany

    private List<Enchere> enchere;

    @OneToMany
    @JsonManagedReference
    private  List <Article> article;


    @Override
    public boolean equals(Object utilisateur) {
        String pseudo = ((Utilisateur) utilisateur).getPseudo();
        return this.pseudo.equals(pseudo);
    }

    public Utilisateur(String pseudo, String nom, String prenom, String email, long telephone, String rue, String codePostal, String ville, String motDePasse, long credit) {
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
    }
}
