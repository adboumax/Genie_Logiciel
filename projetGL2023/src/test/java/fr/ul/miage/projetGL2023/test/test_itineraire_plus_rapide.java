package fr.ul.miage.projetGL2023.test;

import fr.ul.miage.projetGL2023.algorithme.Algorithme;
import fr.ul.miage.projetGL2023.model.Liaison;
import fr.ul.miage.projetGL2023.model.Metro;
import fr.ul.miage.projetGL2023.model.Station;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class test_itineraire_plus_rapide {


    @Test
    @DisplayName("itineraire le plus rapide Station 1 null")
    public void itineraireRapideStation1Vide(){
        Metro metro = new Metro();
        Station x =  null;
        Station y =  new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30,0.0,0.0);
        Algorithme trajet= new Algorithme();
        assertThatThrownBy(()-> trajet.algoCheminCourt(x, y, metro)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("itineraire le plus rapide Station 2 null")
    public void itineraireRapideStation2Vide(){
        Metro metro = new Metro();
        Station x =  new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30,0.0,0.0);
        Station y =  null;
        Algorithme trajet= new Algorithme();
        assertThatThrownBy(()-> trajet.algoCheminCourt(x, y, metro)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("itineraire le plus rapide les 2 stations null")
    public void itineraireRapideles2stationVide(){
        Metro metro = new Metro();
        Station x =  null;
        Station y =  null;
        Algorithme trajet= new Algorithme();
        assertThatThrownBy(()-> trajet.algoCheminCourt(x, y, metro)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("itineraire le plus rapide simple")
    public void itineraireRapideSimple(){
        Metro metro = new Metro();
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30,0.0,0.0);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30,0.0,0.0);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30,0.0,0.0);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30,0.0,0.0);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30,0.0,0.0);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30,0.0,0.0);

        List<Integer> trajet =  Arrays.asList(chatelet_les_halles.getNum_station(),Pigalle.getNum_station(),Montmartre.getNum_station(),Louvre.getNum_station(),Bercy.getNum_station(),Arc_de_Triomphe.getNum_station());
        Algorithme ln= new Algorithme();
        var result = ln.algoCheminCourt(chatelet_les_halles,Arc_de_Triomphe, metro);

        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire le plus Autre Sens")
    public void itineraireRapideSimpleAutreSens(){
        Metro metro = new Metro();
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30,0.0,0.0);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30,0.0,0.0);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30,0.0,0.0);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30,0.0,0.0);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30,0.0,0.0);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30,0.0,0.0);

        List<Integer> trajet =  Arrays.asList(Arc_de_Triomphe.getNum_station(),Bercy.getNum_station(),Louvre.getNum_station(),Montmartre.getNum_station(),Pigalle.getNum_station(),chatelet_les_halles.getNum_station());
        var ln= new Algorithme();
        var result = ln.algoCheminCourt(Arc_de_Triomphe,chatelet_les_halles, metro);

        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire le plus rapide correspondance")
    public void itineraireRapideCorrespondance(){
        Metro metro = new Metro();
        Station Musee_grevin = new Station("Musée grévin",3,12,false, new Liaison(90,false,13), null,30,0.0,0.0);
        Station Place_italie = new Station("Place d'italie",3,13,false,new Liaison(180,false,3), new Liaison(90,false,12),30,0.0,0.0);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30,0.0,0.0);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30,0.0,0.0);

        List<Integer> trajet =  Arrays.asList(Musee_grevin.getNum_station(),Place_italie.getNum_station(),Montmartre.getNum_station(),Louvre.getNum_station());
        var ln= new Algorithme();
        var result = ln.algoCheminCourt(Musee_grevin,Louvre, metro);

        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire le plus rapide correspondance inverse")
    public void itineraireRapideCorrespondanceInverse(){
        Metro metro = new Metro();
        Station Musee_grevin = new Station("Musée grévin",3,12,false, new Liaison(90,false,13), null,30,0.0,0.0);
        Station Place_italie = new Station("Place d'italie",3,13,false,new Liaison(180,false,3), new Liaison(90,false,12),30,0.0,0.0);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30,0.0,0.0);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30,0.0,0.0);

        List<Integer> trajet =  Arrays.asList(Louvre.getNum_station(),Montmartre.getNum_station(),Place_italie.getNum_station(),Musee_grevin.getNum_station());
        var ln= new Algorithme();
        var result = ln.algoCheminCourt(Louvre,Musee_grevin, metro);

        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire le plus rapide double correspondance")
    public void itineraireRapideDoubleCorrespondance(){
        Metro metro = new Metro();
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30,0.0,0.0);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30,0.0,0.0);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30,0.0,0.0);
        Station Billancourt = new Station("Billancourt",2,9,false,new Liaison(120,false,10), new Liaison(30,false,4),30,0.0,0.0);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30,0.0,0.0);
        Station Grigny = new Station("Grigny-la-grande-Borne",2,10,false,new Liaison(120,false,11), new Liaison(120,false,9),30,0.0,0.0);
        Station Pantheon = new Station("Panthéon",2,11,false,null, new Liaison(120,false,10),30,0.0,0.0);

        List<Integer> trajet =  Arrays.asList(Pantheon.getNum_station(),Grigny.getNum_station(), Billancourt.getNum_station(), Louvre.getNum_station(),Montmartre.getNum_station(),Pigalle.getNum_station(),chatelet_les_halles.getNum_station());
        var ln= new Algorithme();
        var result = ln.algoCheminCourt(Pantheon,chatelet_les_halles, metro);

        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire le plus rapide double correspondance Inverse")
    public void itineraireRapideDoubleCorrespondanceInverse(){
        Metro metro = new Metro();
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30,0.0,0.0);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30,0.0,0.0);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30,0.0,0.0);
        Station Billancourt = new Station("Billancourt",2,9,false,new Liaison(120,false,10), new Liaison(30,false,4),30,0.0,0.0);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30,0.0,0.0);
        Station Grigny = new Station("Grigny-la-grande-Borne",2,10,false,new Liaison(120,false,11), new Liaison(120,false,9),30,0.0,0.0);
        Station Pantheon = new Station("Panthéon",2,11,false,null, new Liaison(120,false,10),30,0.0,0.0);

        List<Integer> trajet =  Arrays.asList(chatelet_les_halles.getNum_station(),Pigalle.getNum_station(),Montmartre.getNum_station(), Louvre.getNum_station(), Billancourt.getNum_station(),Grigny.getNum_station(),Pantheon.getNum_station());
        var ln= new Algorithme();
        var result = ln.algoCheminCourt(chatelet_les_halles,Pantheon, metro);

        assertThat(result).isEqualTo(trajet);

    }

    @Test
    @DisplayName("itineraire le plus rapide station arrivee et depart identique")
    public void itineraireRapideStationArriveeEtDepartDiff(){
        Metro metro = new Metro();
        Station x =  new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30,0.0,0.0);
        Station y = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30,0.0,0.0);
        Algorithme trajet= new Algorithme();
        assertThatThrownBy(()-> trajet.algoCheminCourt(x, y, metro)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("itineraire le plus rapide problème station liason")
    public void itineraireRapideSimpleProblemeLiason(){
        Metro metro = new Metro();
        metro.getStations().get(0).getLiaison_after().setProbleme(true);
        Station chatelet_les_halles = metro.getStations().get(0);
        Station Pigalle = metro.getStations().get(1);

        Algorithme ln= new Algorithme();
        var result = ln.algoCheminCourt(chatelet_les_halles,Pigalle, metro);

        assertThat(result).isEqualTo(null);

    }

    @Test
    @DisplayName("itineraire le plus rapide simple Station")
    public void itineraireRapideSimpleStation(){
        Metro metro = new Metro();
        Station chatelet_les_halles = metro.getStations().get(0);
        metro.getStations().get(1).setProbleme(true);
        Station Montmartre = metro.getStations().get(2);
        Algorithme ln= new Algorithme();
        var result = ln.algoCheminCourt(chatelet_les_halles,Montmartre, metro);

        assertThat(result).isEqualTo(null);

    }


}
