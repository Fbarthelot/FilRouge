package com.poec;


import com.poec.profil.Authentification;
import com.poec.profil.Profil;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {

        boolean resultBonjour = true;
        while (resultBonjour) {
            System.out.println("Bonjour possedez vous un compte ? oui/non");
            Scanner scanner = new Scanner(System.in);
            String result = scanner.next();

            if (result.equals("oui")) {
                connexion(scanner);
                resultBonjour = false;
            } else if (result.equals("non")) {
                newProfil(scanner);
                resultBonjour = false;
            } else {
                System.out.println("Veuillez répondre par oui ou par non");
            }

        }
//
//        //verification du profil
//        boolean verif=false;
//        Authentification auth = new Authentification();
//        verif=auth.setAuthentification("maurice@Laposte.fr", "maurice");
//        System.out.println("verif authentification "+verif);

    }

    private static void newProfil(Scanner scan) {
        Profil profil = new Profil();
        System.out.println("Veuillez nous indiquer votre nom: ");
        String nom = scan.next();
        boolean mailOk = false;
        String email = "*";

        while (mailOk == false) {
            System.out.println("Veuillez nous indiquer un email: ");
            email = scan.next();
            // on verifie le format du mail
            Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher m = p.matcher(email);

            if (m.matches()) {

                if (profil.emailExist(email)==false) {
                    mailOk = true;
                }else{

                    System.out.println("ce mail correspond à un compte déjà existant \n");
                }
            }else{
                System.out.println("le format n'est pas bon veuillez recommencer \n");
            }
        }

        System.out.println("Veuillez nous indiquer un mot de passe: ");
        String password = scan.next();


        boolean save = profil.setProfil(nom, email, password);
        if (save == true) {
            System.out.println("Bienvenu vous avez bien été enregistré");
        } else {
            System.out.println("l'enregistrement à échoué");
        }

    }

    private static void connexion(Scanner scan) {
        boolean verif = false;
        boolean connexionOk = false;
        while (connexionOk == false) {

            Authentification auth = new Authentification();
            System.out.println("quel est votre email ?");
            String email = scan.next();
            System.out.println("quel est votre password ?");

            String pswd = scan.next();

            verif = auth.setAuthentification(email, pswd);
            if (verif) {
                System.out.println("Bonjour " + auth.getNom(email));
                connexionOk = true;
            } else {
                System.out.println("je ne vous reconnais pas ");
            }
        }

    }
}
