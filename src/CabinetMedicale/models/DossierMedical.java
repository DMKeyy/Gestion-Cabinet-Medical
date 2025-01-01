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


    public void ajouterConsultation (consultation Consultation){
        this.consultations.add(Consultation);
        }


        
    public void AfficherDossierMedical (){
        System.out.println("--------------------Dossier Medical----------------------");
        System.out.println("Nom et prenom : "+this.patient.getNom()+" "+this.patient.getPrenom());
        System.out.println("Numero de dossier : "+this.patient.getNumeroDossier());
        System.out.println("--------------------Consultations---------------------");
        System.out.println("Nombre de consultations : "+this.consultations.size());
        for (consultation consultation : consultations) {
            consultation.AfficherConsultation();
            
        }
        System.out.println("--------------------------------------------------------");
    }

    
}
