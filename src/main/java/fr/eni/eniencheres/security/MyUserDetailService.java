package fr.eni.eniencheres.security;


import fr.eni.eniencheres.bo.Utilisateur;
import fr.eni.eniencheres.service.UtilisateurService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * En créant une classe qui implémente l'interface de Spring Security : UserDetailsService
 * , Spring Security va comprendre que c'est à partir de cette classe (via sa méthode loadUserByUsername())
 * qu'il doit aller chercher les utilisateurs de l'application
 *
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    private UtilisateurService utilisateurService;

    /**
     * Au démarrage de l'application, je crée un utilisateur "admin"
     * Sinon, pas moyen de se connecter une première fois pour créer les utilisateurs :(
     */
    public MyUserDetailService(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;

        try {
            utilisateurService.addUtilisateur(
                    new Utilisateur(1, "admin","admin","thomas" ,"admin@admin.com", "0611111111", "rue dfees admins", "78554", "Nantes", "admin",450, true, ""));
        } catch (Exception e) {
            System.out.println("Utilisateur admin déjà existant");
        }
    }

    /**
     * loadUserByUsername(String username)
     * => explique à Spring comment on lui retourne un utilisateur à partir d'un username utilisé dans la page de login
     */
    @Override
    public UserDetails loadUserByUsername(String pseudo) {

        // 1. Je recupère le membre qui correspond au username
        Utilisateur utilisateur = utilisateurService.getUtilisateurByPseudo(pseudo);

        // Si jamais le membre est null, je lance une exception
        if (utilisateur == null) {
            throw new UsernameNotFoundException(pseudo);
        }

        return new User(utilisateur);
    }
}