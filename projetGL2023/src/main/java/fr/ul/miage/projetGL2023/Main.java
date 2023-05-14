package fr.ul.miage.projetGL2023;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Création des instances
        Metro metro = new Metro();
        Algorithme algo = new Algorithme();

        //A changer en fonction de la géolocalisation
        Station depart = metro.getStations().get(0);
        Station arrivee = metro.getStations().get(12);

        //Appel de la fonction
        List<Station> stationList = algo.algoCheminCourt(depart, arrivee);
        stationList.forEach(System.out::println);

    }
}