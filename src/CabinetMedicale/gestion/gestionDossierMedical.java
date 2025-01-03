package CabinetMedicale.gestion;


import java.time.LocalDate;
import java.util.Scanner;

import CabinetMedicale.models.CertificatMedical;
import CabinetMedicale.models.DossierMedical;
import CabinetMedicale.models.Ordonnance;
import CabinetMedicale.models.Patient;
import CabinetMedicale.models.consultation;
import CabinetMedicale.Colors;

public class gestionDossierMedical {
    Scanner sc = new Scanner(System.in);

    Patient patient;

    public void GestionDossierMedical(Patient patient) {
        int choix;
        
        do {
            System.out.println(Colors.CYAN + "======= Gestion du dossier médical =======\n" + Colors.RESET);
            System.out.println(Colors.BLUE + "Que souhaitez-vous faire ?");
            System.out.println("1 . Ajouter une consultation");
            System.out.println("2 . Modifier une consultation");
            System.out.println("3 . Supprimer une consultation");
            System.out.println("4 . Afficher le dossier médical" + Colors.RESET);
            System.out.println(Colors.RED + "5 . Retour" + Colors.RESET);

            choix = 0;

            do { // Loop until a valid choice is made (Doit etre un entier entre 1 et 5)
                while (true) {
                    if (sc.hasNextInt()) {
                        System.out.println(Colors.YELLOW + "> Veuillez saisir votre choix (1-5) : " + Colors.RESET);
                        choix = sc.nextInt();
                        sc.nextLine();
                        if (choix < 1 || choix > 5) {
                            System.out.println(Colors.RED + "L'entier dois etre entre 1 et 5." + Colors.RESET);
                        }
                        break;
                    } else {
                        System.out.println(Colors.RED + "Entré invalide . Entrez un entier entre 1 et 5." + Colors.RESET);
                        sc.next(); // Clear invalid input
                    }
                }
            } while (choix < 1 || choix > 5);

            switch (choix) {
                case 1:
                    AjouterConsultation(patient.getDossierMedical(), patient);
                    break;
                case 2:
                    ModifierConsultation(patient.getDossierMedical(), patient);
                    break;
                case 3:
                    SupprimerConsultation(patient.getDossierMedical());
                case 4:
                    patient.getDossierMedical().AfficherDossierMedical();
                    break;
                case 5:
                    break;
            }
        } while (choix != 5);
    }

    public void AjouterConsultation(DossierMedical dossierMedical, Patient patient) {
        consultation Consultation = new consultation();

        System.out.println(Colors.BLUE + "Entrer le compte rendu de la consultation : " + Colors.RESET);
        Consultation.setCompterendu(sc.nextLine());

        System.out.println(Colors.BLUE + "Entrer l'etat du patient : " + Colors.RESET);
        Consultation.setEtatpatient(sc.nextLine());

        System.out.println(Colors.YELLOW + "Voulez vous ajouter une ordonnance ? (O/N)" + Colors.RESET);
        String choix = sc.nextLine();

        if (choix.equals("O") || choix.equals("o")) {
            Consultation = AjouterOrdonnance(Consultation, patient);
        } else {
            Consultation.setOrdonnance(null);
        }

        System.out.println(Colors.YELLOW + "Voulez vous ajouter un certificat médical ? (O/N)" + Colors.RESET);
        choix = sc.nextLine();
        if (choix.equals("O") || choix.equals("o")) {
            Consultation = AjouterCertificatMedical(Consultation, patient);
        } else {
            Consultation.setCertificatMedical(null);
        }

        dossierMedical.ajouterConsultation(Consultation);
    }

    public consultation AjouterOrdonnance(consultation Consultation, Patient patient) {
        Ordonnance ordonnance = new Ordonnance();

        ordonnance.setNom(patient.getNom());
        ordonnance.setPrenom(patient.getPrenom());

        System.out.println(Colors.BLUE + "Entrer le nombre de traitements : " + Colors.RESET);
        int nb = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < nb; i++) {
            System.out.println(Colors.BLUE + "Entrer le nom du médicaments : " + Colors.RESET);
            ordonnance.getMedicament().add(sc.nextLine());
            System.out.println(Colors.BLUE + "Entrer la dose : " + Colors.RESET);
            ordonnance.getDoses().add(sc.nextLine());
        }
        System.out.println(Colors.BLUE + "Entrer le nom du médecin : " + Colors.RESET);
        ordonnance.setNomMedecin(sc.nextLine());
        Consultation.setOrdonnance(ordonnance);
        return Consultation;
    }

    public consultation AjouterCertificatMedical(consultation Consultation, Patient patient) {
        CertificatMedical certificatMedical = new CertificatMedical();

        System.out.println(Colors.BLUE + "Entrer le motif du certificat médical : " + Colors.RESET);
        certificatMedical.setReason(sc.nextLine());
        System.out.println(Colors.BLUE + "Entrer la durée de l'arrêt : xx jours" + Colors.RESET);
        int duree;

        do {
            while (true) {
                if (sc.hasNextInt()) {
                    duree = sc.nextInt();
                    sc.nextLine();
                    if (duree < 1) {
                        System.out.println(Colors.RED + "La durée doit être supérieure à 0." + Colors.RESET);
                    }
                    break;
                } else {
                    System.out.println(Colors.RED + "Entré invalide . Entrez un entier supérieur à 0." + Colors.RESET);
                    sc.next(); // Clear invalid input
                }
            }
        } while (duree < 1);
        certificatMedical.setDuration(duree);

        certificatMedical.setPatientName(patient.getNom() + " " + patient.getPrenom());

        System.out.println("Entrer le nom du médecin : ");
        certificatMedical.setDoctorName(sc.nextLine());

        Consultation.setCertificatMedical(certificatMedical);
        return Consultation;
    }

    public void ModifierConsultation(DossierMedical dossierMedical, Patient patient) {

        consultation Consultation = RechercherConsultation(dossierMedical);
        if (Consultation != null) {
            System.out.println(Colors.YELLOW + "Voulez vous modifier le compte rendu ? (O/N)" + Colors.RESET);
            String choix = sc.nextLine();
            if (choix.equals("O") || choix.equals("o")) {
                System.out.println(Colors.BLUE + "Entrer le nouveau compte rendu : " + Colors.RESET);
                Consultation.setCompterendu(sc.nextLine());
            }

            System.out.println(Colors.YELLOW + "Voulez vous modifier l'etat du patient ? (O/N)" + Colors.RESET);
            choix = sc.nextLine();
            if (choix.equals("O") || choix.equals("o")) {
                System.out.println(Colors.BLUE + "Entrer le nouvel etat du patient : " + Colors.YELLOW);
                Consultation.setEtatpatient(sc.nextLine());
            }

            System.out.println(Colors.YELLOW + "Voulez vous modifier l'ordonnance ? (O/N)" + Colors.RESET);
            choix = sc.nextLine();
            if (choix.equals("O") || choix.equals("o")) {
                ModifierOrdonnance(Consultation, patient);
            }

            System.out.println(Colors.YELLOW + "Voulez vous modifier le certificat médical ? (O/N)" + Colors.RESET);
            choix = sc.nextLine();
            if (choix.equals("O") || choix.equals("o")) {
                ModifierCertificatMedical(Consultation, patient);
            }
        } else {
            System.out.println(Colors.RED + "Consultation introuvable." + Colors.RESET);
        }

    }

    public void ModifierOrdonnance(consultation Consultation, Patient patient) {
        Ordonnance ordonnance = Consultation.getOrdonnance();
        int choix = 0;
        do {
            System.out.println(Colors.BLUE + "Que souhaitez-vous faire ?");
            System.out.println("1 . Ajouter un médicament");
            System.out.println("2 . Supprimer un médicament");
            System.out.println("3 . Modifier la dose d'un médicament" + Colors.RESET);
            System.out.println(Colors.RED + "4 . Retour" + Colors.RESET);

            do {
                while (true) {
                    if (sc.hasNextInt()) {
                        choix = sc.nextInt();
                        if (choix < 1 || choix > 4) {
                            System.out.println(Colors.RED + "La durée doit être supérieure à 0." + Colors.RESET);
                        }
                        break;
                    } else {
                        System.out.println(Colors.RED + "Entré invalide . Entrez un entier supérieur à 0." + Colors.RESET);
                        sc.next(); // Clear invalid input
                    }
                }
            } while (choix < 1 || choix > 4);

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
        } while (choix != 4);

    }

    public void ModifierCertificatMedical(consultation Consultation, Patient patient) {
        CertificatMedical certificatMedical = Consultation.getCertificatMedical();

        System.out.println(Colors.YELLOW + "Voulez vous modifier le motif du certificat médical ? (O/N)" + Colors.RESET);
        String choix = sc.nextLine();
        if (choix.equals("O") || choix.equals("o")) {
            System.out.println(Colors.BLUE + "Entrer le nouveau motif du certificat médical : " + Colors.RESET);
            certificatMedical.setReason(sc.nextLine());
        }

        System.out.println(Colors.YELLOW + "Voulez vous modifier la durée de l'arrêt ? (O/N)" + Colors.RESET);
        choix = sc.nextLine();
        if (choix.equals("O") || choix.equals("o")) {
            System.out.println(Colors.BLUE + "Entrer la nouvelle durée de l'arrêt : " + Colors.RESET);
            int duree;

            do {
                while (true) {
                    if (sc.hasNextInt()) {
                        duree = sc.nextInt();
                        if (duree < 1) {
                            System.out.println(Colors.RED + "La durée doit être supérieure à 0." + Colors.RESET);
                        }
                        break;
                    } else {
                        System.out.println(Colors.RED + "Entré invalide . Entrez un entier supérieur à 0." + Colors.RESET);
                        sc.next(); // Clear invalid input
                    }
                }
            } while (duree < 1);
            certificatMedical.setDuration(duree);
        }

    }

    public void SupprimerConsultation(DossierMedical dossierMedical) {
        consultation Consultation = RechercherConsultation(dossierMedical);
        if (Consultation != null) {
            dossierMedical.getConsultations().remove(Consultation);
            System.out.println(Colors.GREEN + "Consultation supprimée avec succès." + Colors.RESET);
        } else {
            System.out.println(Colors.RED + "Consultation introuvable." + Colors.RESET);
        }
    }

    public consultation RechercherConsultation(DossierMedical dossierMedical) {
        System.out.println(Colors.BLUE + "Entrer le jour de la consultation à rechercher : " + Colors.RESET);
        int jour;
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    jour = sc.nextInt();
                    sc.nextLine();
                    if (jour < 1 || jour > 31) {
                        System.out.println(Colors.RED + "Le jour doit être compris entre 1 et 31." + Colors.RESET);
                    }
                    break;
                } else {
                    System.out.println(Colors.RED + "Entré invalide . Entrez un entier entre 1 et 31." + Colors.RESET);
                    sc.next(); // Clear invalid input
                }
            }
        } while (jour < 1 || jour > 31);

        System.out.println(Colors.BLUE + "Entrer le mois de la consultation à rechercher : " + Colors.RESET);
        int mois;
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    mois = sc.nextInt();
                    sc.nextLine();
                    if (mois < 1 || mois > 12) {
                        System.out.println(Colors.RED + "Le mois doit être compris entre 1 et 12." + Colors.RESET);
                    }
                    break;
                } else {
                    System.out.println(Colors.RED + "Entré invalide . Entrez un entier entre 1 et 12." + Colors.RESET);
                    sc.next(); // Clear invalid input
                }
            }
        } while (mois < 1 || mois > 12);

        System.out.println(Colors.BLUE + "Entrer l'année de la consultation à rechercher : " + Colors.RESET);
        int annee;

        do {
            while (true) {
                if (sc.hasNextInt()) {
                    annee = sc.nextInt();
                    if (annee < 1) {
                        System.out.println(Colors.RED + "L'année doit être positif." + Colors.RESET);
                    }
                    break;
                } else {
                    System.out.println(Colors.RED + "Entré invalide . Entrez un entier positif." + Colors.RESET);
                    sc.next(); // Clear invalid input
                }
            }
        } while (annee < 1);

        LocalDate date = LocalDate.of(annee, mois, jour);

        for (consultation Consultation : dossierMedical.getConsultations()) {
            if (Consultation.getDate().equals(date)) {
                return Consultation;
            }
        }
        return null;
    }

}
