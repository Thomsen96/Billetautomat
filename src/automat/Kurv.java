package automat;

public class Kurv {
    private final int antalBilleter;
    private final String type;
    private final int zoner;
    private final double pris;
    private final int index;
    
    /**
     * Constructor
     * @param inAntal - Antal billeter
     * @param inType - Sting for navn
     * @param inZoner - 
     * @param inPris
     * @param inIndex 
     */
    public Kurv(int inAntal, String inType, int inZoner, double inPris, int inIndex){
        this.antalBilleter = inAntal;
        this.type = inType;
        this.zoner = inZoner;
        this.pris = inPris;
        this.index = inIndex;
    }
    
    /**
     * finder antal billeter
     * @return  - antal billeter
     */
    public int getAntalBilleter() {
        return antalBilleter;
    }
    
    /**
     * 
     * @return billet navnet
     */
    public String getType() {
        return type;
    }
    
    /**
     * 
     * @return Antal zoner
     */
    public int getZoner() {
        return zoner;
    }
    
    /**
     * 
     * @return Prisen for den specifikke billet
     */
    public double getPris() {
        return pris;
    }
    
    /**
     * 
     * @return In
     */
    public int getIndex() {
        return index;
    }
}


