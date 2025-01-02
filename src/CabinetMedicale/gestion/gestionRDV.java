package CabinetMedicale.gestion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import CabinetMedicale.models.RendezVous;


public class gestionRDV {
    Scanner sc = new Scanner(System.in);

    private ArrayList<RendezVous> RDVs;

    public gestionRDV() {
        RDVs=new ArrayList<RendezVous>();
    }

    

    public gestionRDV(ArrayList<RendezVous> rDVs) {
        RDVs = rDVs;
    }



    public void GestionRDV(){

        int choix;
        System.out.println("\n\nGestion des rendez-vous\n");
        do{
            System.out.println("Voulez-vous : \n");
            System.out.println("1 . Ajouter un Rendez-vous");
            System.out.println("2 . Annuler un Rendez-vous");
            System.out.println("3 . Modifier un Rendez-vous ");
            System.out.println("4 . Afficher les Rendez-vous");
            System.out.println("5 . Retour");
        
        choix=0;
        do {
            try {
                choix = sc.nextInt();
                sc.nextLine();
                if (choix < 1 && choix > 5) {
                    
                    System.out.println("Erreur: le nombre doit etre entre 1 et 5.");
                }
            } catch (Exception e) {
                System.out.println("Erreur: Veuiller entrer un entier.");
                sc.nextLine();
            }

        } while (choix < 1 || choix > 5);

        switch (choix) {
            case 1:
            ajouterRDV();
                break;
            case 2:
            annulerRDV();
                break;
            case 3:
            modiferRDV();
                break;
            case 4:
            AfficherRDVs();
                break;
            case 5:
                break;
        }
    }while(choix!=5);
    }



    public void RemplireDate (RendezVous RDV){
        int jour,mois,annee,heure,minute;

        System.out.println("jour : (1-31)");
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    jour = sc.nextInt();
                    sc.nextLine();
                    if (jour < 1 || jour > 31) {
                        System.out.println("Le jour dois etre entre 1 et 31.");
                    }
                    break;
                } else {
                    System.out.println("Entré invalide . Entrez un entier entre 1 et 31.");
                    sc.next(); // Clear invalid input
                }
            }
        } while (jour < 1 || jour > 31);
        
        

        System.out.println("Mois : (1-12)"); 
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    mois = sc.nextInt();
                    sc.nextLine();
                    if ((mois < 1 || mois > 12)) {
                        System.out.println("Le mois dois etre entre 1 et 12.");
                    }
                    if (mois == 2 && jour > 29) {
                        System.out.println("Le mois de février ne peut pas avoir plus de 29 jours.");
                        
                    }
                    break;
                } else {
                    System.out.println("Entré invalide . Entrez un entier entre 1 et 12.");
                    sc.next(); // Clear invalid input
                }
            }
        } while (mois < 1 || mois > 12);
        
        

        System.out.println("heure : (8h-18h)");
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    heure = sc.nextInt();
                    sc.nextLine();
                    if (heure < 8 || heure >18) {
                        System.out.println("Le Cabinet est ouvert du 8h a 18h.");
                    }
                    break;
                } else {
                    System.out.println("Entré invalide . Entrez un entier entre 8 et 18.");
                    sc.next(); // Clear invalid input
                }
            }
        } while (heure < 8 || heure > 18);



        System.out.println("Minute :(0-60)");     
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    minute = sc.nextInt();
                    sc.nextLine();
                    if (minute < 0 || minute > 59) {
                        System.out.println("Les minutes doivent être entre 0 et 59.");
                    }
                    break;
                } else {
                    System.out.println("Entré invalide . Entrez un entier entre 0 et 60.");
                    sc.next(); // Clear invalid input
                }
            }
        } while (minute < 0 || minute > 59); 

        System.out.println("Annee :");      
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    annee = sc.nextInt();
                    sc.nextLine();
                    if (annee < LocalDateTime.now().getYear()) {
                        System.out.println("L'année doit être supérieure ou égale à l'année actuelle.");
                    }
                    break;
                } else {
                    System.out.println("Entré invalide . Entrez un entier.");
                    sc.next(); // Clear invalid input
                }
            }
        } while (annee < LocalDateTime.now().getYear());

        RDV.setDateHeure(LocalDateTime.of(annee, mois, jour, heure, minute));
    }



    public void ajouterRDV(){
        System.out.println("Entrer le Nom : ");
        String nom =sc.nextLine();
        System.out.println("Entrer le Prenom : ");
        String prenom =sc.nextLine();
        System.out.println("Entrer le Numero de telephone : ");
        String numero =sc.nextLine();
        System.out.println("Quel est la raison du Rendez-Vous : ");
        String pourquoi =sc.nextLine();

        RendezVous RDV = new RendezVous(null,nom,prenom,numero,pourquoi);

        do {
            System.out.println("Entrer la date du rendez-vous : ");
            RemplireDate(RDV);
        } while (!RendezVous.AjouterRDV(RDVs, RDV));

         // trier les rendez-vous

    }



    public void annulerRDV(){
        RendezVous RDV = new RendezVous();
        RemplireDate(RDV);
        
        int x = RechercheRDV(RDVs,RDV.getDateHeure());
        if (x!=-1) {
            RDVs.remove(x);
            System.out.println("Rendez vous supprimer");
        }
        else{
            System.out.println("Le rendez vous n'existe pas");
        }
    }



    public void AfficherRDVs(){
        if (RDVs.isEmpty()) {
            System.out.println("il n'y a aucun rendez-vous");
        }
        else{
            for (RendezVous rendezVous : RDVs) {
                System.out.println(rendezVous.toString());
            }
        }
    }



    public int RechercheRDV(ArrayList<RendezVous> listeRDV,LocalDateTime date){
        int left = 0;   //recherche binaire
        int right = listeRDV.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            LocalDateTime midDate = listeRDV.get(mid).getDateHeure();

            if (midDate.isEqual(date)) {
                return mid;
            } else if (midDate.isBefore(date)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }



    public void modiferRDV(){
        RendezVous RDV = new RendezVous();
        System.out.println("Entrer la date du rendez-vous a modifier : ");
        RemplireDate(RDV);
        int x = RechercheRDV(RDVs, RDV.getDateHeure());

        if (x==-1) {
            System.out.println("Le rendez-vous n'existe pas");
            return;
        }

        System.out.println("Entrer la nouvelle date du rendez-vous : ");
        RemplireDate(RDV); // avoir la nouvelle date

        RendezVous newRDV = RDVs.get(x);
        newRDV.setDateHeure(RDV.getDateHeure());
        Collections.sort(RDVs,Comparator.comparing(RendezVous::getDateHeure));

    }


}
