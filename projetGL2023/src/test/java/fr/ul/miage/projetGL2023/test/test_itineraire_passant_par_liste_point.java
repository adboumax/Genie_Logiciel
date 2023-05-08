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

public class test_itineraire_passant_par_liste_point {


    @Test
    @DisplayName("itineraire le plus rapide Station 1 vide")
    public void itinerairePassantListePointStation1Vide(){
        Station x =  null;
        Station y =  new Station("Chatelet les Halles",1,1,false, new Liaison(30,false,2),
                null,20);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null,
                new Liaison(30,false,5),40);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(50,false,6),
                new Liaison(70,false,4),120);
        List<Station> list = Arrays.asList(Arc_de_Triomphe,Bercy);
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itineraire_passant_liste_point(x, y,list)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("itineraire passant par liste de point Station 2 vide")
    public void itinerairePassantParListeDePointStation2Vide(){
        Station x =  new Station("Chatelet les Halles",1,1,false, new Liaison(30,false,2),
                null,20);
        Station y =  null;
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null,
                new Liaison(30,false,5),40);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(50,false,6),
                new Liaison(70,false,4),120);
        List<Station> list = Arrays.asList(Arc_de_Triomphe,Bercy);
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itineraire_passant_liste_point(x, y,list)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("itineraire passant par listes de point les 2 stations vide")
    public void itineraireRapideles2stationVide(){
        Station x =  null;
        Station y =  null;
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null,
                new Liaison(30,false,5),40);
        Station Bercy =new Station("Bercy",1,5,false,new Liaison(50,false,6),
                new Liaison(70,false,4),120);
        List<Station> list = Arrays.asList(Arc_de_Triomphe,Bercy);
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itineraire_passant_liste_point(x, y,list)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("itineraire passant par liste de point simple (point sur le chemin")
    public void itinerairePassantparListeDePointSimple(){
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(30,false,2),
                null,20);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null,
                new Liaison(30,false,5),40);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(30,false,3),
                new Liaison(30,false,1),90);
        Station Montmartre = new Station("Montmartre",1,3,false,null,
                null,90);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(30,false,5),
                new Liaison(30,false,3),90);
        Station Bercy =new Station("Bercy",1,5,false,new Liaison(50,false,6),
                new Liaison(70,false,4),120);
        List<Station> trajet =  Arrays.asList(chatelet_les_halles,Pigalle,Montmartre,Louvre,Bercy,Arc_de_Triomphe);
        var ln= new Metro();
        List<Station> list =  Arrays.asList(Montmartre);
        var result = ln.Itineraire_passant_liste_point(chatelet_les_halles,Arc_de_Triomphe,list);
        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire passant par liste de point simple 2 ( 2 points sur le chemin")
    public void itineraireListeDePointSimple2(){
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(30,false,2),
                null,20);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null,
                new Liaison(30,false,5),40);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(30,false,3),
                new Liaison(30,false,1),90);
        Station Montmartre = new Station("Montmartre",1,3,false,null,
                null,90);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(30,false,5),
                new Liaison(30,false,3),90);
        Station Bercy =new Station("Bercy",1,5,false,new Liaison(50,false,6),
                new Liaison(70,false,4),120);
        List<Station> trajet =  Arrays.asList(chatelet_les_halles,Pigalle,Montmartre,Louvre,Bercy,Arc_de_Triomphe);
        var ln= new Metro();
        List<Station> list =  Arrays.asList(Montmartre,Bercy);
        var result = ln.Itineraire_passant_liste_point(chatelet_les_halles,Arc_de_Triomphe,list);
        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire passant par liste de point simple (1 point à l'opposée)")
    public void itinerairePassantParUnPointOpposée(){
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(30,false,2),
                null,20);
        Station Arc_de_Triomphe =new Station("Arc de triomphe",1,6,false,null,
                new Liaison(30,false,5),40);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(30,false,3),
                new Liaison(30,false,1),90);
        Station Montmartre = new Station("Montmartre",1,3,false,null,
                null,90);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(30,false,5),
                new Liaison(30,false,3),90);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(50,false,6),
                new Liaison(70,false,4),120);
        Station La_Defense = new Station("La Défense",2,7,false,new Liaison(50,false,8),
                null,120);
        List<Station> trajet =  Arrays.asList(chatelet_les_halles,Pigalle,Montmartre,Louvre,Bercy,Arc_de_Triomphe);
        var ln= new Metro();
        List<Station> list =  Arrays.asList(La_Defense);
        var result = ln.Itineraire_passant_liste_point(chatelet_les_halles,Arc_de_Triomphe,list);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire passant par liste de point simple (2 points à l'opposée)")
    public void itinerairePassantPar2PointsOpposées(){
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(30,false,2),
                null,20);
        Station Arc_de_Triomphe =new Station("Arc de triomphe",1,6,false,null,
                new Liaison(30,false,5),40);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(30,false,3),
                new Liaison(30,false,1),90);
        Station Montmartre = new Station("Montmartre",1,3,false,null,
                null,90);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(30,false,5),
                new Liaison(30,false,3),90);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(50,false,6),
                new Liaison(70,false,4),120);
        Station La_Defense = new Station("La Défense",2,7,false,new Liaison(50,false,8),
                null,120);
        Station Pantheon = new Station("Panthéon",2,12,false,null,
                new Liaison(70,false,11),120);
        List<Station> trajet =  Arrays.asList(chatelet_les_halles,Pigalle,Montmartre,Louvre,Bercy,Arc_de_Triomphe);
        var ln= new Metro();

        List<Station> list =  Arrays.asList(La_Defense,Pantheon);
        var result = ln.Itineraire_passant_liste_point(chatelet_les_halles,Arc_de_Triomphe,list);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire le plus rapide station arrivee et depart different")
    public void itineraireRapideStationArriveeEtDepartDiff(){
        Station x =  new Station("Arc de triomphe",1,6,false,null,
                new Liaison(30,false,5),40);
        Station y =new Station("Arc de triomphe",1,6,false,null,
                new Liaison(30,false,5),40);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null,
                new Liaison(30,false,5),40);
        Station Bercy =new Station("Bercy",1,5,false,new Liaison(50,false,6),
                new Liaison(70,false,4),120);
        List<Station> list = Arrays.asList(Arc_de_Triomphe,Bercy);
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itineraire_passant_liste_point(x, y,list)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    //Pt des tests sur des itineraires sur correspondance
}
