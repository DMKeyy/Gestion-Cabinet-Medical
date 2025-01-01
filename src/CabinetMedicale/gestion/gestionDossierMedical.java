package CabinetMedicale.gestion;


import java.util.Scanner;

import CabinetMedicale.models.DossierMedical;
import CabinetMedicale.models.Ordonnance;
import CabinetMedicale.models.Patient;
import CabinetMedicale.models.consultation;

public class gestionDossierMedical {
    Scanner sc = new Scanner(System.in);

    Patient patient;
    public void GestionDossierMedical (Patient patient){
        
        int choix;
        do{
        System.out.println("Gestion du dossier médical : (1-3)");
        System.out.println("1 . Ajouter une consultation");
        System.out.println("2 . Modifier une consultation");
        System.out.println("3 . Supprimer une consultation");
        System.out.println("3 . Afficher le dossier médical");
        System.out.println("4 . Retour");

        choix = 0;
        do {
            try {
                choix = sc.nextInt();
                sc.nextLine();
            if (choix < 1 && choix > 4) {

                System.out.println("Erreur: le nombre doit etre entre 1 et 4.");
            }
            } catch (Exception e) {
                System.out.println("Erreur: Veuiller entrer un entier.");
            }

        } while (choix < 1 && choix > 4);

        switch (choix) {
            case 1:
                AjouterConsultation(patient.getDossierMedical(),patient);
                break;
            case 2:
                ModifierConsultation(patient.getDossierMedical());
                break;
            case 3:
                SupprimerConsultation(patient.getDossierMedical());
            case 4:
                patient.getDossierMedical().AfficherDossierMedical();
                break;
            case 5:
                break;
            default:
                break;
        }
    }while(choix!=4);
    }

    public void AjouterConsultation (DossierMedical dossierMedical,Patient patient){
        consultation Consultation = new consultation();

        System.out.println("Entrer le compte rendu de la consultation : ");
        Consultation.setCompterendu(sc.nextLine());

        System.out.println("Entrer l'etat du patient : ");
        Consultation.setEtatpatient(sc.nextLine());

        System.out.println("Voulez vous ajouter une ordonnance ? (O/N)");
        String choix = sc.nextLine();

        if (choix.equals("O") || choix.equals("o")) {
            Ordonnance ordonnance = new Ordonnance();

            ordonnance.setNom(patient.getNom());
            ordonnance.setPrenom(patient.getPrenom());

            System.out.println("Entrer le nombre de traitements : ");
            int nb = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < nb; i++) {
                System.out.println("Entrer le nom du médicaments : ");
                ordonnance.getMedicament().add(sc.nextLine());
                System.out.println("Entrer la dose : ");
                ordonnance.getDoses().add(sc.nextLine());
            }
            System.out.println("Entrer le nom du médecin : ");
            ordonnance.setNomMedecin(sc.nextLine());
            Consultation.setOrdonnance(ordonnance);
        }
        else {
            Consultation.setOrdonnance(null);
        }
        dossierMedical.ajouterConsultation(Consultation);
    }

    public void ModifierConsultation(DossierMedical dossierMedical){}

    public void SupprimerConsultation(DossierMedical dossierMedical){}


}
