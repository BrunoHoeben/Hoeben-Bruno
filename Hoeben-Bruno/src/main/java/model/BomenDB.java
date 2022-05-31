package model;

import model.Boom;

import java.util.ArrayList;

public class BomenDB {
    private final ArrayList<Boom> bomen = new ArrayList<>();
    ArrayList<Boom> soortGevonden = new ArrayList<>();
    ArrayList<Boom> familieGevonden = new ArrayList<>();
    private int ID = 0;

    public BomenDB(){
        add(new Boom("appelboom", "rozenfamilie", 8));
        add(new Boom("berk", "berkenfamilie", 5));
        add(new Boom("walnoot", "okkernootfamilie", 3));
        add(new Boom("eik", "napjesdragersfamilie", 2));
    }

    public void add(Boom boom){
        if (boom == null)
            throw new IllegalArgumentException("voer iets in");
        bomen.add(boom);
        boom.setID(ID);
        ID++;
    }

    public ArrayList getBomen(){
        return bomen;
    }

    public String meesteBomen(){
        int meeste = 0;
        String meesteBoom = "is geen boom omdat er geen in de lijst staan.";
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

    public ArrayList<Boom> zoekSoortBomen(String zoek){
        soortGevonden.clear();
        for (Boom boom:bomen){
            if (zoek.equals(boom.getSoortnaam())){
                soortGevonden.add(boom);
            }
        }
        return soortGevonden;
    }

    public ArrayList<Boom> zoekFamilieBomen(String zoek){
        familieGevonden.clear();
        for (Boom boom:bomen){
            if (zoek.equals(boom.getFamilienaam())){
                familieGevonden.add(boom);
            }
        }
        return familieGevonden;
    }

    public ArrayList<Boom> getSoortBomen(){
        return soortGevonden;
    }

    public ArrayList<Boom> getFamilieBomen(){
        return familieGevonden;
    }

    public Boom getBoom(int ID){
        for (Boom boom: bomen){
            if (boom.getID() == ID){
                return boom;
            }
        }
        return null;
    }

    public void verwijderBoom(int ID){
        for (Boom boom: bomen){
            if(boom.getID() == ID){
                bomen.remove(boom);
                break;
            }
        }
    }

}
