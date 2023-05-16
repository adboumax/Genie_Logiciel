package fr.ul.miage.projetGL2023;

 import java.util.*;
 import java.util.stream.Collectors;

public class Algorithme {

    public static List<Integer> algoCheminCourt(Station depart, Station arrivee) {
        Metro metro = new Metro();

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

                    List<Liaison> liaisonsAutours = metro.stations.stream().filter(x -> x.liaison_after != null && x.liaison_after.getNum_station() == actuelle.getNum_station())
                            .map(x -> actuelle.getLiaison_before())
                            .collect(Collectors.toList());

                    liaisonsAutours.addAll(metro.stations.stream().filter(x -> x.liaison_before != null && x.liaison_before.getNum_station() == actuelle.getNum_station())
                            .map(x -> actuelle.getLiaison_after())
                            .collect(Collectors.toList()));

                    liaisonsAutours.addAll(metro.stations.stream().filter(x -> x.getNum_station() == actuelle.getNum_station()
                                    && x.getLigne() != actuelle.getLigne()
                                    && x.liaison_after != null
                                    && x.liaison_after.getNum_station() == actuelle.getNum_station())
                            .map(x -> x.getLiaison_before())
                            .collect(Collectors.toList()));

                    liaisonsAutours.addAll(metro.stations.stream().filter(x -> x.getNum_station() == actuelle.getNum_station()
                                    && x.getLigne() != actuelle.getLigne()
                                    && x.liaison_before != null
                                    && x.liaison_before.getNum_station() == actuelle.getNum_station())
                            .map(x -> x.getLiaison_after())
                            .collect(Collectors.toList()));


                    for (Liaison lien : liaisonsAutours) {
                        Station voisine = getStationSelonNum(metro.getStations(), lien.getNum_station());
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

            public static List<Integer> refaireChemin (Map <Station, Station> provientDe, Station actuelle){
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
            public static double heuristicAlgoLePlusCourt (Station depart, Station arrivee){
                double dx = depart.getLigne() - arrivee.getLigne();
                double dy = depart.getNum_station() - arrivee.getNum_station();
                return Math.sqrt(dx * dx + dy * dy);
            }

            public static Station getStationSelonNum (List < Station > list,int num)
            {
                return list.stream().filter(x -> x.getNum_station() == num)
                        .collect(Collectors.toList())
                        .get(0);
            }
}

