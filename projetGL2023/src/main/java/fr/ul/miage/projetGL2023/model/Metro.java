package fr.ul.miage.projetGL2023.model;


import fr.ul.miage.projetGL2023.algorithme.Algorithme;

import java.util.ArrayList;
import java.util.List;

public class Metro {

    public Metro(List<Station> stationList)
    {
        setStations(stationList);
    }
    public List<Station> stations;


    public Metro (){
        this.stations=new ArrayList<Station>();

        //Le temps est exprimé en secondes
        //Ligne 1
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30,0.0,0.0);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30,0.0,1.0);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30,0.0,1.0);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30,1.0,1.0);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30,2.0,1.0);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30,2.0,1.0);

        //Ligne 2
        Station La_Defense = new Station("La Défense",2,7,false,new Liaison(60,false,8), null,30,1.0,2.0);
        Station Invalides = new Station("Invalides",2,8,false,new Liaison(210,false,4), new Liaison(60,false,7),30,1.0,2.0);
        Station Louvre2 = new Station("Louvre 2",2,4,false,new Liaison(30,false,9), new Liaison(210,false,8),30,1.0,1.0);
        Station Billancourt = new Station("Billancourt",2,9,false,new Liaison(120,false,10), new Liaison(30,false,4),30,1.0,1.0);
        Station Grigny = new Station("Grigny-la-grande-Borne",2,10,false,new Liaison(120,false,11), new Liaison(120,false,9),30,1.0,0.0);
        Station Pantheon = new Station("Panthéon",2,11,false,null, new Liaison(120,false,10),30,1.0,0.0);

        //Ligne 3
        Station Musee_grevin = new Station("Musée grévin",3,12,false, new Liaison(90,false,13), null,30,0.0,2.0);
        Station Place_italie = new Station("Place d'italie",3,13,false,new Liaison(180,false,3), new Liaison(90,false,12),30,0.0,2.0);
        Station Montmartre2 = new Station("Montmartre 2",3,3,false,new Liaison(250,false,10), new Liaison(180,false,13),30,0.0,1.0);
        Station Grigny_la_grande_borne2 = new Station("Grigny-la-grande-borne 2",3,10,false,new Liaison(90,false,14), new Liaison(250,false,3),30,1.0,0.0);
        Station Bastille = new Station("Bastille",3,14,false,new Liaison(180,false,5), new Liaison(90,false,10),30,2.0,1.0);
        Station Bercy2 = new Station("Bercy 2",3,5,false,new Liaison(90,false,15), new Liaison(180,false,14),30,2.0,1.0);
        Station Champ_de_mars = new Station("Champ de mars",3,15,false,null, new Liaison(90,false,5),30,2.0,2.0);


        this.stations.addAll(List.of(chatelet_les_halles, Pigalle, Montmartre, Louvre, Bercy, Arc_de_Triomphe,
                La_Defense, Invalides, Louvre2, Billancourt, Grigny, Pantheon,
                Musee_grevin, Place_italie,Montmartre2, Grigny_la_grande_borne2, Bastille, Bercy2, Champ_de_mars));
    }


    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<Integer> Itiniraire_moins_changement(Station x, Station y) {
        return null;
    }

    public List<Integer> Itineraire_passant_liste_point(Station x, Station y, List<Station> list) {
        return null;
    }

    private double calculDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public List<Station> trouveStationsPlusProche(double x, double y) {
        List<Station> resultat = new ArrayList<>();
        double min = Double.MAX_VALUE;

        for (Station station : getStations()) {
            double distance = calculDistance(station.getX(), station.getY(), x, y);

            if (distance == min) {
                min = distance;
                resultat.add(station);
            }
            if (distance < min) {
                resultat.clear();
                min = distance;
                resultat.add(station);
            }
        }

        return resultat;
    }
}
