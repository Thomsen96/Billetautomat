package automat;

    public class Billettype {
        private double pris;    
        private int zoner;
        
        public Billettype(double inPris, int inZoner) {
            pris = inPris;
            zoner = inZoner;
        }
        
        public void setBilletpris(double nyPris) {
            pris = nyPris;
        }
        
        public void setZoner(int nyZoner) {
            zoner = nyZoner;
        }       
        
        public double getBilletpris() {
            return pris;
        }
        
        public int getZoner(){
            return zoner;
        }
        
        public void PrintBillet(int antal){
            for(int i = 0; i < antal; i++) {
                System.out.println("PRINT BILLETER??");
            }
        }
    }

