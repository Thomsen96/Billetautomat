package automat;

public class Kurv {
    private final String type;
    private final int zoner;
    private final double pris;

    public Kurv(String inType, int inZoner, double inPris){
        this.type = inType;
        this.zoner = inZoner;
        this.pris = inPris;
        
    }
    
    public String getType() {
        return type;
    }
    public int getZoner() {
        return zoner;
    }
    public double getPris() {
        return pris;
    }
}


