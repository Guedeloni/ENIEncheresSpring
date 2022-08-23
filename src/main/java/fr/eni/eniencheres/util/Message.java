package fr.eni.eniencheres.util;

public enum Message {
    VENDEUR_NON_AUTORISE("Opération non autorisée pour le vendeur");

    private String msg;
    Message(String msg) {
        this.msg = msg;
    }

    public String showMsg() { return msg; }

}
