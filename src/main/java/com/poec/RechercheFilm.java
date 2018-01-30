package com.poec;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RechercheFilm {

    //Attributs
    private String nomFilm;

    // Constructeur
    public RechercheFilm() {

    }


    //Methodes
    public boolean getFilm(String film) {
        boolean resultat = false;
//Comparer une chaine de caractere d'entree avec une liste provenant du fichier Film.txt

        // Spécifier le chemin (File) du fichier Film.txt
        String line = "";

        //Lecture du fichier Film.txt
        Scanner sc = null;
        ArrayList<String> list = new ArrayList();// on crée l'ArrayList à l'extérieur de la boucle while afin de ne pas la recrée à chaque utilisation
        try {
            sc = new Scanner(new File("./Film.txt"));

            while (sc.hasNextLine()) {

                line = sc.nextLine();
//                System.out.println("line " + line);
                // remplire la list film avec la lecture du fichier

                list.add(line);
//                System.out.println("list " + list);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //Comparer les chaines de caracteres saisie avec celles existatnt dans la liste film

       resultat= list.contains(film);

        //Retourner le résultat
        return resultat;

        //Comparer le inputStream et le outputStream
    }
}