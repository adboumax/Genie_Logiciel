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
        Station y =  new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itiniraire_plus_rapide(x, y)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("itineraire le plus rapide Station 2 null")
    public void itineraireRapideStation2Vide(){
        Station x =  new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
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

        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        List<Station> trajet =  Arrays.asList(chatelet_les_halles,Pigalle,Montmartre,Louvre,Bercy,Arc_de_Triomphe);
        var ln= new Metro();
        var result = ln.Itiniraire_plus_rapide(chatelet_les_halles,Arc_de_Triomphe);
        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire le plus Autre Sens")
    public void itineraireRapideSimpleAutreSens(){
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);

        List<Station> trajet =  Arrays.asList(Arc_de_Triomphe,Bercy,Louvre,Montmartre,Pigalle,chatelet_les_halles);
        var ln= new Metro();
        var result = ln.Itiniraire_plus_rapide(Arc_de_Triomphe,chatelet_les_halles);
        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire le plus rapide correspondance")
    public void itineraireRapideCorrespondance(){

        Station Musee_grevin = new Station("Musée grévin",3,12,false, new Liaison(90,false,14), null,30);
        Station Place_italie = new Station("Place d'italie",3,13,false,new Liaison(180,false,3), new Liaison(90,false,12),30);
        Station Montmartre2 = new Station("Montmartre",3,3,false,new Liaison(250,false,10), new Liaison(180,false,13),30);

        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30);
        List<Station> trajet =  Arrays.asList(Musee_grevin,Place_italie,Montmartre2,Montmartre,Louvre);
        var ln= new Metro();
        var result = ln.Itiniraire_plus_rapide(Musee_grevin,Louvre);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire le plus rapide correspondance inverse")
    public void itineraireRapideCorrespondanceInverse(){


        Station Musee_grevin = new Station("Musée grévin",3,12,false, new Liaison(90,false,14), null,30);
        Station Place_italie = new Station("Place d'italie",3,13,false,new Liaison(180,false,3), new Liaison(90,false,12),30);
        Station Montmartre2 = new Station("Montmartre",3,3,false,new Liaison(250,false,10), new Liaison(180,false,13),30);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30);

        List<Station> trajet =  Arrays.asList(Louvre,Montmartre,Montmartre2,Place_italie,Musee_grevin);
        var ln= new Metro();
        var result = ln.Itiniraire_plus_rapide(Louvre,Musee_grevin);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire le plus rapide double correspondance")
    public void itineraireRapideDoubleCorrespondance(){




        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30);
        Station Montmartre2 = new Station("Montmartre",3,3,false,new Liaison(250,false,10), new Liaison(180,false,13),30);
        Station Grigny_la_grande_borne2 = new Station("Grigny-la-grande-borne",3,10,false,new Liaison(90,false,14), new Liaison(250,false,3),30);
        Station Grigny = new Station("Grigny-la-grande-Borne",2,10,false,new Liaison(120,false,11), new Liaison(120,false,9),30);
        Station Pantheon = new Station("Panthéon",2,11,false,null, new Liaison(120,false,10),30);
        List<Station> trajet =  Arrays.asList(Pantheon,Grigny,Grigny_la_grande_borne2,Montmartre2,Montmartre,Pigalle,chatelet_les_halles);
        var ln= new Metro();
        var result = ln.Itiniraire_plus_rapide(Pantheon,chatelet_les_halles);
        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire le plus rapide double correspondance Inverse")
    public void itineraireRapideDoubleCorrespondanceInverse(){

        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30);
        Station Montmartre2 = new Station("Montmartre",3,3,false,new Liaison(250,false,10), new Liaison(180,false,13),30);
        Station Grigny_la_grande_borne2 = new Station("Grigny-la-grande-borne",3,10,false,new Liaison(90,false,14), new Liaison(250,false,3),30);
        Station Grigny = new Station("Grigny-la-grande-Borne",2,10,false,new Liaison(120,false,11), new Liaison(120,false,9),30);
        Station Pantheon = new Station("Panthéon",2,11,false,null, new Liaison(120,false,10),30);





        List<Station> trajet =  Arrays.asList(chatelet_les_halles,Pigalle,Montmartre,Montmartre2,Grigny_la_grande_borne2,Grigny,Pantheon);
        var ln= new Metro();
        var result = ln.Itiniraire_plus_rapide(chatelet_les_halles,Pantheon);
        assertThat(result).isEqualTo(trajet);

    }

    @Test
    @DisplayName("itineraire le plus rapide station arrivee et depart identique")
    public void itineraireRapideStationArriveeEtDepartDiff(){
        Station x =  new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        Station y = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itiniraire_plus_rapide(x, y)).isExactlyInstanceOf(IllegalArgumentException.class);
    }




}
