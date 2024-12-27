package CabinetMedicale.models;

public class consultation {
    private String Compterendu ;
    private Ordonnance ordonnance;


    
    public consultation() {
    }


    public consultation(String compterendu, Ordonnance ordonnance) {
        Compterendu = compterendu;
        this.ordonnance = ordonnance;
    }


    public String getCompterendu() {
        return Compterendu;
    }


    public void setCompterendu(String compterendu) {
        Compterendu = compterendu;
    }


    public Ordonnance getOrdonnance() {
        return ordonnance;
    }


    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }


    @Override
    public String toString() {
        return "[Compterendu=" + Compterendu + ", ordonnance=" + ordonnance + "]";
    }

    
}
