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
        Station y =  new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        List<Station> list = Arrays.asList(Arc_de_Triomphe,Bercy);
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itineraire_passant_liste_point(x, y,list)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("itineraire passant par liste de point Station 2 vide")
    public void itinerairePassantParListeDePointStation2Vide(){
        Station x =  new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station y =  null;
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        List<Station> list = Arrays.asList(Arc_de_Triomphe,Bercy);
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itineraire_passant_liste_point(x, y,list)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("itineraire passant par listes de point les 2 stations vide")
    public void itineraireRapideles2stationVide(){
        Station x =  null;
        Station y =  null;
        Station Arc_de_Triomphe =new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        List<Station> list = Arrays.asList(Arc_de_Triomphe,Bercy);
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itineraire_passant_liste_point(x, y,list)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("itineraire passant par liste de point simple (point sur le chemin")
    public void itinerairePassantparListeDePointSimple(){
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);

        List<Station> trajet =  Arrays.asList(chatelet_les_halles,Pigalle,Montmartre,Louvre,Bercy,Arc_de_Triomphe);
        var ln= new Metro();
        List<Station> list =  Arrays.asList(Montmartre);
        var result = ln.Itineraire_passant_liste_point(chatelet_les_halles,Arc_de_Triomphe,list);
        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire passant par liste de point simple 2 ( 2 points sur le chemin")
    public void itineraireListeDePointSimple2(){
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);

        List<Station> trajet =  Arrays.asList(Arc_de_Triomphe,Bercy,Louvre,Montmartre,Pigalle,chatelet_les_halles);
        var ln= new Metro();
        List<Station> list =  Arrays.asList(Montmartre,Bercy);
        var result = ln.Itineraire_passant_liste_point(Arc_de_Triomphe,chatelet_les_halles,list);
        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire passant par liste de point simple (1 point à l'opposée)")
    public void itinerairePassantParUnPointOpposée(){
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        Station La_Defense = new Station("La Défense",2,7,false,new Liaison(60,false,8), null,30);
        Station Invalides = new Station("Invalides",2,8,false,new Liaison(210,false,4), new Liaison(60,false,7),30);
        Station Louvre2 = new Station("Louvre",2,4,false,new Liaison(30,false,10), new Liaison(210,false,8),30);
        List<Station> trajet =  Arrays.asList(chatelet_les_halles,Pigalle,Montmartre,Louvre,Louvre2,Invalides,La_Defense,Invalides,Louvre2,Louvre,Bercy,Arc_de_Triomphe);
        var ln= new Metro();
        List<Station> list =  Arrays.asList(La_Defense);
        var result = ln.Itineraire_passant_liste_point(chatelet_les_halles,Arc_de_Triomphe,list);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire passant par liste de point simple (1 point à l'opposée sens inverse)")
    public void itinerairePassantParUnPointOpposéeSensinverse(){
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        Station La_Defense = new Station("La Défense",2,7,false,new Liaison(60,false,8), null,30);
        Station Invalides = new Station("Invalides",2,8,false,new Liaison(210,false,4), new Liaison(60,false,7),30);
        Station Louvre2 = new Station("Louvre",2,4,false,new Liaison(30,false,10), new Liaison(210,false,8),30);
        List<Station> trajet =  Arrays.asList(Arc_de_Triomphe,Bercy,Louvre,Louvre2,Invalides,La_Defense,Invalides,Louvre2,Louvre,Montmartre,Pigalle,chatelet_les_halles);
        var ln= new Metro();
        List<Station> list =  Arrays.asList(La_Defense);
        var result = ln.Itineraire_passant_liste_point(Arc_de_Triomphe,chatelet_les_halles,list);
        assertThat(result).isEqualTo(trajet);
    }

    @Test
    @DisplayName("itineraire passant par liste de point simple (2 points à l'opposée)")
    public void itinerairePassantPar2PointsOpposées(){
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);

        Station La_Defense = new Station("La Défense",2,7,false,new Liaison(60,false,8), null,30);
        Station Invalides = new Station("Invalides",2,8,false,new Liaison(210,false,4), new Liaison(60,false,7),30);
        Station Louvre2 = new Station("Louvre",2,4,false,new Liaison(30,false,10), new Liaison(210,false,8),30);
        Station Billancourt = new Station("Billancourt",2,9,false,new Liaison(120,false,10), new Liaison(30,false,4),30);
        Station Grigny = new Station("Grigny-la-grande-Borne",2,10,false,new Liaison(120,false,11), new Liaison(120,false,9),30);
        Station Pantheon = new Station("Panthéon",2,11,false,null, new Liaison(120,false,10),30);
        Station Montmartre2 = new Station("Montmartre",3,3,false,new Liaison(250,false,10), new Liaison(180,false,13),30);
        Station Grigny_la_grande_borne2 = new Station("Grigny-la-grande-borne",3,10,false,new Liaison(90,false,14), new Liaison(250,false,3),30);

        List<Station> trajet =  Arrays.asList(chatelet_les_halles,Pigalle,Montmartre,Montmartre2,Grigny_la_grande_borne2,Grigny,Pantheon,Grigny,Billancourt,Louvre2,Invalides,La_Defense,Invalides,Louvre2,Louvre,Bercy,Arc_de_Triomphe);
        var ln= new Metro();

        List<Station> list =  Arrays.asList(La_Defense,Pantheon);
        var result = ln.Itineraire_passant_liste_point(chatelet_les_halles,Arc_de_Triomphe,list);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire passant par liste de point simple (2 points à l'opposée) nsens contraire")
    public void itinerairePassantPar2PointsOpposéesSensContraire(){
        Station chatelet_les_halles = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);

        Station La_Defense = new Station("La Défense",2,7,false,new Liaison(60,false,8), null,30);
        Station Invalides = new Station("Invalides",2,8,false,new Liaison(210,false,4), new Liaison(60,false,7),30);
        Station Louvre2 = new Station("Louvre",2,4,false,new Liaison(30,false,10), new Liaison(210,false,8),30);
        Station Billancourt = new Station("Billancourt",2,9,false,new Liaison(120,false,10), new Liaison(30,false,4),30);
        Station Grigny = new Station("Grigny-la-grande-Borne",2,10,false,new Liaison(120,false,11), new Liaison(120,false,9),30);
        Station Pantheon = new Station("Panthéon",2,11,false,null, new Liaison(120,false,10),30);
        Station Montmartre2 = new Station("Montmartre",3,3,false,new Liaison(250,false,10), new Liaison(180,false,13),30);
        Station Grigny_la_grande_borne2 = new Station("Grigny-la-grande-borne",3,10,false,new Liaison(90,false,14), new Liaison(250,false,3),30);

        List<Station> trajet =  Arrays.asList(Arc_de_Triomphe,Bercy,Louvre,Louvre2,Invalides,Louvre2,Billancourt,Grigny,Pantheon,Grigny,Grigny_la_grande_borne2,Montmartre2,Montmartre,Pigalle,chatelet_les_halles);
        var ln= new Metro();

        List<Station> list =  Arrays.asList(Pantheon,La_Defense);
        var result = ln.Itineraire_passant_liste_point(chatelet_les_halles,Arc_de_Triomphe,list);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire le plus rapide station arrivee et depart different")
    public void itineraireRapideStationArriveeEtDepartDiff(){
        Station x =  new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        Station y =new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        List<Station> list = Arrays.asList(Arc_de_Triomphe,Bercy);
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itineraire_passant_liste_point(x, y,list)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    //Pt des tests sur des itineraires sur correspondance
}
