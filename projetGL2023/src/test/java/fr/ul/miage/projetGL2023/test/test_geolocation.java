package fr.ul.miage.projetGL2023.test;

import fr.ul.miage.projetGL2023.algorithme.Algorithme;
import fr.ul.miage.projetGL2023.model.Liaison;
import fr.ul.miage.projetGL2023.model.Metro;
import fr.ul.miage.projetGL2023.model.Station;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class test_geolocation {

    @Test
    @DisplayName("Geolocation")
    public void testGeolocation()
    {
        Metro metro = new Metro();
        List<Station> stationProche = metro.trouveStationsPlusProche(1, 2);

        assertThat(stationProche.stream().map(Station::getNum_station).toList())
                .isEqualTo(List.of(metro.getStations().get(6).getNum_station(),
                        metro.getStations().get(7).getNum_station()));
    }

}
