package CabinetMedicale.models;
import java.time.LocalDate;

public class consultation {
    private String Compterendu ;
    private LocalDate Date= LocalDate.now();
    private String etatpatient;
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


    public LocalDate getDate() {
        return Date;
    }


    public void setDate(LocalDate date) {
        Date = date;
    }


    public String getEtatpatient() {
        return etatpatient;
    }


    public void setEtatpatient(String etatpatient) {
        this.etatpatient = etatpatient;
    }


    @Override
    public String toString() {
        return "consultation [Compterendu=" + Compterendu + ", Date=" + Date + ", etatpatient=" + etatpatient
                + " ]\r" + ordonnance ;
    }

    
}
