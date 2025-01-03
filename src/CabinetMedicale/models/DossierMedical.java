package CabinetMedicale.models;

import java.util.ArrayList;
import CabinetMedicale.Colors;

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


    public void AfficherDossierMedical() {
        System.out.println(Colors.BLUE + "--------------------Dossier Medical----------------------" + Colors.RESET);
        System.out.println(Colors.BLUE + "Nom et prenom : " + Colors.RESET + this.patient.getNom() + " " + this.patient.getPrenom());
        System.out.println(Colors.BLUE + "Numero de dossier : " + Colors.RESET + this.patient.getNumeroDossier());
        System.out.println(Colors.BLUE + "--------------------Consultations---------------------" + Colors.RESET);
        System.out.println(Colors.BLUE + "Nombre de consultations : " + Colors.RESET + this.consultations.size());
        for (consultation consultation : consultations) {
            consultation.AfficherConsultation();
        }
        System.out.println(Colors.BLUE + "--------------------------------------------------------" + Colors.RESET);
    }

    
}
