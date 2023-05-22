package fr.ul.miage.projetGL2023;

import fr.ul.miage.projetGL2023.algorithme.Algorithme;
import fr.ul.miage.projetGL2023.model.Metro;
import fr.ul.miage.projetGL2023.model.Station;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Création des instances
        Metro metro = new Metro();
        Algorithme algo = new Algorithme();

        //A changer en fonction de la géolocalisation
        Station depart = metro.getStations().get(4);

        System.out.println(depart);
        //metro.getStations().get(1).setProbleme(true);
        Station arrivee = metro.getStations().get(6);
        System.out.println(arrivee);

        //Appel de la fonction
        List<Integer> stationList = algo.algoMoinsChangement(depart, arrivee,metro);
       /* if(stationList != null)
        {
            stationList.forEach(System.out::println);
        }
        else
        {
            System.out.println("Il y a pas de chemin disponible actuellement !");
        }*/

    }
}