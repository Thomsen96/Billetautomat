package automat;
    
/**
 * Denne klasse er en objekt klasse der oprettes billeter udfra.
 */
    public class Billettype {
        private String type;
        private double pris;    
        
        /**
         * Konstuktøren tager:
         * @param inType Billetnavn
         * @param inPris Billetpris
         */
        public Billettype(String inType, double inPris) {
            type = inType;
            pris = inPris;
        }
        
        /**
         * Opdatere Billetprisen
         * @param nyPris 
         */
        public void setBilletpris(double nyPris) {
            pris = nyPris;
        }
        
        /**
         * Opdatere Billetnavnet
         * @param nyType 
         */
        public void setType(String nyType) {
            type = nyType;
        }       
        
        /**
         * Giver Billetprisen
         * @return Billetprisen
         */
        public double getBilletpris() {
            return pris;
        }
        
        /**
         * Returnere billetnavnet.
         * @return Billetnavnet
         */
        public String getType(){
            return type;
        }
}
