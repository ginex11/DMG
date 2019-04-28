package model;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "FAHRLEHRLER")
public class Fahrlehrer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int FahrlehrerID;

    @ElementCollection
    List<String> fahrzeugklassen = new LinkedList<>();

    @ManyToMany
    @JoinTable(name = "TheorieStunden",
            joinColumns = {@JoinColumn(name = "FahrlehrerID")},
            inverseJoinColumns = {@JoinColumn(name = "FahrschülerID")})

    private List<Fahrschüler> fahrschülers = new LinkedList<>();

    public Fahrlehrer() {
    }

    public Fahrlehrer(String name, String vorname, Date geburtsdatum, int PLZ, String ort, String strasse, int hausnummer, String... fzk) {
        super(name, vorname, geburtsdatum, PLZ, ort, strasse, hausnummer);
        this.FahrlehrerID = new AtomicInteger().getAndIncrement();
        for (String s : fzk) {
            fahrzeugklassen.add(s);
        }
    }

    public int getFahrlehrerID() {
        return FahrlehrerID;
    }

    public void setFahrlehrerID(int fahrlehrerID) {
        FahrlehrerID = fahrlehrerID;
    }

    public void addFahrschüler(Fahrschüler fahrschüler) {
        fahrschülers.add(fahrschüler);
    }
}
