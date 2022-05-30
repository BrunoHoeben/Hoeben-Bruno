package model;

public class Boom {
    private int ID;
    private String soortnaam;
    private String familienaam;
    private int aantal = 1;

    public Boom(String soortnaam, String familienaam, int aantal){
        setSoortnaam(soortnaam);
        setFamilienaam(familienaam);
        setAantal(aantal);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getSoortnaam() {
        return soortnaam;
    }

    public void setSoortnaam(String soortnaam) {
        if (soortnaam == null || soortnaam.isEmpty()){
            throw new IllegalArgumentException("soortnaam mag niet leeg zijn");
        }
        this.soortnaam = soortnaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        if (familienaam == null || familienaam.isEmpty()) {
            throw new IllegalArgumentException("familienaam mag niet leeg zijn");
        }
        this.familienaam = familienaam;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        if (aantal <= 0){
            throw new IllegalArgumentException("aantal bomen mag niet kleiner dan 0 zijn");
        }
        this.aantal = aantal;
    }
}
