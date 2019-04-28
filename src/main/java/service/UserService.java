package service;

import model.Fahrlehrer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {

    final static Map<Integer, Fahrlehrer> lehrer = new ConcurrentHashMap<>();

    final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    static {
        Date date = null;
        try {
            date = simpleDateFormat.parse("2018-09-09");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lehrer.put(1, new Fahrlehrer("Hendricks", "Richard", new Date(), 23564,
                "Lübeck", "Sandkrugskoppel", 11, "A1", "B2"));
        lehrer.put(2, new Fahrlehrer("Dunn", "Jared", new Date(), 23564,
                "Lübeck", "Sandkrugskoppel", 11, "A1", "B2"));
        lehrer.put(3, new Fahrlehrer("Gilfoyle", "Bertram", new Date(), 23564,
                "Lübeck", "Sandkrugskoppel", 11, "A1", "CE"));
        lehrer.put(4, new Fahrlehrer("Chugtai", "Dinesh", date, 23564,
                "Lübeck", "Sandkrugskoppel", 11, "A1", "B1"));
        lehrer.put(5, new Fahrlehrer("Hall", "Monica", new Date(), 23564,
                "Lübeck", "Sandkrugskoppel", 11, "C1", "B2"));
    }


    public static Map<Integer, Fahrlehrer> queryAllUsers() {
        return lehrer;
    }
}
