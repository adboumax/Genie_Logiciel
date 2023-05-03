package fr.ul.miage.projetGL2023;


public class Liaison {

    public Liaison(int temps, boolean probleme, int num_station)
    {
        setTemps(temps);
        setProbleme(probleme);
        setNumero_ligne(num_station);
    }

    public int temps;
    public boolean probleme;
    public int num_station;

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public boolean isProbleme() {
        return probleme;
    }

    public void setProbleme(boolean probleme) {
        this.probleme = probleme;
    }

    public int getNumero_ligne() {
        return num_station;
    }

    public void setNumero_ligne(int numero_ligne) {
        this.num_station = numero_ligne;
    }
}