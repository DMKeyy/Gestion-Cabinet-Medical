package CabinetMedicale.gestion;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import CabinetMedicale.models.Patient;

public class gestionPatient {
    Scanner sc = new Scanner(System.in);

    private ArrayList<Patient> patients = new ArrayList<Patient>();
    
        public gestionPatient() {
            this.patients = new ArrayList<Patient>();
        }
        
        public void GestionPatient() {

            int choix;
            System.out.println("\n\nGestion des patients\n");
            do{
            System.out.println("Voulez-vous : \n");
            System.out.println("1 . Ajouter un Patient");
            System.out.println("2 . Modifier les information du Patient");
            System.out.println("3 . Supprimer un Patient");
            System.out.println("4 . Afficher les informations des Patients");
            System.out.println("5 . Afficher les informations d'un seul patient");
            System.out.println("6 . Retour");
    
            choix = 0;
    
            do {
                while (true) {
                    if (sc.hasNextInt()) {
                        choix = sc.nextInt();
                        sc.nextLine();
                        if (choix < 1 || choix > 6) {
                            System.out.println("l'entier dois etre entre 1 et 6.");
                        }
                        break;
                    } else {
                        System.out.println("Entré invalide . Entrez un entier entre 1 et 6.");
                        sc.next(); // Clear invalid input
                    }
                }
            } while (choix < 1 || choix > 6);

        switch (choix) {
            case 1:
                ajouterPatient();
                break;
            case 2:
                modifierPatient();
                break;
            case 3:
                supprimerPatient();
                break;
            case 4:
                afficherPatients();
                break;
            case 5:
                selectionnerPatient().afficherinfo();
                break;
            case 6:
                break;
        }
    }while(choix!=6);
    }



    public Patient selectionnerPatient(){
        System.out.println("\nveuillez selectionner un patient : \n");
        System.out.println("Entrer le nom du patient : ");
        String nom = sc.nextLine();
        System.out.println("Entrer le prénom du patient : ");
        String prenom = sc.nextLine();

        for (Patient patient : patients) {
            if (patient.getNom().equalsIgnoreCase(nom) && patient.getPrenom().equalsIgnoreCase(prenom)) {
                return patient;
            }
        }

        System.out.println("Patient non trouvé.");
        return null;
    }



    public void ajouterPatient() {
        sc.useLocale(Locale.US);

        System.out.println("Entrer le nom du patient: ");
        String nom = sc.nextLine();

        System.out.println("Entrer le prenom du patient: ");
        String prenom = sc.nextLine();

        System.out.println("Entrer la date de naissance du patient: ");
        String DateDeNaissance = sc.nextLine();

        System.out.println("Entrer le numero de telephone du patient: ");
        String numeroDeTel = sc.nextLine();

        System.out.println("Entrer l'adresse du patient: ");
        String adresse = sc.nextLine();

        System.out.println("Entrer le poids du patient: (en kg XX.xx)");

        double poid=0;
            do{
                try {
                    poid = sc.nextDouble();
                    sc.nextLine();
                    if (poid > 0) {
                        break;
                    } else {
                        System.out.println("Erreur: le poids doit être positif.");
                    }
                } catch (Exception e) {
                    System.out.println("Erreur: Veuillez entrer un nombre valide. (XX.xx)");
                    sc.nextLine();
                    poid=0;
                }
            }while(poid<=0);

        System.out.println("Entrer la taille du patient: (en mettres X.xx)");
        double taille =0;


        do{
            try {
                taille = sc.nextDouble();
                sc.nextLine();
                if (taille > 0) {
                    break;
                } else {
                    System.out.println("Erreur: la taille doit être positif.");
                }
            } catch (Exception e) {
                System.out.println("Erreur: Veuillez entrer un nombre valide. (X.xx)");
                sc.nextLine();
                taille=0;
            }
        
        }while(taille<=0);



        boolean fin = false;
        
        System.out.println("Entrer les antecedents medicaux du patient: (si vous avez fini entrer 'fin')");
        ArrayList<String> AntecedentsMedicaux = new ArrayList<String>();
            do {
                String Antecedent = sc.nextLine();
                if (Antecedent.equalsIgnoreCase("fin")) {
                    fin = true;
                } else {
                    AntecedentsMedicaux.add(Antecedent);
                }
            } while (!fin);

        fin = false;
        
        System.out.println("Entrer les antecedents chirurgicaux du patient: (si vous avez fini entrer 'fin')");
        ArrayList<String> AntecedentsChirurgicaux = new ArrayList<String>();
            do {
                String Antecedent = sc.nextLine();
                if (Antecedent.equalsIgnoreCase("fin")) {
                    fin = true;
                } else {
                    AntecedentsChirurgicaux.add(Antecedent);
                }
            } while (!fin);
        
        patients.add(new Patient(numeroDeTel, nom, prenom, DateDeNaissance, poid, taille, adresse, AntecedentsMedicaux, AntecedentsChirurgicaux));
    }



    public void modifierPatient(){

        Patient patient = selectionnerPatient();

        if (patient !=null) {

            System.out.println("Que vouler vous modifier : ");
            System.out.println("1 . Nom");
            System.out.println("2 . Prenom");
            System.out.println("3 . Date de naissance");
            System.out.println("4 . Adresse");
            System.out.println("5 . Poids");
            System.out.println("6 . Taille");
            System.out.println("7 . Antecedents Medicaux");
            System.out.println("8 . Antecedents Chirurgicaux");
            System.out.println("9 . Numero de telephone");
            System.out.println("10 . Annuler");

            int choix = 0;

            do {
                System.out.println("Entrer votre choix: (1-10)");
                try {
                    choix = sc.nextInt();
                    sc.nextLine();
                    if (choix < 1 && choix > 8) {
                        
                        System.out.println("Erreur: le nombre doit etre entre 1 et 10.");
                    }
                } catch (Exception e) {
                    System.out.println("Erreur: Veuiller entrer un entier. ");
                }

            } while (choix < 1 || choix > 10);


            switch(choix){
                case 1:
                    modifiernNom(patient);
                    break;
                case 2:
                    modifierPrenom(patient);
                    break;
                case 3:
                    modifierDateDeNaissance(patient);
                    break;
                case 4:
                    modifierAdresse(patient);
                    break;
                case 5:
                    modifierPoid(patient);
                    break;
                case 6:
                    modifierTaille(patient);
                    break;
                case 7:
                    modifierAntecedentMedical(patient);
                    break;
                case 8:
                    modifierAntecedentChirurgical(patient);
                    break;
                case 9:
                    modifierNumeroDeTel(patient);
                    break;
                case 10:
                    break;
                }
        }
        
    }



    public void modifiernNom(Patient patient){
        System.out.println("Entrer le nouveau nom : ");
        String nom = sc.nextLine();
        patient.setNom(nom);
    }



    public void modifierPrenom(Patient patient){
        System.out.println("Entrer le nouveau prenom : ");
        String prenom = sc.nextLine();
        patient.setPrenom(prenom);
    }



    public void modifierDateDeNaissance(Patient patient){
        System.out.println("Entrer la nouvelle date de naissance : ");
        String DateDeNaissance = sc.nextLine();
        patient.setDateDeNaissance(DateDeNaissance);
    }


    
    public void modifierAdresse(Patient patient){
        System.out.println("Entrer la nouvelle adresse : ");
        String adresse = sc.nextLine();
        patient.setAdresse(adresse);
    }



    public void modifierPoid(Patient patient){
        sc.useLocale(Locale.US);
        
        System.out.println("Entrer le nouveau poids : ");
        try {
            double poid = sc.nextDouble();
            patient.setPoid(poid);
        } catch (Exception e) {
            System.out.println("Erreur: Veuiller entrer un nombre.");
            sc.nextLine();
        }

    }



    public void modifierTaille(Patient patient){
        sc.useLocale(Locale.US);

        System.out.println("Entrer la nouvelle taille : ");
        try {
            double taille = sc.nextDouble();
            patient.setTaille(taille);
        } catch (Exception e) {
            System.out.println("Erreur: Veuiller entrer un nombre.");
            sc.nextLine();
        }
    }



    public void modifierAntecedentMedical(Patient patient){

        System.out.println("Voulez-vous ajouter, modifer ou supprimer un antecedent medical : ");
        System.out.println("1 . Ajouter");
        System.out.println("2 . Modifier");
        System.out.println("3 . Supprimer");
        System.out.println("4 . Annuler");
        int choix = 0;
        do {
            System.out.println("Entrer votre choix: (1-4)");
            try {
                choix = sc.nextInt();
                sc.nextLine();
                if (choix < 1 && choix > 4) {
                    
                    System.out.println("Erreur: le nombre doit etre entre 1 et 4.");
                }
            } catch (Exception e) {
                System.out.println("Erreur: Veuiller entrer un entier.");
                sc.nextLine();
            }

        } while (choix < 1 || choix > 4);

        switch (choix) {
            case 1:
                patient.ajouterAntecedentMedical();
                break;
            case 2:
                patient.modifierAntecedentMedical();
                break;
            case 3:
                patient.supprimerAntecedentMedical();
                break;
            case 4:
                break;
        }
    }



    public void modifierAntecedentChirurgical(Patient patient){
        System.out.println("Voulez-vous ajouter, modifer ou supprimer un antecedent chirurgical : ");
        System.out.println("1 . Ajouter");
        System.out.println("2 . Modifier");
        System.out.println("3 . Supprimer");
        System.out.println("4 . Annuler");
        int choix = 0;

        do {
            System.out.println("Entrer votre choix: (1-4)");
            try {
                choix = sc.nextInt();
                sc.nextLine();
                if (choix < 1 && choix > 4) {
                    
                    System.out.println("Erreur: le nombre doit etre entre 1 et 4.");
                }
            } catch (Exception e) {
                System.out.println("Erreur: Veuiller entrer un entier.");
                sc.nextLine();
            }

        } while (choix < 1 || choix > 4);

        switch (choix) {
            case 1:
                patient.ajouterAntecedentChirurgical();
                break;
            case 2:
                patient.modifierAntecedentChirurgical();
                break;
            case 3:
                patient.supprimerAntecedentChirurgical();
                break;
            case 4:
                break;
        }
    }



    public void modifierNumeroDeTel(Patient patient){
        System.out.println("Entrer le nouveau numero de telephone : ");
        String numeroDeTel = sc.nextLine();
        if (numeroDeTel.matches("[0-9]+")) {
            patient.setNumeroDeTel(numeroDeTel);
        }
        else {
            System.out.println("Erreur: Veuiller entrer un nombre.");
        }
    }



    public void supprimerPatient(){
        Patient patient = selectionnerPatient();
        if (patient != null) {
            patients.remove(patient);
            System.out.println("Patient supprimé.");
        }
        else {
            System.out.println("Patient non trouvé.");
        }
    }



    public void afficherPatients(){
        for (Patient patient : patients) {
            patient.afficherinfo();
        }
    }


}
