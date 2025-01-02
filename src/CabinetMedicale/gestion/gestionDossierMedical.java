package CabinetMedicale.gestion;


import java.time.LocalDate;
import java.util.Scanner;

import CabinetMedicale.models.CertificatMedical;
import CabinetMedicale.models.DossierMedical;
import CabinetMedicale.models.Ordonnance;
import CabinetMedicale.models.Patient;
import CabinetMedicale.models.consultation;

public class gestionDossierMedical {
    Scanner sc = new Scanner(System.in);

    Patient patient;


    public void GestionDossierMedical (Patient patient){
        
        int choix;
        System.out.println("\n\nGestion du dossier médical \n");
    do{
        System.out.println("Voulez vous:\n");
        System.out.println("1 . Ajouter une consultation");
        System.out.println("2 . Modifier une consultation");
        System.out.println("3 . Supprimer une consultation");
        System.out.println("4 . Afficher le dossier médical");
        System.out.println("5 . Retour");

        choix = 0;

        do { // Loop until a valid choice is made  (Doit etre un entier entre 1 et 5)
            while (true) {
                if (sc.hasNextInt()) {
                    choix = sc.nextInt();
                    if (choix < 1 || choix > 5) {
                        System.out.println("L'entier dois etre entre 1 et 5.");
                    }
                    break;
                } else {
                    System.out.println("Entré invalide . Entrez un entier entre 1 et 5.");
                    sc.next(); // Clear invalid input
                }
            }
        } while (choix < 1 || choix > 5);


        switch (choix) {
            case 1:
                AjouterConsultation(patient.getDossierMedical(),patient);
                break;
            case 2:
                ModifierConsultation(patient.getDossierMedical(),patient);
                break;
            case 3:
                SupprimerConsultation(patient.getDossierMedical());
            case 4:
                patient.getDossierMedical().AfficherDossierMedical();
                break;
            case 5:
                break;
        }
    }while(choix!=5);
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
            Consultation = AjouterOrdonnance(Consultation,patient);
        }
        else {
            Consultation.setOrdonnance(null);
        }

        System.out.println("Voulez vous ajouter un certificat médical ? (O/N)");
        choix = sc.nextLine();
        if (choix.equals("O") || choix.equals("o")) {
            Consultation = AjouterCertificatMedical(Consultation,patient);
        }
        else {
            Consultation.setCertificatMedical(null);
        }

        dossierMedical.ajouterConsultation(Consultation);
    }




    public consultation AjouterOrdonnance(consultation Consultation,Patient patient){
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
        return Consultation;
    }




    public consultation AjouterCertificatMedical(consultation Consultation,Patient patient){
        CertificatMedical certificatMedical = new CertificatMedical();

        System.out.println("Entrer le motif du certificat médical : ");
        certificatMedical.setReason(sc.nextLine());
        System.out.println("Entrer la durée de l'arrêt : xx jours");
        int duree ;

        do {
            while (true) {
                if (sc.hasNextInt()) {
                    duree = sc.nextInt();
                    sc.nextLine();
                    if (duree<1) {
                        System.out.println("La durée doit être supérieure à 0.");
                    }
                    break;
                } else {
                    System.out.println("Entré invalide . Entrez un entier supérieur à 0.");
                    sc.next(); // Clear invalid input
                }
            }
        } while (duree<1);
        certificatMedical.setDuration(duree);

        certificatMedical.setPatientName(patient.getNom()+" "+patient.getPrenom());
        
        System.out.println("Entrer le nom du médecin : ");
        certificatMedical.setDoctorName(sc.nextLine());

        Consultation.setCertificatMedical(certificatMedical);
        return Consultation;
    }




    public void ModifierConsultation(DossierMedical dossierMedical, Patient patient){

        consultation Consultation = RechercherConsultation(dossierMedical);
        if (Consultation!=null) {
            System.out.println("Voulez vous modifier le compte rendu ? (O/N)");
            String choix = sc.nextLine();
            if (choix.equals("O") || choix.equals("o")) {
                System.out.println("Entrer le nouveau compte rendu : ");
                Consultation.setCompterendu(sc.nextLine());
            }

            System.out.println("Voulez vous modifier l'etat du patient ? (O/N)");
            choix = sc.nextLine();
            if (choix.equals("O") || choix.equals("o")) {
                System.out.println("Entrer le nouvel etat du patient : ");
                Consultation.setEtatpatient(sc.nextLine());
            }

            System.out.println("Voulez vous modifier l'ordonnance ? (O/N)");
            choix = sc.nextLine();
            if (choix.equals("O") || choix.equals("o")) {
                ModifierOrdonnance(Consultation,patient);
            }

            System.out.println("Voulez vous modifier le certificat médical ? (O/N)");
            choix = sc.nextLine();
            if (choix.equals("O") || choix.equals("o")) {
                ModifierCertificatMedical(Consultation, patient);
            }
        }
        else {
            System.out.println("Consultation introuvable.");
        }

    }




    public void ModifierOrdonnance(consultation Consultation, Patient patient){
        Ordonnance ordonnance = Consultation.getOrdonnance();
        int choix=0;
        do{
        System.out.println("\nVoulez vous : \n");
        System.out.println("1 . Ajouter un médicament");
        System.out.println("2 . Supprimer un médicament");
        System.out.println("3 . Modifier la dose d'un médicament");
        System.out.println("4 . Retour");

        do {
            while (true) {
                if (sc.hasNextInt()) {
                    choix = sc.nextInt();
                    if (choix<1 || choix>4) {
                        System.out.println("La durée doit être supérieure à 0.");
                    }
                    break;
                } else {
                    System.out.println("Entré invalide . Entrez un entier supérieur à 0.");
                    sc.next(); // Clear invalid input
                }
            }
        } while (choix<1|| choix>4);

        switch (choix) {
            case 1:
                ordonnance.AjouterMedicament();
                break;
            case 2:
                ordonnance.SupprimerMedicament();
                break;
            case 3:
                ordonnance.ModifierDose();
            default:
                break;
        }
    }while(choix!=4);

    }




    public void ModifierCertificatMedical(consultation Consultation, Patient patient){
        CertificatMedical certificatMedical = Consultation.getCertificatMedical();

        System.out.println("Voulez vous modifier le motif du certificat médical ? (O/N)");
        String choix = sc.nextLine();
        if (choix.equals("O") || choix.equals("o")) {
            System.out.println("Entrer le nouveau motif du certificat médical : ");
            certificatMedical.setReason(sc.nextLine());
        }


        System.out.println("Voulez vous modifier la durée de l'arrêt ? (O/N)");
        choix = sc.nextLine();
        if (choix.equals("O") || choix.equals("o")) {
            System.out.println("Entrer la nouvelle durée de l'arrêt : ");
            int duree ;

            do {
                while (true) {
                    if (sc.hasNextInt()) {
                        duree = sc.nextInt();
                        if (duree<1) {
                            System.out.println("La durée doit être supérieure à 0.");
                        }
                        break;
                    } else {
                        System.out.println("Entré invalide . Entrez un entier supérieur à 0.");
                        sc.next(); // Clear invalid input
                    }
                }
            } while (duree<1);
            certificatMedical.setDuration(duree);
        }

    }




    public void SupprimerConsultation(DossierMedical dossierMedical){
        consultation Consultation = RechercherConsultation(dossierMedical);
        if (Consultation!=null) {
            dossierMedical.getConsultations().remove(Consultation);
            System.out.println("Consultation supprimée avec succès.");
        }
        else {
            System.out.println("Consultation introuvable.");
        }
    }




    public consultation RechercherConsultation(DossierMedical dossierMedical){
        System.out.println("Entrer le jour de la consultation à rechercher : ");
        int jour ;
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    jour = sc.nextInt();
                    sc.nextLine();
                    if (jour<1 || jour>31) {
                        System.out.println("Le jour doit être compris entre 1 et 31.");
                    }
                    break;
                } else {
                    System.out.println("Entré invalide . Entrez un entier entre 1 et 31.");
                    sc.next(); // Clear invalid input
                }
            }
        } while (jour<1 || jour>31);
        
        System.out.println("Entrer le mois de la consultation à rechercher : ");
        int mois ;
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    mois = sc.nextInt();
                    sc.nextLine();
                    if (mois<1 || mois>12) {
                        System.out.println("Le mois doit être compris entre 1 et 12.");
                    }
                    break;
                } else {
                    System.out.println("Entré invalide . Entrez un entier entre 1 et 12.");
                    sc.next(); // Clear invalid input
                }
            }
        } while (mois<1 || mois>12);

        System.out.println("Entrer l'année de la consultation à rechercher : ");
        int annee ;

        do {
            while (true) {
                if (sc.hasNextInt()) {
                    annee = sc.nextInt();
                    if (annee<1) {
                        System.out.println("L'année doit être positif.");
                    }
                    break;
                } else {
                    System.out.println("Entré invalide . Entrez un entier positif.");
                    sc.next(); // Clear invalid input
                }
            }
        } while (annee<1);


        LocalDate date = LocalDate.of(annee, mois, jour);

        for (consultation Consultation : dossierMedical.getConsultations()) {
            if (Consultation.getDate().equals(date)) {
                return Consultation;
            }
        }
        return null;
    }

}
