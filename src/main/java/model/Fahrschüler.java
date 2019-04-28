package model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Entity
@Table(name = "FAHRSCHÜLER")
public class Fahrschüler extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fahrschülerID;

    @Column(name = "PRÜFUNGVERSUCHE")
    private int versuche;

    @ManyToMany
    @JoinTable(name = "TheorieStunden",
            joinColumns = {@JoinColumn(name = "FahrschülerID")},
            inverseJoinColumns = {@JoinColumn(name = "FahrlehrerID")})
    private List<Fahrlehrer> fahrlehrers = new LinkedList<>();

    public Fahrschüler(String name, String vorname, Date geburtsdatum, int PLZ, String ort, String strasse, int hausnummer) {
        super(name, vorname, geburtsdatum, PLZ, ort, strasse, hausnummer);
        this.fahrschülerID = new AtomicInteger().getAndIncrement();
        this.versuche = 0;
    }

    public Fahrschüler() {
    }

    public void setVersuche(int versuche) {
        this.versuche = versuche;
    }

}
