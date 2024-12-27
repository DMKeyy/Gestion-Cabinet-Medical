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
        do{
        System.out.println("choissisez une option : ");
        System.out.println("1 . Gestion des patients");
        System.out.println("2 . Gestion des rendez-vous");
        System.out.println("3 . Gestion du dossier médical d'un patient");
        System.out.println("4 . Quitter");

        choix = 0;

        do {
            try {
                choix = sc.nextInt();
                sc.nextLine();
                if (choix < 1 && choix > 4) {

                    System.out.println("Erreur: le nombre doit etre entre 1 et 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur: Veuiller entrer un entier.");
            }

        } while (choix < 1 && choix > 4);

        switch (choix) {
            case 1:
                gestionPatient.GestionPatient();
                break;
            case 2:
                gestionRDV.GestionRDV();
                break;
            case 3:
                Patient x=gestionPatient.selectionnerPatient();
                if(x!=null){
                gestionDossierMedical.GestionDossierMedical(x);
                }
                break;
            case 4:
                break;
        }
    }while(choix!=4);



    sc.close();
    } 

}