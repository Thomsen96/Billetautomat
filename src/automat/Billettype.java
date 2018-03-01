package automat;

    public class Billettype {
        private double pris;    
        private String navn;
        
        
        public double getBilletpris() {
            return pris;
        }
        
        public String getNavn(){
            return navn;
        }
        
        public void PrintBillet(int antal){
            for(int i = 0; i < antal; i++) {
                System.out.println("PRINT BILLETER??");
            }
        }
    }

