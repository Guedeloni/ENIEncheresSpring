package fr.eni.eniencheres.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
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

    private String avatar; // image

    @OneToMany
    @JoinColumn(name = "utilisateur_id")
    @JsonIgnore
    private List<Enchere> enchereList;

    /*

      //  @OneToMany
    @JoinColumn(name = "acheteur_id")
   @JsonManagedReference
    private  List <Article> articleAcheteList;

  @OneToMany
    @JoinColumn(name = "vendeur_id")
     @JsonBackReference
    private  List <Article> articleVenduList;
*/

    @Override
    public boolean equals(Object utilisateur) {
        String pseudo = ((Utilisateur) utilisateur).getPseudo();
        return this.pseudo.equals(pseudo);
    }

    public Utilisateur(long id, String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse, long credit, boolean admin, String avatar) {
        this.id = id;
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
        this.avatar = avatar;
    }
}
