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
        do{
            System.out.println("\n\nVoulez-vous : \n");
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
        System.out.println("jour : (1-31)");       jour=sc.nextInt();      sc.nextLine(); 
        System.out.println("Mois : (1-12)");       mois=sc.nextInt();      sc.nextLine(); 
        System.out.println("heure : (0-24)");      heure=sc.nextInt();     sc.nextLine(); 
        System.out.println("Minute :(0-60)");     minute=sc.nextInt();    sc.nextLine(); 
        System.out.println("Annee :");      annee=sc.nextInt();     sc.nextLine(); 
        
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

        Collections.sort(RDVs,Comparator.comparing(RendezVous::getDateHeure)); // trier les rendez-vous

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

        Collections.sort(RDVs,Comparator.comparing(RendezVous::getDateHeure)); // trier les rendez-vous

    }


}
