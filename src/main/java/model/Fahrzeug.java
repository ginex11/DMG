package model;

import javax.persistence.*;

@Entity
@Table(name="FAHRZEUG")
public class Fahrzeug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public final String modell;
    public final String fahrzeugKlasse;
    public final String schaltung;
    public final String zulassung;
    public final String nummerSchild;


    public Fahrzeug(String modell, String fahrzeugKlasse, String schaltung, String zulassung, String nummerSchild) {
        this.modell = modell;
        this.fahrzeugKlasse = fahrzeugKlasse;
        this.schaltung = schaltung;
        this.zulassung = zulassung;
        this.nummerSchild = nummerSchild;
    }

    public String getZulassung() {
        return zulassung;
    }

    public String getNummerSchild() {
        return nummerSchild;
    }

    public String getFahrzeugKlasse() {
        return fahrzeugKlasse;
    }

    @Override
    public String toString() {
        return "Fahrzeug{" +
                "zulassung='" + zulassung + '\'' +
                ", nummerSchild='" + nummerSchild + '\'' +
                ", fahrzeugKlasse='" + fahrzeugKlasse + '\'' +
                '}';
    }
}
