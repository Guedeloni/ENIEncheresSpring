package fr.eni.eniencheres.util;

public enum Message {
    VENDEUR_NON_AUTORISE("Opération non autorisée pour le vendeur"),
    PB_CREATION_ARTICLE("Problème lors de la création de l'article"),
    ENCHERE_NON_DEBUTEE("L'enchère n'a pas encore débutée"),
    ENCHERE_TERMINEE("L'enchère est terminée"),
    MONTANT_ENCHERE_INSUFFISANT("Enchérissement inférieur ou égal au dernier montant");

    private String msg;
    Message(String msg) {
        this.msg = msg;
    }

    public String showMsg() { return msg; }

}
