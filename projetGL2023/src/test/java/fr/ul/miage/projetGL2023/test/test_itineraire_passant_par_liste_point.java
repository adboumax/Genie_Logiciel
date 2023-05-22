package fr.ul.miage.projetGL2023.test;


import fr.ul.miage.projetGL2023.algorithme.Algorithme;
import fr.ul.miage.projetGL2023.model.Liaison;
import fr.ul.miage.projetGL2023.model.Metro;
import fr.ul.miage.projetGL2023.model.Station;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class test_itineraire_passant_par_liste_point {


    @Test
    @DisplayName("itineraire le plus rapide Station 1 vide")
    public void itinerairePassantListePointStation1Vide(){

        Metro metro = new Metro();
        Station x =  null;
        Station y =  metro.getStations().get(10);
        Station Passage1 = metro.getStations().get(5);
        Station Passage2 = metro.getStations().get(7);
        List<Integer> list = Arrays.asList(Passage1.getNum_station(), Passage2.getNum_station());
        Algorithme algorithme = new Algorithme();
        assertThatThrownBy(()-> algorithme.algorithmeSelonPoint(x, y, list, metro)).isExactlyInstanceOf(IllegalArgumentException.class);

    }
    @Test
    @DisplayName("itineraire passant par liste de point Station 2 vide")
    public void itinerairePassantParListeDePointStation2Vide(){

        Metro metro = new Metro();
        Station y =  null;
        Station x =  metro.getStations().get(10);
        Station Passage1 = metro.getStations().get(5);
        Station Passage2 = metro.getStations().get(7);
        List<Integer> list = Arrays.asList(Passage1.getNum_station(), Passage2.getNum_station());
        Algorithme algorithme = new Algorithme();
        assertThatThrownBy(()-> algorithme.algorithmeSelonPoint(x, y, list, metro)).isExactlyInstanceOf(IllegalArgumentException.class);

    }
    @Test
    @DisplayName("itineraire passant par listes de point les 2 stations vide")
    public void itineraireRapideles2stationVide(){
        Metro metro = new Metro();
        Station x =  null;
        Station y =  null;
        Station Passage1 = metro.getStations().get(5);
        Station Passage2 = metro.getStations().get(7);
        List<Integer> list = Arrays.asList(Passage1.getNum_station(), Passage2.getNum_station());
        Algorithme algorithme = new Algorithme();
        assertThatThrownBy(()-> algorithme.algorithmeSelonPoint(x, y, list, metro)).isExactlyInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("itineraire passant par liste de point simple (point sur le chemin")
    public void itinerairePassantparListeDePointSimple(){

        Metro metro = new Metro();

        Station chatelet_les_halles = metro.getStations().get(0);
        Station Pigalle = metro.getStations().get(1);
        Station Montmartre = metro.getStations().get(2);
        Station Louvre = metro.getStations().get(3);
        Station Bercy =  metro.getStations().get(4);
        Station Arc_de_Triomphe = metro.getStations().get(5);

        List<Integer> trajet =  Arrays.asList(chatelet_les_halles.getNum_station(),Pigalle.getNum_station(), Montmartre.getNum_station(),Louvre.getNum_station(),Bercy.getNum_station(),Arc_de_Triomphe.getNum_station());
        Algorithme algorithme = new Algorithme();
        List<Integer> list = List.of(Montmartre.getNum_station());
        List result = algorithme.algorithmeSelonPoint(chatelet_les_halles,Arc_de_Triomphe,list, metro);

        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire passant par liste de point simple 2 ( 2 points sur le chemin")
    public void itineraireListeDePointSimple2(){

        Metro metro = new Metro();

        Station chatelet_les_halles = metro.getStations().get(0);
        Station Pigalle = metro.getStations().get(1);
        Station Montmartre = metro.getStations().get(2);
        Station Louvre = metro.getStations().get(3);
        Station Bercy =  metro.getStations().get(4);
        Station Arc_de_Triomphe = metro.getStations().get(5);

        List<Integer> trajet =  Arrays.asList(Arc_de_Triomphe.getNum_station(),Bercy.getNum_station(),Louvre.getNum_station(),
                Montmartre.getNum_station(), Louvre.getNum_station(), Bercy.getNum_station(), Arc_de_Triomphe.getNum_station(),
                Bercy.getNum_station(),Louvre.getNum_station(),Montmartre.getNum_station()
                ,Pigalle.getNum_station(),chatelet_les_halles.getNum_station());
        Algorithme algorithme = new Algorithme();
        List<Integer> list =  Arrays.asList(Montmartre.getNum_station(),Bercy.getNum_station());
        var result = algorithme.algorithmeSelonPoint(Arc_de_Triomphe,chatelet_les_halles,list, metro);

        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire passant par liste de point simple (1 point à l'opposée)")
    public void itinerairePassantParUnPointOpposée(){

        Metro metro = new Metro();

        Station chatelet_les_halles = metro.getStations().get(0);
        Station Pigalle = metro.getStations().get(1);
        Station Montmartre = metro.getStations().get(2);
        Station Louvre = metro.getStations().get(3);
        Station Bercy =  metro.getStations().get(4);
        Station Arc_de_Triomphe = metro.getStations().get(5);
        Station La_Defense = metro.getStations().get(6);
        Station Invalides = metro.getStations().get(7);
        Station Louvre2 = metro.getStations().get(8);
        List<Integer> trajet =  Arrays.asList(chatelet_les_halles.getNum_station(),Pigalle.getNum_station(),Montmartre.getNum_station(),Louvre.getNum_station(),Invalides.getNum_station(),La_Defense.getNum_station(),Invalides.getNum_station(),Louvre2.getNum_station(),Bercy.getNum_station(),Arc_de_Triomphe.getNum_station());
        Algorithme algorithme = new Algorithme();
        List<Integer> list =  Arrays.asList(La_Defense.getNum_station());
        var result = algorithme.algorithmeSelonPoint(chatelet_les_halles,Arc_de_Triomphe,list, metro);

        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire passant par liste de point simple (1 point à l'opposée sens inverse)")
    public void itinerairePassantParUnPointOpposéeSensinverse(){

        Metro metro = new Metro();

        Station chatelet_les_halles = metro.getStations().get(0);
        Station Pigalle = metro.getStations().get(1);
        Station Montmartre = metro.getStations().get(2);
        Station Louvre = metro.getStations().get(3);
        Station Bercy =  metro.getStations().get(4);
        Station Arc_de_Triomphe = metro.getStations().get(5);
        Station La_Defense = metro.getStations().get(6);
        Station Invalides = metro.getStations().get(7);
        Station Louvre2 = metro.getStations().get(8);
        List<Integer> trajet =  Arrays.asList(Arc_de_Triomphe.getNum_station(),Bercy.getNum_station(),Louvre.getNum_station(),Invalides.getNum_station(),La_Defense.getNum_station(),Invalides.getNum_station(),Louvre2.getNum_station(),Montmartre.getNum_station(),Pigalle.getNum_station(),chatelet_les_halles.getNum_station());
        Algorithme algorithme = new Algorithme();
        List<Integer> list =  Arrays.asList(La_Defense.getNum_station());
        var result = algorithme.algorithmeSelonPoint(Arc_de_Triomphe,chatelet_les_halles,list, metro);

        assertThat(result).isEqualTo(trajet);
    }

    @Test
    @DisplayName("itineraire passant par liste de point simple (2 points à l'opposée)")
    public void itinerairePassantPar2PointsOpposées(){

        Metro metro = new Metro();
        Station chatelet_les_halles = metro.getStations().get(0);
        Station Pigalle = metro.getStations().get(1);
        Station Montmartre = metro.getStations().get(2);
        Station Louvre = metro.getStations().get(3);
        Station Bercy =  metro.getStations().get(4);
        Station Arc_de_Triomphe = metro.getStations().get(5);
        Station La_Defense = metro.getStations().get(6);
        Station Invalides = metro.getStations().get(7);
        Station Louvre2 = metro.getStations().get(8);
        Station Billancourt = metro.getStations().get(9);
        Station Grigny = metro.getStations().get(10);
        Station Pantheon = metro.getStations().get(11);
        Station Montmartre2 = metro.getStations().get(14);
        Station Grigny_la_grande_borne2 = metro.getStations().get(15);
        Station Bastille = metro.getStations().get(16);

        List<Integer> trajet =  Arrays.asList(chatelet_les_halles.getNum_station(),Pigalle.getNum_station(),Montmartre.getNum_station(),
                Louvre.getNum_station(),Invalides.getNum_station(),La_Defense.getNum_station(),Invalides.getNum_station(),
                Louvre2.getNum_station(),Billancourt.getNum_station(),Grigny_la_grande_borne2.getNum_station(),Pantheon.getNum_station(),Pantheon.getNum_station(),Grigny.getNum_station(),
                Bastille.getNum_station(),Bercy.getNum_station(),Arc_de_Triomphe.getNum_station());
        var algorithme = new Algorithme();

        List<Integer> list =  Arrays.asList(La_Defense.getNum_station(),Pantheon.getNum_station());
        List result = algorithme.algorithmeSelonPoint(chatelet_les_halles,Arc_de_Triomphe,list, metro);

        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire passant par liste de point simple (2 points à l'opposée) nsens contraire")
    public void itinerairePassantPar2PointsOpposéesSensContraire(){

        Metro metro = new Metro();
        Station chatelet_les_halles = metro.getStations().get(0);
        Station Pigalle = metro.getStations().get(1);
        Station Montmartre = metro.getStations().get(2);
        Station Louvre = metro.getStations().get(3);
        Station Bercy =  metro.getStations().get(4);
        Station Arc_de_Triomphe = metro.getStations().get(5);
        Station La_Defense = metro.getStations().get(6);
        Station Invalides = metro.getStations().get(7);
        Station Louvre2 = metro.getStations().get(8);
        Station Billancourt = metro.getStations().get(9);
        Station Grigny = metro.getStations().get(10);
        Station Pantheon = metro.getStations().get(11);
        Station Montmartre2 = metro.getStations().get(14);
        Station Grigny_la_grande_borne2 = metro.getStations().get(15);
        Station Bastille = metro.getStations().get(16);
        List<Integer> trajet =  Arrays.asList(Arc_de_Triomphe.getNum_station(),Bercy.getNum_station(),Bastille.getNum_station(),Grigny.getNum_station(),Pantheon.getNum_station(),Pantheon.getNum_station(),Grigny.getNum_station(),Billancourt.getNum_station(), Louvre2.getNum_station(),Invalides.getNum_station(),La_Defense.getNum_station(),Invalides.getNum_station(),Louvre2.getNum_station(),Montmartre.getNum_station(),Pigalle.getNum_station(), chatelet_les_halles.getNum_station());
        var ln= new Metro();

        List<Integer> list =  Arrays.asList(Pantheon.getNum_station(),La_Defense.getNum_station());
        Algorithme algorithme = new Algorithme();
        var result = algorithme.algorithmeSelonPoint(Arc_de_Triomphe,chatelet_les_halles,list, metro);

        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire le plus rapide station arrivee et depart different")
    public void itineraireRapideStationArriveeEtDepartDiff(){

        Metro metro = new Metro();
        Station Bercy =  metro.getStations().get(4);
        Station Arc_de_Triomphe = metro.getStations().get(5);

        List<Integer> list = Arrays.asList(Arc_de_Triomphe.getNum_station(), Bercy.getNum_station());
        Algorithme algorithme = new Algorithme();
        assertThatThrownBy(()-> algorithme.algorithmeSelonPoint(Arc_de_Triomphe, Arc_de_Triomphe,list, metro)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("itineraire le plus rapide problème liason")
    public void itineraireRapideSimpleProblemeLiason(){
        Metro metro = new Metro();
        metro.getStations().get(0).getLiaison_after().setProbleme(true);
        Station chatelet_les_halles = metro.getStations().get(0);
        Station Pigalle = metro.getStations().get(1);
        Station Bercy =  metro.getStations().get(4);
        Station Arc_de_Triomphe = metro.getStations().get(5);

        Algorithme ln= new Algorithme();
        List<Integer> list = Arrays.asList(Arc_de_Triomphe.getNum_station(), Bercy.getNum_station());
        var result = ln.algorithmeSelonPoint(chatelet_les_halles,Pigalle, list, metro);

        assertThat(result).isEqualTo(new ArrayList<Integer>());

    }

    @Test
    @DisplayName("itineraire le plus rapide simple problème Station")
    public void itineraireRapideSimpleStation(){
        Metro metro = new Metro();
        Station chatelet_les_halles = metro.getStations().get(0);
        metro.getStations().get(1).setProbleme(true);
        Station Montmartre = metro.getStations().get(2);
        Station Bercy =  metro.getStations().get(4);
        Station Arc_de_Triomphe = metro.getStations().get(5);

        Algorithme ln= new Algorithme();
        List<Integer> list = Arrays.asList(Arc_de_Triomphe.getNum_station(), Bercy.getNum_station());
        var result = ln.algorithmeSelonPoint(chatelet_les_halles,Montmartre, list,metro);

        assertThat(result).isEqualTo(new ArrayList<Integer>());

    }

}
