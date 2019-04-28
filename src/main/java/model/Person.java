package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@MappedSuperclass
public class Person {

    @Column(name = "NAME")
    public String Name;

    @Column(name = "VORNAME")
    public String Vorname;

    @Column(name = "GEBURTSDATUM")
    Date Geburtsdatum;

    @Column(name = "PLZ")
    int PLZ;

    @Column(name = "ORT")
    String Ort;

    @Column(name = "STRASSE")
    String Strasse;

    @Column(name = "HAUSNUMMER")
    int Hausnummer;

    public Person() {

    }

    public Person(String name, String vorname, Date geburtsdatum, int PLZ, String ort, String strasse, int hausnummer) {

        Name = name;
        Vorname = vorname;
        Geburtsdatum = geburtsdatum;
        this.PLZ = PLZ;
        Ort = ort;
        Strasse = strasse;
        Hausnummer = hausnummer;
    }


    public String getName() {
        return Name;
    }

    public String getVorname() {
        return Vorname;
    }

    public Date getGeburtsdatum() {
        return Geburtsdatum;
    }

    public int getPLZ() {
        return PLZ;
    }

    public String getOrt() {
        return Ort;
    }

    public String getStrasse() {
        return Strasse;
    }

    public int getHausnummer() {
        return Hausnummer;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        Geburtsdatum = geburtsdatum;
    }

    public void setPLZ(int PLZ) {
        this.PLZ = PLZ;
    }

    public void setOrt(String ort) {
        Ort = ort;
    }

    public void setStrasse(String strasse) {
        Strasse = strasse;
    }

    public void setHausnummer(int hausnummer) {
        Hausnummer = hausnummer;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", Vorname='" + Vorname + '\'' +
                ", Geburtsdatum=" + Geburtsdatum +
                ", PLZ=" + PLZ +
                ", Ort='" + Ort + '\'' +
                ", Strasse='" + Strasse + '\'' +
                ", Hausnummer=" + Hausnummer +
                '}';
    }

}
