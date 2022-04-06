import java.io.*;
import java.util.*;

public class CovidCases {
    public static final String country = "Poland";
    ArrayList<Stat> stats = new ArrayList<Stat>();

    public CovidCases() throws Exception{
        Scanner s = new Scanner(new File("CovidData.csv"));

        while (s.hasNext()) {
            Stat nxt = new Stat(s.next());
        }
    }

}

class Stat {
    String country;
    String date;
    int confirmed;
    int deaths;
    int activeCases;
    double deathRate;
    double increase;
    String firstDays;
    int dayXth;
    int populationks;
    String tenCase;
    double cases1000s;

    public Stat(String row) {
        String[] elements = row.split(",");
        country = elements[0];
        date = elements[1];
        confirmed = Integer.parseInt(elements[2]);
    }
}