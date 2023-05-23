package fr.ul.miage.projetGL2023.test;

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
        Station x =  null;
        Station y = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30,0.0,0.0);
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itiniraire_moins_changement(x, y)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("itineraire le moins changement Station 2 vide")
    public void itineraireMoinsChangementStation2Vide(){
        Station x = new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30,0.0,0.0);
        Station y =  null;
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itiniraire_moins_changement(x, y)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("itineraire le moins changement les 2 stations vide")
    public void itineraireLeMoinsChangementles2stationVide(){
        Station x =  null;
        Station y =  null;
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itiniraire_moins_changement(x, y)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("itineraire le moins de changement simple")
    public void itineraireRapideSimple(){
        Station chatelet_les_halles =  new Station("Chatelet les Halles",1,1,false, new Liaison(120,false,2), null,30,0.0,0.0);
        Station Arc_de_Triomphe = new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30,0.0,0.0);
        Station Pigalle = new Station("Pigalle",1,2,false,new Liaison(120,false,3), new Liaison(120,false,1),30,0.0,0.0);
        Station Montmartre = new Station("Montmartre",1,3,false,new Liaison(90,false,4), new Liaison(120,false,2),30,0.0,0.0);
        Station Louvre = new Station("Louvre",1,4,false,new Liaison(150,false,5), new Liaison(90,false,3),30,0.0,0.0);
        Station Bercy = new Station("Bercy",1,5,false,new Liaison(120,false,6), new Liaison(150,false,4),30,0.0,0.0);

        List<Integer> trajet =  Arrays.asList(chatelet_les_halles.getNum_station(),Pigalle.getNum_station(),Montmartre.getNum_station(),Louvre.getNum_station(),Bercy.getNum_station(),Arc_de_Triomphe.getNum_station());
        var ln= new Metro();
        var result = ln.Itiniraire_moins_changement(chatelet_les_halles,Arc_de_Triomphe);
        assertThat(result).isEqualTo(trajet);

    }
    @Test
    @DisplayName("itineraire le moins de changement sans correspondance")
    public void itineraireLeMoinsDeChangementSansCorrespondance(){

        Station Musee_grevin = new Station("Musée grévin",3,13,false,null,
                new Liaison(30,false,1),90,0.0,0.0);
        Station Place_italie = new Station("Place d'italie",3,14,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90,0.0,0.0);
        Station Montmartre2 = new Station("Montmartre",3,15,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90,0.0,0.0);
        Station Grigny_la_grande_borne2 = new Station("Grigny-la-grande-borne",3,16,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90,0.0,0.0);
        Station Bastille = new Station("Bastille",3,14,false,new Liaison(180,false,5), new Liaison(90,false,10),30,0.0,0.0);

        Station Bercy2 = new Station("Bercy",3,17,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90,0.0,0.0);
        Station Champ_de_mars = new Station("Champ de mars",3,18,false,new Liaison(30,false,1),
                new Liaison(30,false,1),90,0.0,0.0);
        List<Integer> trajet =  Arrays.asList(Musee_grevin.getNum_station(),Place_italie.getNum_station(),Montmartre2.getNum_station(),Grigny_la_grande_borne2.getNum_station(),Bastille.getNum_station(),Bercy2.getNum_station(),Champ_de_mars.getNum_station());
        var ln= new Metro();
        var result = ln.Itiniraire_moins_changement(Musee_grevin,Champ_de_mars);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire le moins de changement sans correspondance autre sens")
    public void itineraireLeMoinsDeChangementSansCorrespondanceAutreSens(){

        Station Musee_grevin = new Station("Musée grévin",3,12,false, new Liaison(90,false,14), null,30,0.0,0.0);
        Station Place_italie = new Station("Place d'italie",3,13,false,new Liaison(180,false,3), new Liaison(90,false,12),30,0.0,0.0);
        Station Montmartre2 = new Station("Montmartre",3,3,false,new Liaison(250,false,10), new Liaison(180,false,13),30,0.0,0.0);
        Station Grigny_la_grande_borne2 = new Station("Grigny-la-grande-borne",3,10,false,new Liaison(90,false,14), new Liaison(250,false,3),30,0.0,0.0);
        Station Bastille = new Station("Bastille",3,14,false,new Liaison(180,false,5), new Liaison(90,false,10),30,0.0,0.0);
        Station Bercy2 = new Station("Bercy",3,5,false,new Liaison(90,false,15), new Liaison(180,false,14),30,0.0,0.0);
        Station Champ_de_mars = new Station("Champ de mars",3,15,false,null, new Liaison(90,false,5),30,0.0,0.0);

        List<Integer> trajet =  Arrays.asList(Musee_grevin.getNum_station(),Place_italie.getNum_station(),Montmartre2.getNum_station(),Grigny_la_grande_borne2.getNum_station(),Bastille.getNum_station(),Bercy2.getNum_station(),Champ_de_mars.getNum_station());
        var ln= new Metro();
        var result = ln.Itiniraire_moins_changement(Champ_de_mars,Musee_grevin);
        assertThat(result).isEqualTo(trajet);
    }
    @Test
    @DisplayName("itineraire le plus rapide station arrivee et depart different")
    public void itineraireRapideStationArriveeEtDepartDiff(){
        Station x =new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30,0.0,0.0);
        Station y =new Station("Arc de triomphe",1,6,false,null, new Liaison(120,false,5),30,0.0,0.0);
        var trajet= new Metro();
        assertThatThrownBy(()-> trajet.Itiniraire_moins_changement(x, y)).isExactlyInstanceOf(IllegalArgumentException.class);
    }





}
