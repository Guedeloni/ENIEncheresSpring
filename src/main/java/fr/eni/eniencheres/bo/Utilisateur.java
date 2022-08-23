package fr.eni.eniencheres.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@AllArgsConstructor
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

    @Column(nullable = false)
    private String telephone;
    @Column(nullable = false)
    private String rue;
    @Column(nullable = false)
    private String codePostal;
    @Column(nullable = false)
    private String ville;

    @NotBlank
    @Column(nullable = false)
    private String motDePasse;

    private long credit;

    private boolean admin;

    @OneToMany
    @JoinColumn(name = "utilisateur_id")
    @JsonIgnore
    private List<Enchere> enchereList;

    @OneToMany
    @JoinColumn(name = "acheteur_id")
//    @JsonManagedReference
    private  List <Article> articleAcheteList;

    @OneToMany
    @JoinColumn(name = "vendeur_id")
//    @JsonManagedReference
    private  List <Article> articleVenduList;

    @Override
    public boolean equals(Object utilisateur) {
        String pseudo = ((Utilisateur) utilisateur).getPseudo();
        return this.pseudo.equals(pseudo);
    }



}
