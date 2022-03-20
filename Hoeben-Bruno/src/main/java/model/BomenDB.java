package model;

import model.Boom;

import java.util.ArrayList;

public class BomenDB {
    private final ArrayList<Boom> bomen = new ArrayList<>();

    public BomenDB(){
        bomen.add(new Boom("appelboom", "rozenfamilie", 8));
        bomen.add(new Boom("berk", "berkenfamilie", 5));
        bomen.add(new Boom("walnoot", "okkernootfamilie", 3));
        bomen.add(new Boom("eik", "napjesdragersfamilie", 2));
    }

    public void add(Boom boom){
        if (boom == null)
            throw new IllegalArgumentException("voer iets in");
        bomen.add(boom);
    }

    public ArrayList getBomen(){
        return bomen;
    }

    public String meesteBomen(){
        int meeste = 0;
        String meesteBoom = "";
        String eersteBoom = "";
        boolean alTweede = false;
        for (Boom boom:bomen){
            if (boom.getAantal() > meeste){
                meeste = boom.getAantal();
                meesteBoom = "is de " + boom.getSoortnaam();
                eersteBoom = boom.getSoortnaam();
                alTweede = false;
            }
            else if (boom.getAantal() == meeste && !alTweede){
                meesteBoom = "zijn de " + eersteBoom + " en de " + boom.getSoortnaam();
                alTweede = true;
            }
            else if (boom.getAantal() == meeste && alTweede){
                meesteBoom = meesteBoom + " en de " + boom.getSoortnaam();
            }
        }
        return meesteBoom;
    }

}
