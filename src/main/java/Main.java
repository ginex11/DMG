import HibernateUtil.HibernateUtil;
import com.sun.net.httpserver.HttpServer;
import model.Fahrlehrer;
import model.Fahrschüler;
import model.Person;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.net.URI;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        /*ResourceConfig rc = new ResourceConfig().packages("resources", "filter");
        HttpServer server = JdkHttpServerFactory.createHttpServer(URI.create("http://localhost:8080/"), rc);

        System.out.println("Hit enter to stop HTTP server.");
        System.in.read();
        server.stop(0);*/

        Session session = HibernateUtil.getSessionFactory().openSession();
        Fahrschüler fahrschüler = new Fahrschüler("Hendricks", "Richard", new Date(), 23564,
                "Lübeck", "Sandkrugskoppel", 11);
        Fahrschüler fahrschüler2 = new Fahrschüler("Hendricks", "Richard", new Date(), 23564,
                "Lübeck", "Sandkrugskoppel", 11);
        Fahrschüler fahrschüler3 = new Fahrschüler("Hendricks", "Richard", new Date(), 23564,
                "Lübeck", "Sandkrugskoppel", 11);
        Fahrlehrer fahrlehrer1 = new Fahrlehrer("Gilfoyle", "Bertram", new Date(), 23564,
                "Lübeck", "Sandkrugskoppel", 11, "A1", "CE");
        Fahrlehrer fahrlehrer2 = new Fahrlehrer("Gilf", "Bert", new Date(), 23564,
                "Lübeck", "Sandkrugskoppel", 11, "A1", "CE","B");

        fahrlehrer1.addFahrschüler(fahrschüler);
        fahrlehrer1.addFahrschüler(fahrschüler2);
        fahrlehrer2.addFahrschüler(fahrschüler3);
        fahrlehrer2.addFahrschüler(fahrschüler);
        fahrschüler3.addFahrlehrer(fahrlehrer2);

        try {
            session.beginTransaction();
            System.out.println("speichern");
            session.save(fahrlehrer1);
            session.save(fahrlehrer2);
            session.save(fahrschüler);
            session.save(fahrschüler2);
            session.save(fahrschüler3);
            session.getTransaction().commit();
            System.out.println("Fertig");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

}
