package automat;

import java.util.Date;

/* En klasse der bruges til at gemme data om handel */
public class Transaktioner {

    /**
     * Den transarktions tekst der bilver lavet.
     */
    private double beløb;
    private Date udDato;
    private int gyldighed;
    private String fra;
    private String til;
    private int zoneStart;
    private int zoneAntal;
    private int billetType;  //1: Voksen, 2: Barn, 3: To voksne, 4: To børn, 5: Voksen og barn
    private int ID;
    private boolean retur;
    
    

    public Transaktioner(double beløb, int gyldighed, String fra, String til, int zoneStart, int zoneAntal, int billetType, boolean retur ) {
        udDato          = new Date();
        this.gyldighed  = gyldighed;
        this.beløb      = beløb;
        this.fra        = fra;
        this.til        = til;
        this.zoneStart  = zoneStart;
        this.zoneAntal  = zoneAntal;
        this.billetType = billetType;
        double random = Math.random() * 400;
        ID              = (gyldighed + zoneStart + zoneAntal + billetType) * (int)random ;
        this.retur      = retur;
    }
    
}
