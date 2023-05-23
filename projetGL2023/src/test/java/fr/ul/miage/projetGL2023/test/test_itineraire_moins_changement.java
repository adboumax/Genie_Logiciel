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

public class test_itineraire_moins_changement {


    @Test
    @DisplayName("itineraire le moins de changement Station 1 vide")
    public void itineraireMoinsChangementStation1Vide(){
        Metro metro = new Metro();
        Station x =  null;
        Station y = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Algorithme trajet= new Algorithme();
        assertThatThrownBy(()-> trajet.algoMoinsChangement(x, y,metro)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("itineraire le moins changement Station 2 vide")
    public void itineraireMoinsChangementStation2Vide(){
        Station x = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station y =  null;
        Metro metro = new Metro();
        Algorithme trajet= new Algorithme();
        assertThatThrownBy(()-> trajet.algoMoinsChangement(x, y,metro)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("itineraire le moins changement les 2 stations vide")
    public void itineraireLeMoinsChangementles2stationVide(){
        Station x =  null;
        Station y =  null;
        Algorithme trajet= new Algorithme();
        Metro metro = new Metro();
        assertThatThrownBy(()-> trajet.algoMoinsChangement(x, y,metro)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("itineraire le moins de changement simple")
    public void itineraireRapideSimple(){
        Algorithme ln= new Algorithme();
        Metro metro = new Metro();
        Station chatelet_les_halles =  new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        List<Integer> trajet =  Arrays.asList(chatelet_les_halles.getNum_station(),Pigalle.getNum_station(),Montmartre.getNum_station(),Louvre.getNum_station(),Bercy.getNum_station(),Arc_de_Triomphe.getNum_station());

        var result = ln.algoMoinsChangement(chatelet_les_halles,Arc_de_Triomphe,metro);
        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire le moins de changement simple autre sens")
    public void itineraireRapideSimpleAutreSens(){
        Algorithme ln= new Algorithme();
        Metro metro = new Metro();
        Station chatelet_les_halles =  new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        List<Integer> trajet =  Arrays.asList(Arc_de_Triomphe.getNum_station(),Bercy.getNum_station(),Louvre.getNum_station(),Montmartre.getNum_station(),Pigalle.getNum_station(),chatelet_les_halles.getNum_station());

        var result = ln.algoMoinsChangement(Arc_de_Triomphe,chatelet_les_halles,metro);
        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire le moins de changement sans correspondance")
    public void itineraireLeMoinsDeChangementSansCorrespondance(){
        Algorithme ln= new Algorithme();
        Metro metro = new Metro();
        Station Musee_grevin = new Station("Musée grévin",3,12,false, new Liaison(90,false,13), null,30);
        Station Place_italie = new Station("Place d'italie",3,13,false,new Liaison(180,false,3), new Liaison(90,false,12),30);
        Station Montmartre2 = new Station("Montmartre",3,3,false,new Liaison(250,false,10), new Liaison(180,false,13),30);
        Station Grigny_la_grande_borne2 = new Station("Grigny-la-grande-borne",3,10,false,new Liaison(90,false,14), new Liaison(250,false,3),30);

        Station Bastille = new Station("Bastille",3,14,false,new Liaison(180,false,5), new Liaison(90,false,10),30);
        Station Bercy2 = new Station("Bercy",3,5,false,new Liaison(90,false,15), new Liaison(180,false,14),30);
        Station Champ_de_mars = new Station("Champ de mars",3,15,false,null, new Liaison(90,false,5),30);
        List<Integer> trajet =  Arrays.asList(Musee_grevin.getNum_station(),Place_italie.getNum_station(),Montmartre2.getNum_station(),Grigny_la_grande_borne2.getNum_station(),Bastille.getNum_station(),Bercy2.getNum_station(),Champ_de_mars.getNum_station());

        var result = ln.algoMoinsChangement(Musee_grevin,Champ_de_mars,metro);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire le moins de changement sans correspondance autre sens")
    public void itineraireLeMoinsDeChangementSansCorrespondanceAutreSens(){
        Station Musee_grevin = new Station("Musée grévin",3,12,false, new Liaison(90,false,13), null,30);
        Station Place_italie = new Station("Place d'italie",3,13,false,new Liaison(180,false,3), new Liaison(90,false,12),30);
        Station Montmartre2 = new Station("Montmartre",3,3,false,new Liaison(250,false,10), new Liaison(180,false,13),30);
        Station Grigny_la_grande_borne2 = new Station("Grigny-la-grande-borne",3,10,false,new Liaison(90,false,14), new Liaison(250,false,3),30);
        Station Bastille = new Station("Bastille",3,14,false,new Liaison(180,false,5), new Liaison(90,false,10),30);
        Station Bercy2 = new Station("Bercy",3,5,false,new Liaison(90,false,15), new Liaison(180,false,14),30);
        Station Champ_de_mars = new Station("Champ de mars",3,15,false,null, new Liaison(90,false,5),30);

        List<Integer> trajet =  Arrays.asList(Champ_de_mars.getNum_station(),Bercy2.getNum_station(),Bastille.getNum_station(),Grigny_la_grande_borne2.getNum_station(),Montmartre2.getNum_station(),Place_italie.getNum_station(),Musee_grevin.getNum_station());
        Algorithme ln= new Algorithme();
        Metro metro = new Metro();
        var result = ln.algoMoinsChangement(Champ_de_mars,Musee_grevin,metro);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire le moins de changement avec une correspondance")
    public void itineraireLeMoinsDeChangementAvecUneCorrespondance(){
        Station La_Defense = new Station("La Défense",2,7,false,new Liaison(60,false,8), null,30);
        Station Invalides = new Station("Invalides",2,8,false,new Liaison(210,false,4), new Liaison(60,false,7),30);
        Station Louvre2 = new Station("Louvre",2,4,false,new Liaison(30,false,9), new Liaison(210,false,8),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);


        List<Integer> trajet =  Arrays.asList(La_Defense.getNum_station(),Invalides.getNum_station(),Louvre2.getNum_station(),Bercy.getNum_station());
        Algorithme ln= new Algorithme();
        Metro metro = new Metro();
        var result = ln.algoMoinsChangement(La_Defense,Bercy,metro);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire le moins de changement avec une correspondance autre sens")
    public void itineraireLeMoinsDeChangementAvecUneCorrespondanceAutreSens(){
        Station La_Defense = new Station("La Défense",2,7,false,new Liaison(60,false,8), null,30);
        Station Invalides = new Station("Invalides",2,8,false,new Liaison(210,false,4), new Liaison(60,false,7),30);
        Station Louvre2 = new Station("Louvre",2,4,false,new Liaison(30,false,9), new Liaison(210,false,8),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);


        List<Integer> trajet =  Arrays.asList(Bercy.getNum_station(),Louvre2.getNum_station(),Invalides.getNum_station(),La_Defense.getNum_station());
        Algorithme ln= new Algorithme();
        Metro metro = new Metro();
        var result = ln.algoMoinsChangement(Bercy,La_Defense,metro);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire Moins changement station arrivee et depart different")
    public void itineraireMoinschangementStationArriveeEtDepartDiff(){
        Station x =new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        Station y =new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        Algorithme ln= new Algorithme();
        Metro metro = new Metro();
        assertThatThrownBy(()-> ln.algoMoinsChangement(x, y,metro)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("itineraire moins changement station depart pb")
    public void ItinerairemoinsDepartStationDepPb(){
        Station Arc_de_Triomphe =new Station("Arc de triomphe",1,6,true,null, new Liaison(120,false,5),30);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30);
        Algorithme ln= new Algorithme();
        Metro metro = new Metro();

        var result = ln.algoMoinsChangement(Arc_de_Triomphe,Bercy, metro);

        assertThat(result).isEqualTo(null);
    }

    @Test
    @DisplayName("itineraire moins changement station arrivé pb")
    public void ItinerairemoinschangementArriveePB(){
        Station Arc_de_Triomphe =new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30);
        Station Bercy = new Station("Bercy",1,5,true,new Liaison(120,false,6), new Liaison(150,false,4),30);
        Algorithme ln= new Algorithme();
        Metro metro = new Metro();

        var result = ln.algoMoinsChangement(Arc_de_Triomphe,Bercy, metro);

        assertThat(result).isEqualTo(null);
    }





}
