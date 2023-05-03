package fr.ul.miage.projetGL2023;


import java.util.List;

public class Metro {

    public Metro(List<Station> stationList)
    {
        setStations(stationList);
    }
    public List<Station> stations;

//(String name, int ligne, int num_station, boolean probleme,
//Liaison liaison_after, Liaison liaison_before, int temps

    /*public int temps;
    public boolean probleme;
    public int numero_ligne;*/
    public Metro (){
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(30,false,2),
                null,20);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(30,false,3),
                new Liaison(30,false,1),90);
        Station Montmartre = new Station("Montmartre",1,3,false,null,
                null,90);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(30,false,5),
                new Liaison(30,false,3),90);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(50,false,6),
                new Liaison(70,false,4),120);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null,
                new Liaison(30,false,5),40);

        //Ligne 2
        Station La_Defense = new Station("La Défense",2,7,false,new Liaison(50,false,8),
                null,120);
        Station Invalides = new Station("Invalides",2,8,false,new Liaison(50,false,9),
                new Liaison(70,false,7),120);
        Station Louvre2 = new Station("Louvre",2,9,false,new Liaison(50,false,10),
                new Liaison(70,false,8),120);
        Station Billancourt = new Station("Billancourt",2,10,false,new Liaison(50,false,11),
                new Liaison(70,false,9),120);
        Station Grigny = new Station("Grigny-la-grande-Borne",2,11,false,new Liaison(50,false,12),
                new Liaison(70,false,10),120);
        Station Pantheon = new Station("Panthéon",2,12,false,null,
                new Liaison(70,false,11),120);

        //Ligne 3
        Station Musee_grevin = new Station("Musée grévin",3,13,false,null,
                new Liaison(30,false,1),90);
        Station Place_italie = new Station("Place d'italie",3,14,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);
        Station Montmartre2 = new Station("Montmartre",3,15,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);
        Station Grigny_la_grande_borne2 = new Station("Grigny-la-grande-borne",3,16,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);
        Station Bercy2 = new Station("Bercy",3,17,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);
        Station Champ_de_mars = new Station("Champ de mars",3,18,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);


    }


    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}