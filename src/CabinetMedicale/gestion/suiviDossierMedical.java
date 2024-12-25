package CabinetMedicale.gestion;

import java.util.ArrayList;

import CabinetMedicale.models.Patient;
import CabinetMedicale.models.consultation;

public class suiviDossierMedical {
    private Patient patient;
    private ArrayList<consultation> consultations;


    public suiviDossierMedical(Patient patient, ArrayList<consultation> consultations) {
        this.patient = patient;
        this.consultations = consultations;
    }


    public Patient getPatient() {
        return patient;
    }


    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    public ArrayList<consultation> getConsultations() {
        return consultations;
    }


    public void setConsultations(ArrayList<consultation> consultations) {
        this.consultations = consultations;
    }


    @Override
    public String toString() {
        return "suiviDossierMedical [patient=" + patient + ", consultations=" + consultations + "]";
    }

    public void ajouterConsultation (consultation Consultation){
        this.consultations.add(Consultation);
        }

    public void AfficherDossierMedical (){
        for (consultation Consultation : consultations) {
            System.out.println(Consultation.toString());
        }
    }
    

    
}
