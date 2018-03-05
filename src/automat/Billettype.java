package automat;

    public class Billettype {
        private String type;
        private double pris;    

        public Billettype(String inType, double inPris) {
            type = inType;
            pris = inPris;
        }
        
        public void setBilletpris(double nyPris) {
            pris = nyPris;
        }
        
        public void setType(String nyType) {
            type = nyType;
        }       
        
        public double getBilletpris() {
            return pris;
        }
        
        public String getType(){
            return type;
        }
        
        public void PrintBilletpris(){
            System.out.println(type + " koster " + pris + " kroner.");
        }
}
