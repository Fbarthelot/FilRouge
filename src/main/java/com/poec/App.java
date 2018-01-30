package com.poec;

public class App {
    public static void main(String[] args) {
        //afficher le résultat de la methode getFilm de la class RechercheFilm

        // on crée l'objet RechercheFilm

        RechercheFilm rFilm = new RechercheFilm();
        // on appel la méthode getFilm et on attribut le résultat
        Boolean filmExiste = new Boolean(false);


        filmExiste = rFilm.getFilm("shining");

        //on affiche le résultat

        System.out.println(filmExiste);
    }


}

