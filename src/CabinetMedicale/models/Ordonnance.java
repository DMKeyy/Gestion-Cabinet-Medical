package CabinetMedicale.models;

import java.time.LocalDate;

public class Ordonnance {
    private Patient patient;
    private String medicament;
    private String doses;
    LocalDate dateOrdonnance = LocalDate.now();

    public Ordonnance() {
    }
    

    


    public Ordonnance(Patient patient, String medicament, String doses) {
        this.patient = patient;
        this.medicament = medicament;
        this.doses = doses;
    }


    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public String getDoses() {
        return doses;
    }

    public void setDoses(String doses) {
        this.doses = doses;
    }


    @Override
    public String toString() {
        return "Ordonnance [patient=" + patient.getNom()+" "+patient.getPrenom() + ", medicament=" + medicament + ", doses=" + doses
                + ", dateOrdonnance=" + dateOrdonnance + "]";
    }


    
}
