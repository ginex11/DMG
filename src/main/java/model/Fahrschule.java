package model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
public class Fahrschule {
    List<Fahrlehrer> Lehrer = new LinkedList<>();
    List<Fahrschüler> Schüler = new LinkedList<>();
    List<Fahrzeug> Flotte = new LinkedList<>();


}
