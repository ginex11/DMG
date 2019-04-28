import DAO_Controller.F_schüler;
import model.Fahrlehrer;
import model.Fahrschüler;
import model.Fahrzeug;


import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        /*ResourceConfig rc = new ResourceConfig().packages("resources", "filter");
        HttpServer server = JdkHttpServerFactory.createHttpServer(URI.create("http://localhost:8080/"), rc);

        System.out.println("Hit enter to stop HTTP server.");
        System.in.read();
        server.stop(0);*/


        Fahrschüler fahrschüler = new Fahrschüler("Hendricks", "Richard", new Date(), 23564,
                "Lübeck", "Sandkrugskoppel", 11);
        Fahrschüler fahrschüler2 = new Fahrschüler("Hendricks", "Richard", new Date(), 23564,
                "Lübeck", "Sandkrugskoppel", 11);
        Fahrschüler fahrschüler3 = new Fahrschüler("Hendricks", "Richard", new Date(), 23564,
                "Lübeck", "Sandkrugskoppel", 11);
        Fahrlehrer fahrlehrer1 = new Fahrlehrer("Gilfoyle", "Bertram", new Date(), 23564,
                "Lübeck", "Sandkrugskoppel", 11, "A1", "CE");
        Fahrlehrer fahrlehrer2 = new Fahrlehrer("Gilf", "Bert", new Date(), 23564,
                "Lübeck", "Sandkrugskoppel", 11, "A1", "CE", "B");

        fahrlehrer1.addFahrschüler(fahrschüler);
        fahrlehrer1.addFahrschüler(fahrschüler2);
        fahrlehrer2.addFahrschüler(fahrschüler3);
        fahrlehrer2.addFahrschüler(fahrschüler);

        Fahrzeug auto = new Fahrzeug("VW", "B1", "Automatik", "12.12.2000", "RZ66KM");
        F_schüler fschüler = new F_schüler();
        fschüler.save(fahrschüler);
    }

}
