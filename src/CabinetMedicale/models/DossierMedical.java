package CabinetMedicale.models;

import java.util.ArrayList;

public class DossierMedical {
    
    private Patient patient;
    private ArrayList<consultation> consultations;

    

    public DossierMedical(Patient patient) {
        this.patient = patient;
        this.consultations = new ArrayList<consultation>();
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
        return "DossierMedical [ patient : " + patient.getNom() +" "+ patient.getPrenom() + " ]\n"+" consultations : " + consultations ;
    }


    public void ajouterConsultation (consultation Consultation){
        this.consultations.add(Consultation);
        }

    public void AfficherDossierMedical (){
        System.out.println(toString());
    }

    
}
