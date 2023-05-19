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
        Station depart = metro.getStations().get(0);
        Station arrivee = metro.getStations().get(6);

        //Appel de la fonction
        List<Integer> stationList = algo.algorithmeSelonPoint(depart, arrivee, List.of(metro.getStations().get(0).getNum_station()));
        stationList.forEach(System.out::println);

    }
}