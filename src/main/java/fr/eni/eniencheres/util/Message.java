package fr.eni.eniencheres.util;

public enum Message {
    VENDEUR_NON_AUTORISE("Opération non autorisée pour le vendeur"),
    PB_CREATION_ARTICLE("Problème lors de la création de l'article"),
    MONTANT_ENCHERE_INSUFFISANT("Enchérissement inférieur ou égal au dernier montant");

    private String msg;
    Message(String msg) {
        this.msg = msg;
    }

    public String showMsg() { return msg; }

}
