package CabinetMedicale;

import java.util.Locale;
import java.util.Scanner;
import CabinetMedicale.gestion.gestionDossierMedical;
import CabinetMedicale.gestion.gestionPatient;
import CabinetMedicale.gestion.gestionRDV;
import CabinetMedicale.models.Patient;

public class App {

    public static void main(String[] args) throws Exception {
    
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); //Force '.' as the decimal separator

        gestionRDV gestionRDV = new gestionRDV();
        gestionPatient gestionPatient = new gestionPatient();
        gestionDossierMedical gestionDossierMedical = new gestionDossierMedical();

        int choix;

        afficherBienvenue();

        do {
            afficherMenu();

            choix = 0;

            // Lecture et validation du choix de l'utilisateur
            do {
                System.out.println(Colors.BLUE);
                while (true) {
                    System.out.println(Colors.YELLOW + "> Veuillez saisir votre choix (1-4) : " + Colors.RESET);
                    if (sc.hasNextInt()) {
                        choix = sc.nextInt();
                        sc.nextLine();
                        if (choix < 1 || choix > 4) {
                            System.out.println(Colors.RED + "L'entier doit etre entre 1 et 4." + Colors.RESET);
                        }
                        break;
                    } else {
                        System.out.println(Colors.RED + "Entré invalide. Entrez un entier entre 1 et 4." + Colors.RESET);
                        sc.next(); // Clear invalid input
                    }
                }
            } while (choix < 1 || choix > 4);

            switch (choix) {
                case 1:
                    afficherTitreSection("Gestion des patients", Colors.GREEN);
                    gestionPatient.GestionPatient();
                    break;
                case 2:
                    afficherTitreSection("Gestion des rendez-vous", Colors.GREEN);
                    gestionRDV.GestionRDV();
                    break;
                case 3:
                    afficherTitreSection("Gestion du dossier médical", Colors.GREEN);
                    Patient x = gestionPatient.selectionnerPatient();
                    if (x != null) {
                        gestionDossierMedical.GestionDossierMedical(x);
                    }
                    break;
                case 4:
                    afficherAuRevoir();
                    break;
            }
        } while (choix != 4);

        sc.close();
    }

    private static void afficherBienvenue() {
        System.out.println(Colors.GREEN + "==============================================");
        System.out.println("       BIENVENUE DANS LE CABINET MÉDICAL       ");
        System.out.println("==============================================\n" + Colors.RESET);
    }

    private static void afficherMenu() {
        System.out.println(Colors.CYAN + "\n---------------- MENU PRINCIPAL ----------------" + Colors.RESET);
        System.out.println(Colors.BLUE + "1 . Gestion des patients" + Colors.RESET);
        System.out.println(Colors.BLUE + "2 . Gestion des rendez-vous" + Colors.RESET);
        System.out.println(Colors.BLUE + "3 . Gestion du dossier médical d'un patient" + Colors.RESET);
        System.out.println(Colors.RED + "4 . Quitter" + Colors.RESET);
        System.out.println(Colors.CYAN + "------------------------------------------------" + Colors.RESET);
    }

    private static void afficherTitreSection(String titre, String couleur) {
        System.out.println(couleur + "\n================================================" + Colors.RESET);
        System.out.println(couleur + "           " + titre.toUpperCase() + Colors.RESET);
        System.out.println(couleur + "================================================" + Colors.RESET);
    }

    private static void afficherAuRevoir() {
        System.out.println(Colors.GREEN + "\n==============================================");
        System.out.println("  Merci d'avoir utilisé notre système. À bientôt !  ");
        System.out.println("==============================================" + Colors.RESET);
    }
}
