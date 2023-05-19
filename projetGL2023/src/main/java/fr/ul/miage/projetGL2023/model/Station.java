package fr.ul.miage.projetGL2023.model;


public class Station implements Comparable<Station>{

        public Station(String name, int ligne, int num_station, boolean probleme,
                       Liaison liaison_after, Liaison liaison_before, int temps) {
            setNom(name);
            setLigne(ligne);
            setLigne(ligne);
            setNum_station(num_station);
            setProbleme(probleme);
            setLiaison_after(liaison_after);
            setLiaison_before(liaison_before);
            setTemps(temps);
        }

        public String nom;
        public int ligne;
        public int num_station;
        public boolean probleme;
        public Liaison liaison_after;
        public Liaison liaison_before;
        public int temps;
        public double f;



        public String toString() {
            return nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public int getLigne() {
            return ligne;
        }

        public void setLigne(int ligne) {
            this.ligne = ligne;
        }

        public int getNum_station() {
            return num_station;
        }

        public void setNum_station(int num_station) {
            this.num_station = num_station;
        }

        public boolean isProbleme() {
            return probleme;
        }

        public void setProbleme(boolean probleme) {
            this.probleme = probleme;
        }

        public Liaison getLiaison_after() {
            return liaison_after;
        }

        public void setLiaison_after(Liaison liaison_after) {
            this.liaison_after = liaison_after;
        }

        public Liaison getLiaison_before() {
            return liaison_before;
        }

        public void setLiaison_before(Liaison liaison_before) {
            this.liaison_before = liaison_before;
        }

        public int getTemps() {
            return temps;
        }

        @Override
        public int compareTo(Station autre) {
            return Double.compare(this.f, autre.f);
        }

        public void setTemps(int temps) {
            this.temps = temps;
        }
        public void setF(double f) {
            this.f = f;
        }
}