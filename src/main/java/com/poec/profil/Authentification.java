package com.poec.profil;

import java.util.ArrayList;

public class Authentification extends Profil {

    //    private String email;
    private String password;
    private ArrayList<String> listProfil = new ArrayList();

    public Authentification() {
        listProfil = lectureFichierProfilTxt();
    }

    public Boolean setAuthentification(String mail, String pswd) {
        boolean result = false;
        //TODO: remplacer par un appel à une base de donnée
        if (listProfil.contains(mail)) {
            int indexName = listProfil.indexOf(mail);
            // on ajoute 1 à l'index pour récupérer le password qui ce trouve à la ligne suivante
            password = listProfil.get(indexName + 1);
//            System.out.println("password :" + password);
            result = password.equals(pswd);

        } else {
            System.out.println("ce mail n'est pas valide");
        }

        return result;
    }


}
