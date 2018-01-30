package com.poec.profil;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Profil {

    private ArrayList<String> listProfil = new ArrayList();
    private String nom;
    private String email;
    private String password;

    public Profil() {
        lectureFichierProfilTxt();
    }

    /**
     * le fichier Profil contien les profil sous la frome
     * nom: ***
     * email: ***
     * password: ***
     *
     * @return une ArrayList des élémént du fichier Profil.txt
     */
    public ArrayList<String> lectureFichierProfilTxt() {
        String line;

        FileInputStream fis;
        try {
            fis = new FileInputStream("./Profil.txt");
            Scanner scanner = new Scanner(fis);

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
            //si le fichier n'exsiste pas on en crée un nouveau
            createProfilTxt();
        }
        return listProfil;
    }

    private void createProfilTxt() {
        File file = new File("./Profil.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Boolean setProfil(String nom, String email, String password) {
        //todo: on enregistre dans le fichier Profil.txt


        boolean save=false;
        FileOutputStream fos;
        String concat;
        try {
            fos = new FileOutputStream("./Profil.txt", true);
            concat = "nom: "+nom+"\n";
            fos.write(concat.getBytes());
            concat = "email: " + email+"\n";
            fos.write(concat.getBytes());
            concat = "pasword: " + password+"\n";
            fos.write(concat.getBytes());
            fos.write("\n".getBytes());
            fos.close();
            // on l'ajoute à la liste de profil en cour
            listProfil.add(nom);
            listProfil.add(email);
            listProfil.add(password);
            save=true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return save;
    }

    public String getNom(String email) {
        String nom = "";
        int indexMail = listProfil.indexOf(email);
        nom = listProfil.get(indexMail - 1);
        return nom;
    }

    public boolean emailExist(String mail){
        return listProfil.contains(mail);
    }
}
