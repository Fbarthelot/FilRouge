package com.poec.profil;

import java.util.ArrayList;

public class Authentification extends Profil{

//    private String email;
    private String password;
    private ArrayList<String> listProfil = new ArrayList();

    public Authentification() {
        lectureFichierProfilTxt();
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

//    public void lectureFichier() {
//        String line ;
//
//                FileInputStream fis;
//                try {
//                    fis = new FileInputStream("./Profil.txt");
//                    Scanner scanner = new Scanner(fis);
//
//
//                    while (scanner.hasNextLine()) {
//
//
//                        while (scanner.hasNextLine()) {
//                            line = scanner.nextLine();
//
//                            if (line.isEmpty()) {
//                                break;
//                            }
//
//                            String[] splitLine = line.split(": ");
//                            listProfil.add(splitLine[1]);
////                            System.out.println(listProfil.toString());
//                        }
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//    }
}
