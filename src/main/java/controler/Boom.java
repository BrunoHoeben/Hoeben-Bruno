package controler;

public class Boom {
    private String soortnaam;
    private String familienaam;
    private int aantal;

    public Boom(String soortnaam, String familienaam, int aantal){
        if (soortnaam == null || soortnaam.isEmpty()){
            throw new IllegalArgumentException("soortnaam mag niet leeg zijn");
        }
        if (familienaam == null || familienaam.isEmpty()) {
            throw new IllegalArgumentException("familienaam mag niet leeg zijn");
        }
        if (aantal == 0){
            throw new IllegalArgumentException("aantal mag niet 0 zijn");
        }
        setSoortnaam(soortnaam);
        setFamilienaam(familienaam);
        setAantal(aantal);
    }

    public String toString(){
        return "<ul><li>" + soortnaam + "</li><li>" + familienaam + "</li><li>" + aantal + "</li><li>pas aan</li><li>x</li></ul>\n";
    }

    public String getSoortnaam() {
        return soortnaam;
    }

    public void setSoortnaam(String soortnaam) {
        this.soortnaam = soortnaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }
}
