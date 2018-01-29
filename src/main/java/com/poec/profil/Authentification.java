package com.poec.profil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Authentification {

//    private String email;
    private String password;
    private ArrayList<String> listProfil = new ArrayList();

    public Authentification() {
        lectureFichier("/home/poec2/workspace/FilRouge");
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

    private void lectureFichier(String filePath) {
        String line ;
        File monRepertoire = new File(filePath);
        if (monRepertoire.exists()) {

            if (monRepertoire.isDirectory()) {
//                System.out.println("le fichier est un répertoire");
            } else {
                System.err.println("le fichier n'est pas un répertoire");
            }

            if (monRepertoire.canRead()) {

                File monFichier = new File(monRepertoire, "Profil.txt");

                FileInputStream fis;
                try {
                    fis = new FileInputStream(monFichier);
                    Scanner scanner = new Scanner((fis));


                    while (scanner.hasNextLine()) {


                        while (scanner.hasNextLine()) {
                            line = scanner.nextLine();

                            if (line.isEmpty()) {
                                break;
                            }

                            String[] splitLine = line.split(": ");
                            listProfil.add(splitLine[1]);
//                            System.out.println(listProfil.toString());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                System.err.println("Je ne peux pas lire le fichier");
            }

        } else {
            System.err.println("le fichier n'existe pas");
        }
    }
}
