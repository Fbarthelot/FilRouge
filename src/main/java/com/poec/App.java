package com.poec;


import com.poec.profil.Authentification;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        boolean resultBonjour = true;
        while (resultBonjour){
            System.out.println("Bonjour possedez vous un compte ? oui/non");
            Scanner scanner = new Scanner(System.in);
            String result = scanner.next();

            if (result.equals("oui")) {
                connexion(scanner);
                resultBonjour=false;
            } else if (result.equals("non")) {
                newProfil();
                resultBonjour=false;
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

    private static void newProfil() {
        System.out.println("newprofil");
    }

    private static void connexion(Scanner scan) {
        boolean verif = false;
        boolean connexionOk=false;
        while (connexionOk == false){

            Authentification auth = new Authentification();
            System.out.println("quel est votre email ?");
            String email = scan.next();
            System.out.println("quel ets votre password ?");
            String pswd = scan.next();
            verif = auth.setAuthentification(email, pswd);
            if (verif) {
                System.out.println("Bonjour");
                connexionOk=true;
            } else {
                System.out.println("je ne vous reconnais pas ");
            }
        }

    }
}
