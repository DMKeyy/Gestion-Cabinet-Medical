package CabinetMedicale.gestion;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import CabinetMedicale.models.Patient;
import CabinetMedicale.Colors;

public class gestionPatient {
    Scanner sc = new Scanner(System.in);

    private ArrayList<Patient> patients = new ArrayList<Patient>();

    
    public gestionPatient() {
        this.patients = new ArrayList<Patient>();
    }
    
    public void GestionPatient() {

        int choix;
        
        do{
        System.out.println(Colors.CYAN+ "\n======= Gestion des patients =======\n" + Colors.RESET);
        System.out.println(Colors.BLUE+"Que souhaitez-vous faire ?" );
        System.out.println("1 . Ajouter un Patient");
        System.out.println("2 . Modifier les information du Patient");
        System.out.println("3 . Supprimer un Patient");
        System.out.println("4 . Afficher les informations des Patients");
        System.out.println("5 . Afficher les informations d'un seul patient"+Colors.RESET);
        System.out.println(Colors.RED+"6 . Retour"+Colors.RESET);

        choix = 0;

        do {
            while (true) {
                System.out.println(Colors.YELLOW + "> Veuillez saisir votre choix (1-6) : " + Colors.RESET);
                if (sc.hasNextInt()) {
                    choix = sc.nextInt();
                    sc.nextLine();
                    if (choix < 1 || choix > 6) {
                        System.out.println(Colors.RED+"l'entier doit être entre 1 et 6."+Colors.RESET);
                    }
                    break;
                } else {
                    System.out.println(Colors.RED+"Entrée invalide. Entrez un entier entre 1 et 6."+Colors.RESET);
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
    System.out.println(Colors.RESET);
    }

    public Patient selectionnerPatient(){
        System.out.println(Colors.CYAN+"\nVeuillez sélectionner un patient "+Colors.RESET);
        System.out.println(Colors.BLUE+"Entrer le nom du patient : "+Colors.RESET);
        String nom = sc.nextLine();
        System.out.println(Colors.BLUE+"Entrer le prénom du patient : "+Colors.RESET);
        String prenom = sc.nextLine();

        for (Patient patient : patients) {
            if (patient.getNom().equalsIgnoreCase(nom) && patient.getPrenom().equalsIgnoreCase(prenom)) {
                return patient;
            }
        }

        System.out.println(Colors.RED+"Patient non trouvé."+Colors.RESET);
        return null;
    }

    public void ajouterPatient() {
        sc.useLocale(Locale.US);

        System.out.println(Colors.BLUE + "Entrer le nom du patient: " + Colors.RESET);
        String nom = sc.nextLine();

        System.out.println(Colors.BLUE + "Entrer le prénom du patient: " + Colors.RESET);
        String prenom = sc.nextLine();

        String DateDeNaissance;
        do {
            System.out.println(Colors.BLUE + "Entrer la date de naissance du patient: jj/mm/aaaa" + Colors.RESET);
            DateDeNaissance = sc.nextLine();
            if (DateDeNaissance.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
                break;
            } else {
                System.out.println(Colors.RED+"Erreur: Veuillez entrer une date valide. (jj/mm/aaaa)"+Colors.RESET);
            }
        } while (true);

        String numeroDeTel;
        do{
            System.out.println(Colors.BLUE + "Entrer le numéro de téléphone du patient: " + Colors.RESET);
            numeroDeTel = sc.nextLine();
            if (numeroDeTel.matches("[0-9]+")) {
                break;
            }
            else {
                System.out.println(Colors.RED+"Erreur: Veuillez entrer un numéro de téléphone valide !"+Colors.RESET);
            }
        }while(true);

        System.out.println(Colors.BLUE + "Entrer l'adresse du patient: " + Colors.RESET);
        String adresse = sc.nextLine();

        System.out.println(Colors.BLUE + "Entrer le poids du patient: (en kg XX.xx)" + Colors.RESET);

        double poid=0;
        do{
            try {
                poid = sc.nextDouble();
                sc.nextLine();
                if (poid > 0) {
                    break;
                } else {
                    System.out.println(Colors.RED+"Erreur: le poids doit être positif."+Colors.RESET);
                }
            } catch (Exception e) {
                System.out.println(Colors.RED+"Erreur: Veuillez entrer un nombre valide. (XX.xx)"+Colors.RESET);
                sc.nextLine();
                poid=0;
            }
        }while(poid<=0);

        System.out.println(Colors.BLUE+"Entrer la taille du patient: (en mètres X.xx)"+Colors.RESET);
        double taille =0;

        do{
            try {
                taille = sc.nextDouble();
                sc.nextLine();
                if (taille > 0) {
                    break;
                } else {
                    System.out.println(Colors.RED+"Erreur: la taille doit être positive."+Colors.RESET);
                }
            } catch (Exception e) {
                System.out.println(Colors.RED+"Erreur: Veuillez entrer un nombre valide. (X.xx)"+Colors.RESET);
                sc.nextLine();
                taille=0;
            }
        
        }while(taille<=0);

        boolean fin = false;
        
        System.out.println(Colors.BLUE+"Entrer les antécédents médicaux du patient: (si vous avez fini entrer 'fin')"+Colors.RESET);
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
        
        System.out.println(Colors.BLUE+"Entrer les antécédents chirurgicaux du patient: (si vous avez fini entrer 'fin')"+Colors.RESET);
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
        System.out.println(Colors.GREEN+"\nPatient ajouté.\n"+Colors.RESET);
    }

    public void modifierPatient(){

        Patient patient = selectionnerPatient();

        if (patient !=null) {

            System.out.println(Colors.BLUE+"Que voulez-vous modifier ? ");
            System.out.println("1 . Nom");
            System.out.println("2 . Prénom");
            System.out.println("3 . Date de naissance");
            System.out.println("4 . Adresse");
            System.out.println("5 . Poids");
            System.out.println("6 . Taille");
            System.out.println("7 . Antécédents Médicaux");
            System.out.println("8 . Antécédents Chirurgicaux");
            System.out.println("9 . Numéro de téléphone"+Colors.RESET);
            System.out.println(Colors.RED+"10 . Annuler"+Colors.RESET);

            int choix = 0;

            do {
                System.out.println(Colors.YELLOW + "> Veuillez saisir votre choix (1-10) : " + Colors.RESET);
                try {
                    choix = sc.nextInt();
                    sc.nextLine();
                    if (choix < 1 && choix > 8) {
                        
                        System.out.println(Colors.RED+"Erreur: le nombre doit être entre 1 et 10."+Colors.RESET);
                    }
                } catch (Exception e) {
                    System.out.println(Colors.RED+"Erreur: Veuillez entrer un entier. "+Colors.RESET);
                }

            } while (choix < 1 || choix > 10);

            switch(choix){
                case 1:
                    modifierNom(patient);
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

    public void modifierNom(Patient patient){
        System.out.println(Colors.BLUE+"Entrer le nouveau nom : "+Colors.RESET);
        String nom = sc.nextLine();
        patient.setNom(nom);
    }

    public void modifierPrenom(Patient patient){
        System.out.println(Colors.BLUE+"Entrer le nouveau prénom : "+Colors.RESET);
        String prenom = sc.nextLine();
        patient.setPrenom(prenom);
    }

    public void modifierDateDeNaissance(Patient patient){
        System.out.println(Colors.BLUE+"Entrer la nouvelle date de naissance : "+Colors.RESET);
        String DateDeNaissance = sc.nextLine();
        patient.setDateDeNaissance(DateDeNaissance);
    }

    public void modifierAdresse(Patient patient){
        System.out.println(Colors.BLUE+"Entrer la nouvelle adresse : "+Colors.RESET);
        String adresse = sc.nextLine();
        patient.setAdresse(adresse);
    }

    public void modifierPoid(Patient patient){
        sc.useLocale(Locale.US);
        
        System.out.println(Colors.BLUE+"Entrer le nouveau poids : "+Colors.RESET);
        try {
            double poid = sc.nextDouble();
            patient.setPoid(poid);
        } catch (Exception e) {
            System.out.println(Colors.RED+"Erreur: Veuillez entrer un nombre."+Colors.RESET);
            sc.nextLine();
        }
    }

    public void modifierTaille(Patient patient){
        sc.useLocale(Locale.US);

        System.out.println(Colors.BLUE+"Entrer la nouvelle taille : "+Colors.RESET);
        try {
            double taille = sc.nextDouble();
            patient.setTaille(taille);
        } catch (Exception e) {
            System.out.println(Colors.RED+"Erreur: Veuillez entrer un nombre."+Colors.RESET);
            sc.nextLine();
        }
    }

    public void modifierAntecedentMedical(Patient patient){
        int choix = 0;
        do{
            System.out.println(Colors.BLUE+"Voulez-vous ajouter, modifier ou supprimer un antécédent médical ? ");
            System.out.println("1 . Ajouter");
            System.out.println("2 . Modifier");
            System.out.println("3 . Supprimer"+Colors.RESET);
            System.out.println(Colors.RED+"4 . Retour"+Colors.RESET);

            do {
                System.out.println(Colors.YELLOW + "> Veuillez saisir votre choix (1-4) : " + Colors.RESET);
                try {
                    choix = sc.nextInt();
                    sc.nextLine();
                    if (choix < 1 && choix > 4) {
                        
                        System.out.println(Colors.RED+"Erreur: le nombre doit être entre 1 et 4."+Colors.RESET);
                    }
                } catch (Exception e) {
                    System.out.println(Colors.RED+"Erreur: Veuillez entrer un entier."+Colors.RESET);
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
        }while(choix!=4);
    }

    public void modifierAntecedentChirurgical(Patient patient){
        int choix = 0;
        do{
            System.out.println(Colors.BLUE+"Voulez-vous ajouter, modifier ou supprimer un antécédent chirurgical ? ");
            System.out.println("1 . Ajouter");
            System.out.println("2 . Modifier");
            System.out.println("3 . Supprimer"+Colors.RESET);
            System.out.println(Colors.RED+"4 . Retour"+Colors.RESET);

            do {
                System.out.println(Colors.YELLOW + "> Veuillez saisir votre choix (1-4) : " + Colors.RESET);
                try {
                    choix = sc.nextInt();
                    sc.nextLine();
                    if (choix < 1 && choix > 4) {
                        
                        System.out.println(Colors.RED+"Erreur: le nombre doit être entre 1 et 4."+Colors.RESET);
                    }
                } catch (Exception e) {
                    System.out.println(Colors.RED+"Erreur: Veuillez entrer un entier."+Colors.RESET);
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
        }while(choix!=4);
    }

    public void modifierNumeroDeTel(Patient patient){
        System.out.println(Colors.BLUE+"Entrer le nouveau numéro de téléphone : "+Colors.RESET);
        String numeroDeTel = sc.nextLine();
        if (numeroDeTel.matches("[0-9]+")) {
            patient.setNumeroDeTel(numeroDeTel);
        }
        else {
            System.out.println(Colors.RED+"Erreur: Veuillez entrer un numéro de téléphone valide !"+Colors.RESET);
        }
    }

    public void supprimerPatient(){
        Patient patient = selectionnerPatient();
        if (patient != null) {
            patients.remove(patient);
            System.out.println(Colors.GREEN+"Patient supprimé."+Colors.RESET);
        }
        else {
            System.out.println(Colors.RED+"Patient non trouvé."+Colors.RESET);
        }
    }

    public void afficherPatients(){
        for (Patient patient : patients) {
            patient.afficherinfo();
        }
    }
}