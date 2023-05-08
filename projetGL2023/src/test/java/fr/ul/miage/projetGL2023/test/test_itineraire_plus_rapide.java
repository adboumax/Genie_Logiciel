package fr.ul.miage.projetGL2023.test;

import fr.ul.miage.projetGL2023.Liaison;
import fr.ul.miage.projetGL2023.Metro;
import fr.ul.miage.projetGL2023.Station;
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
        Station x =  null;
        Station y =  new Station("Chatelet les Halles",1,1,false, new Liaison(30,false,2),
                null,20);
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itiniraire_plus_rapide(x, y)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("itineraire le plus rapide Station 2 null")
    public void itineraireRapideStation2Vide(){
        Station x =  new Station("Chatelet les Halles",1,1,false, new Liaison(30,false,2),
                null,20);
        Station y =  null;
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itiniraire_plus_rapide(x, y)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("itineraire le plus rapide les 2 stations null")
    public void itineraireRapideles2stationVide(){
        Station x =  null;
        Station y =  null;
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itiniraire_plus_rapide(x, y)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("itineraire le plus rapide simple")
    public void itineraireRapideSimple(){

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
        List<Station> trajet =  Arrays.asList(chatelet_les_halles,Pigalle,Montmartre,Louvre,Bercy,Arc_de_Triomphe);
        var ln= new Metro();
        var result = ln.Itiniraire_plus_rapide(chatelet_les_halles,Arc_de_Triomphe);
        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire le plus Autre Sens")
    public void itineraireRapideSimpleAutreSens(){
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
        List<Station> trajet =  Arrays.asList(Arc_de_Triomphe,Bercy,Louvre,Montmartre,Pigalle,chatelet_les_halles);
        var ln= new Metro();
        var result = ln.Itiniraire_plus_rapide(Arc_de_Triomphe,chatelet_les_halles);
        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire le plus rapide correspondance")
    public void itineraireRapideCorrespondance(){

        Station Musee_grevin = new Station("Musée grévin",3,13,false,null,
                new Liaison(30,false,1),90);
        Station Place_italie = new Station("Place d'italie",3,14,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);
        Station Montmartre2 = new Station("Montmartre",3,15,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);
        Station Montmartre = new Station("Montmartre",1,3,false,null,
                null,90);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(30,false,5),
                new Liaison(30,false,3),90);
        List<Station> trajet =  Arrays.asList(Musee_grevin,Place_italie,Montmartre2,Montmartre,Louvre);
        var ln= new Metro();
        var result = ln.Itiniraire_plus_rapide(Musee_grevin,Louvre);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire le plus rapide correspondance inverse")
    public void itineraireRapideCorrespondanceInverse(){


        Station Musee_grevin = new Station("Musée grévin",3,13,false,null,
                new Liaison(30,false,1),90);
        Station Place_italie = new Station("Place d'italie",3,14,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);
        Station Montmartre2 = new Station("Montmartre",3,15,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);
        Station Montmartre = new Station("Montmartre",1,3,false,null,
                null,90);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(30,false,5),
                new Liaison(30,false,3),90);
        List<Station> trajet =  Arrays.asList(Louvre,Montmartre,Montmartre2,Place_italie,Musee_grevin);
        var ln= new Metro();
        var result = ln.Itiniraire_plus_rapide(Louvre,Musee_grevin);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire le plus rapide double correspondance")
    public void itineraireRapideDoubleCorrespondance(){



        Station Musee_grevin = new Station("Musée grévin",3,13,false,null,
                new Liaison(30,false,1),90);
        Station Place_italie = new Station("Place d'italie",3,14,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);
        Station Montmartre2 = new Station("Montmartre",3,15,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);
        Station Grigny_la_grande_borne2 = new Station("Grigny-la-grande-borne",3,16,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);
        Station Grigny = new Station("Grigny-la-grande-Borne",2,11,false,new Liaison(50,false,12),
                new Liaison(70,false,10),120);
        Station Pantheon = new Station("Panthéon",2,12,false,null,
                new Liaison(70,false,11),120);
        List<Station> trajet =  Arrays.asList(Musee_grevin,Place_italie,Montmartre2,Grigny_la_grande_borne2,Grigny,Pantheon);
        var ln= new Metro();
        var result = ln.Itiniraire_plus_rapide(Musee_grevin,Pantheon);
        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire le plus rapide double correspondance Inverse")
    public void itineraireRapideDoubleCorrespondanceInverse(){



        Station Musee_grevin = new Station("Musée grévin",3,13,false,null,
                new Liaison(30,false,1),90);
        Station Place_italie = new Station("Place d'italie",3,14,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);
        Station Montmartre2 = new Station("Montmartre",3,15,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);
        Station Grigny_la_grande_borne2 = new Station("Grigny-la-grande-borne",3,16,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90);
        Station Grigny = new Station("Grigny-la-grande-Borne",2,11,false,new Liaison(50,false,12),
                new Liaison(70,false,10),120);
        Station Pantheon = new Station("Panthéon",2,12,false,null,
                new Liaison(70,false,11),120);
        List<Station> trajet =  Arrays.asList(Pantheon,Grigny,Grigny_la_grande_borne2,Montmartre2,Place_italie,Musee_grevin);
        var ln= new Metro();
        var result = ln.Itiniraire_plus_rapide(Pantheon,Musee_grevin);
        assertThat(result).isEqualTo(trajet);

    }

    @Test
    @DisplayName("itineraire le plus rapide station arrivee et depart identique")
    public void itineraireRapideStationArriveeEtDepartDiff(){
        Station x =  new Station("Arc de triomphe",1,6,false,null,
                new Liaison(30,false,5),40);
        Station y = new Station("Arc de triomphe",1,6,false,null,
                new Liaison(30,false,5),40);
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itiniraire_plus_rapide(x, y)).isExactlyInstanceOf(IllegalArgumentException.class);
    }




}
