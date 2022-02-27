package controler;

import controler.Boom;

import java.util.ArrayList;
import java.util.List;

public class Bomen {
    private int sequence = 0;
    private final List<Boom> bomen = new ArrayList<>();

    public Bomen(){
        bomen.add(new Boom("appelboom", "rozenfamilie", 10));
    }

    public void add(Boom boom){
        if (boom == null)
            throw new IllegalArgumentException("voer iets in");
        bomen.add(boom);
    }

    public String bomenToString(){
        StringBuffer sb = new StringBuffer();
        for (Boom b: bomen){
            sb.append(b.toString());
        }
        return sb.toString();
    }
}
