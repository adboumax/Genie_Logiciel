package fr.ul.miage.projetGL2023;

import fr.ul.miage.projetGL2023.algorithme.Algorithme;
import fr.ul.miage.projetGL2023.model.Metro;
import fr.ul.miage.projetGL2023.model.Station;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Création des instances
        Metro metro = new Metro();
        Algorithme algo = new Algorithme();




        int choix = 0;
        Station depart;
        Station arrivee;


        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Bienvenue sur l'application metro ! ===");
        System.out.println("Choisissez la fonctionnalité souhaitée, en écrivant le chiffre correspondant\n");
        do {
            System.out.println("1 - Itinéraire le plus rapide");
            System.out.println("2 - Itinéraire avec le moins de changement de ligne");
            System.out.println("3 - Itinéraire passant par des points donnés");
            System.out.println("4 - Signaler un problème");
            System.out.println("5 - Quitter");
            System.out.println("Faites votre choix :");

            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("Itinéraire le plus rapide\n");
                    System.out.println("Entrez la station de départ : ");
                    depart = metro.getStations().get(scanner.nextInt());
                    System.out.println("Entrez la station d'arrivée : ");
                    arrivee = metro.getStations().get(scanner.nextInt());

                    //Appel de la fonction
                    List<Integer> stationList = algo.algoCheminCourt(depart, arrivee, metro);
                    if(stationList != null)
                    {
                        System.out.println("Voici l'itinéraire le plus rapide : ");
                        stationList.forEach(System.out::println);
                    }
                    else
                    {
                        System.out.println("Il y a pas de chemin disponible actuellement !");
                    }
                    break;

                case 2:
                    System.out.println("Itinéraire avec le moins de changement de ligne");

                    break;

                case 3:
                    System.out.println("Itinéraire passant par des points donnés\n");
                    System.out.println("Entrez la station de départ : ");
                    depart = metro.getStations().get(scanner.nextInt());
                    System.out.println("Entrez la station d'arrivée : ");
                    arrivee = metro.getStations().get(scanner.nextInt());
                    System.out.println("Entrez les différents points de passage (0 pour arrêter) : ");
                    int nombre;
                    List<Integer> stations = new ArrayList<>();
                    do {
                        nombre = scanner.nextInt();
                        System.out.println("Station souhaitée : " + nombre);
                        if (nombre!=0){
                            stations.add(nombre);
                        }
                    } while (nombre != 0);
                    algo.algorithmeSelonPoint(depart,arrivee,stations,metro);
                    System.out.println(stations);
                    break;

                case 4:
                    System.out.println("Signaler un problème\n");
                    System.out.println("Veuillez entrer le numéro de station ayant un problème : ");
                    for(int i = 0; i < metro.getStations().size(); i++){
                        System.out.println("Numéro "+i+" : Station "+metro.getStations().get(i).getNom());
                    }
                    int valeur = scanner.nextInt();
                    metro.getStations().get(valeur).setProbleme(true);
                    System.out.println("La station "+metro.getStations().get(valeur).getNom()+", est donc fermée à partir de maintenant\n");
                    break;

                case 5:
                    System.out.println("Vous quittez le programme");
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 5);
    }
}