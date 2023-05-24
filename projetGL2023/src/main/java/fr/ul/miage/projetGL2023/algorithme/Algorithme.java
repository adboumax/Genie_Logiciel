package fr.ul.miage.projetGL2023.algorithme;

import fr.ul.miage.projetGL2023.model.Liaison;
import fr.ul.miage.projetGL2023.model.Metro;
import fr.ul.miage.projetGL2023.model.Station;

import java.util.*;
import java.util.stream.Collectors;

public class Algorithme {


    static Boolean sensAfter=true;

    public static List<Integer> algoCheminCourt(Station depart, Station arrivee, Metro metro) {

        if (depart == null || arrivee == null || depart.getNum_station() == arrivee.getNum_station()) {
            throw new IllegalArgumentException("La station est vide");
        }

        //Stockage des stations à explorer
        PriorityQueue<Station> exploration = new PriorityQueue<>();
        Set<Station> dejaExplore = new HashSet<>();

        Map<Station, Station> provientDe = new HashMap<>();

        //Stock le coût du départ à mtn
        Map<Station, Double> coutChemin = new HashMap<>();
        coutChemin.put(depart, 0.0);

        //Initialisation du noeud de départ
        depart.setF(heuristicAlgoLePlusCourt(depart, arrivee));
        exploration.add(depart);


        //Méthode permettant de stocker les valeurs des voisins ainsi qu'une comparaison de coût (algo a*)
        while (!exploration.isEmpty()) {
            Station actuelle = exploration.poll();
            //Si la station actuelle est la station d'arrivée, on affiche le chemin
            if (actuelle.getNum_station() == arrivee.getNum_station()) {
                return refaireChemin(provientDe, actuelle);
            }
            dejaExplore.add(actuelle);
            List<Liaison> liaisonsAutours = metro.stations.stream().filter(x -> x.liaison_after != null && x.liaison_after.getNum_station() == actuelle.getNum_station()
                            && !x.isProbleme() && !actuelle.getLiaison_before().isProbleme())
                    .map(x -> actuelle.getLiaison_before())
                    .collect(Collectors.toList());

            liaisonsAutours.addAll(metro.stations.stream().filter(x -> x.liaison_before != null && x.liaison_before.getNum_station() == actuelle.getNum_station()
                            && !x.isProbleme() && !actuelle.getLiaison_after().isProbleme())
                    .map(x -> actuelle.getLiaison_after())
                    .collect(Collectors.toList()));

            liaisonsAutours.addAll(metro.stations.stream().filter(x -> x.getNum_station() == actuelle.getNum_station()
                            && x.getLigne() != actuelle.getLigne()
                            && !x.isProbleme()
                            && x.liaison_after != null)
                    .map(x -> x.getLiaison_before())
                    .collect(Collectors.toList()));

            liaisonsAutours.addAll(metro.stations.stream().filter(x -> x.getNum_station() == actuelle.getNum_station()
                            && x.getLigne() != actuelle.getLigne()
                            && !x.isProbleme()
                            && x.liaison_before != null)
                    .map(x -> x.getLiaison_after())
                    .collect(Collectors.toList()));


            for (Liaison lien : liaisonsAutours) {
                Station voisine = getStationSelonNum(metro.getStations(), lien.getNum_station()).get(0);
                if (dejaExplore.contains(voisine)) {
                    continue;
                }
                double tentativeCout = coutChemin.get(actuelle) + lien.getTemps();
                if (!exploration.contains(voisine) || tentativeCout < coutChemin.get(voisine)) {
                    provientDe.put(voisine, actuelle);
                    coutChemin.put(voisine, tentativeCout);
                    voisine.setF(tentativeCout + heuristicAlgoLePlusCourt(voisine, arrivee));
                    if (!exploration.contains(voisine)) {
                        exploration.add(voisine);
                    }
                }
            }
        }
        return null;
    }

    public static List<Integer> refaireChemin(Map<Station, Station> provientDe, Station actuelle) {
        List<Integer> chemin = new ArrayList<>();
        //On ajoute à la liste du chemin la station actuelle (permettra de retracer)
        chemin.add(actuelle.getNum_station());
        //Permet de reconstruire le chemin le plus court
        while (provientDe.containsKey(actuelle)) {
            actuelle = provientDe.get(actuelle);
            chemin.add(actuelle.getNum_station());
        }
        //On inverse l'ordre de chemin
        Collections.reverse(chemin);
        return chemin;
    }

    //Méthode heuristic de l'algorithme le plus court
    public static double heuristicAlgoLePlusCourt(Station depart, Station arrivee) {
        double dx = depart.getLigne() - arrivee.getLigne();
        double dy = depart.getNum_station() - arrivee.getNum_station();
        return Math.sqrt(dx * dx + dy * dy);
    }



    public static List<Station> getStationSelonNum(List<Station> list, int num)
    {
        return list.stream().filter(x -> x.getNum_station() == num)
                .collect(Collectors.toList());
    }

    public List<Integer> algorithmeSelonPoint(Station depart, Station arrivee, List<Integer> pointPassage, Metro metro) {
        Station current = depart;
        ArrayList<Integer> resultat = new ArrayList<Integer>();

        if (depart == null || arrivee == null || depart.getNum_station() == arrivee.getNum_station()) {
            throw new IllegalArgumentException("La station est vide");
        }

        for (Integer i :pointPassage) {
            List<Integer> currentPath = algoCheminCourt(current, getStationSelonNum(metro.getStations(), i).get(0), metro);
            if(currentPath != null)
            {

                resultat.addAll(currentPath);
                current = metro.getStations().get(i);
            } else {
                break;
            }

        }

        List<Integer> currentPath = algoCheminCourt(current, arrivee, metro);
        if (currentPath != null) {
            resultat.addAll(currentPath);
        }

        return resultat;
    }



    public static List<Integer> algoMoinsChangement(Station depart, Station arrivee,Metro metro){
        //cas où les station sont sur la même ligne
        sensAfter=true;
        if (depart == null || arrivee == null || depart.getNum_station() == arrivee.getNum_station()) {
            throw new IllegalArgumentException("La station est vide");
        }
        List<Integer> chemin = new ArrayList<>();
        if(depart.isProbleme()|| arrivee.isProbleme()){
            return null;
        }



            int i = depart.getNum_station();


            chemin.add(depart.getNum_station());

            while (i!=arrivee.getNum_station()) {
                    i=TrouverStation(depart,arrivee,i,metro);
                chemin.add(i);
            }
        //cas où les stations sont sur 2 lignes différents

        System.out.println(chemin);
        return chemin;
    }
    public static int TrouverStation(Station depart,Station arrivee, int i, Metro metro){


        System.out.println("Stationn" + i);
        System.out.println(sensAfter);
        if(getStationSelonNum(metro.getStations(),i).get(0).getLiaison_after()!=null && sensAfter){
            int num=i;
            System.out.println("gg "+metro.getStations().stream()
                    .filter(station -> station.getNum_station()==num).map(Station::getNum_station).findFirst());

                    /*int station =  metro.stream()
                            .filter(station -> station.getNum_station() == num)
                            .findFirst();*/
            //System.out.println(getStationSelonNum(metro.getStations(),i).get(0).getLiaison_after().getNum_station()+"dudu"+getStationSelonNum(metro.getStations(),i).get(1).getLiaison_after().getNum_station());
            System.out.println(arrivee.getNum_station());
            System.out.println(arrivee.getLigne());
            if(getStationSelonNum(metro.getStations(),i).size()>1){
                System.out.println(getStationSelonNum(metro.getStations(),i).get(0).getLiaison_after().getNum_station()+"titititi "+getStationSelonNum(metro.getStations(),i).get(1).getLiaison_after().getNum_station());
                if( getStationSelonNum(metro.getStations(),i).get(0).getLigne()== arrivee.getLigne()){
                    i=getStationSelonNum(metro.getStations(),i).get(0).getLiaison_after().getNum_station();

                }else if(getStationSelonNum(metro.getStations(),i).get(1).getLigne()== arrivee.getLigne()){
                    i=getStationSelonNum(metro.getStations(),i).get(1).getLiaison_after().getNum_station();

                }else if (getStationSelonNum(metro.getStations(),i).get(0).getLigne()== depart.getLigne()){
                    i=getStationSelonNum(metro.getStations(),i).get(0).getLiaison_after().getNum_station();

                }else if(getStationSelonNum(metro.getStations(),i).get(1).getLigne()== depart.getLigne()){
                    i=getStationSelonNum(metro.getStations(),i).get(1).getLiaison_after().getNum_station();

                }
            }
           else//(getStationSelonNum(metro.getStations(),i).size()==1){
            {i=getStationSelonNum(metro.getStations(),i).get(0).getLiaison_after().getNum_station();
           }

            System.out.println(i);
            System.out.println("ja");
        }
        if(getStationSelonNum(metro.getStations(),i).get(0).getLiaison_after()==null && sensAfter && i !=arrivee.getNum_station()){
            System.out.println("aie");
            sensAfter=false;
            i= depart.getNum_station();
            System.out.println("jani");
        }
        if(!sensAfter){


            /*i=getStationSelonNum(metro.getStations(),i).get(0).getLiaison_before().getNum_station();
            System.out.println("janou");*/
            if(getStationSelonNum(metro.getStations(),i).size()>1){
                System.out.println(getStationSelonNum(metro.getStations(),i).get(0).getLiaison_before().getNum_station()+"tututu popop"+getStationSelonNum(metro.getStations(),i).get(1).getLiaison_before().getNum_station());
                if( getStationSelonNum(metro.getStations(),i).get(0).getLigne()== arrivee.getLigne()){
                    i=getStationSelonNum(metro.getStations(),i).get(0).getLiaison_before().getNum_station();

                }else if(getStationSelonNum(metro.getStations(),i).get(1).getLigne()== arrivee.getLigne()){
                    i=getStationSelonNum(metro.getStations(),i).get(1).getLiaison_before().getNum_station();

                }else if (getStationSelonNum(metro.getStations(),i).get(0).getLigne()== depart.getLigne()){
                    i=getStationSelonNum(metro.getStations(),i).get(0).getLiaison_before().getNum_station();

                }else if(getStationSelonNum(metro.getStations(),i).get(1).getLigne()== depart.getLigne()){
                    i=getStationSelonNum(metro.getStations(),i).get(1).getLiaison_before().getNum_station();

                }
            }
            else//(getStationSelonNum(metro.getStations(),i).size()==1){
            {i=getStationSelonNum(metro.getStations(),i).get(0).getLiaison_before().getNum_station();
            }
        }
        return i;

    }
}
