package automat;

public class Kurv {
    private final int antalBilleter;
    private final String type;
    private final int zoner;
    private final double pris;
    private final int index;
    

    public Kurv(int inAntal, String inType, int inZoner, double inPris, int inIndex){
        this.antalBilleter = inAntal;
        this.type = inType;
        this.zoner = inZoner;
        this.pris = inPris;
        this.index = inIndex;
        
        
    }
    
    public int getAntalBilleter() {
        return antalBilleter;
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
    public int getIndex() {
        return index;
    }
}


