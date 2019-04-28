package model;

import javax.persistence.*;

@Entity
@Table(name = "FAHRZEUG")
public class Fahrzeug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "MODELL")
    public final String modell;

    @Column(name = "FAHRZEUGKLASSE")
    public final String fahrzeugKlasse;

    @Column(name = "GETRIEBE")
    public final String schaltung;

    @Column(name = "ZULASSUNG")
    public final String zulassung;

    @Column(name = "NUMMERSCHILD")
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
