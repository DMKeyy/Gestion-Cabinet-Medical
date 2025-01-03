package CabinetMedicale.gestion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import CabinetMedicale.models.RendezVous;
import CabinetMedicale.Colors;


public class gestionRDV {
    Scanner sc = new Scanner(System.in);

    private ArrayList<RendezVous> RDVs;

    public gestionRDV() {
        RDVs = new ArrayList<RendezVous>();
    }

    public gestionRDV(ArrayList<RendezVous> rDVs) {
        RDVs = rDVs;
    }

    public void GestionRDV() {
        int choix;
        
        do {
            System.out.println(Colors.CYAN + "\n======= Gestion des rendez-vous =======\n" + Colors.RESET);
            System.out.println(Colors.BLUE + "Que souhaitez-vous faire ?");
            System.out.println("1. Ajouter un Rendez-vous");
            System.out.println("2. Annuler un Rendez-vous");
            System.out.println("3. Modifier un Rendez-vous");
            System.out.println("4. Afficher les Rendez-vous" + Colors.RESET);
            System.out.println(Colors.RED + "5. Retour" + Colors.RESET);

            choix = 0;
            do {
                try {
                    System.out.println(Colors.YELLOW + "> Veuillez saisir votre choix (1-5) : " + Colors.RESET);
                    choix = sc.nextInt();
                    sc.nextLine();
                    if (choix < 1 && choix > 5) {
                        System.out.println(Colors.RED + "Erreur: le nombre doit etre entre 1 et 5." + Colors.RESET);
                    }
                } catch (Exception e) {
                    System.out.println(Colors.RED + "Erreur: Veuiller entrer un entier." + Colors.RESET);
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
        } while (choix != 5);
    }

    public void RemplireDate(RendezVous RDV) {
        int jour, mois, annee, heure, minute;

        System.out.println(Colors.BLUE + "jour : (1-31)" + Colors.RESET);
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    jour = sc.nextInt();
                    sc.nextLine();
                    if (jour < 1 || jour > 31) {
                        System.out.println(Colors.RED + "Le jour dois etre entre 1 et 31." + Colors.RESET);
                    }
                    break;
                } else {
                    System.out.println(Colors.RED + "Entré invalide . Entrez un entier entre 1 et 31." + Colors.RESET);
                    sc.next(); // Clear invalid input
                }
            }
        } while (jour < 1 || jour > 31);

        System.out.println(Colors.BLUE + "Mois : (1-12)" + Colors.RESET);
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    mois = sc.nextInt();
                    sc.nextLine();
                    if ((mois < 1 || mois > 12)) {
                        System.out.println(Colors.RED + "Le mois dois etre entre 1 et 12." + Colors.RESET);
                    }
                    if (mois == 2 && jour > 29) {
                        System.out.println(Colors.RED + "Le mois de février ne peut pas avoir plus de 29 jours." + Colors.RESET);
                    }
                    break;
                } else {
                    System.out.println(Colors.RED + "Entré invalide . Entrez un entier entre 1 et 12." + Colors.RESET);
                    sc.next(); // Clear invalid input
                }
            }
        } while (mois < 1 || mois > 12);

        System.out.println(Colors.BLUE + "heure : (8h-18h)" + Colors.RESET);
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    heure = sc.nextInt();
                    sc.nextLine();
                    if (heure < 8 || heure > 18) {
                        System.out.println(Colors.RED + "Le Cabinet est ouvert de 8h a 18h." + Colors.RESET);
                    }
                    break;
                } else {
                    System.out.println(Colors.RED + "Entré invalide . Entrez un entier entre 8 et 18." + Colors.RESET);
                    sc.next(); // Clear invalid input
                }
            }
        } while (heure < 8 || heure > 18);

        System.out.println(Colors.BLUE + "Minute :(0-60)" + Colors.RESET);
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    minute = sc.nextInt();
                    sc.nextLine();
                    if (minute < 0 || minute > 59) {
                        System.out.println(Colors.RED + "Les minutes doivent être entre 0 et 59." + Colors.RESET);
                    }
                    break;
                } else {
                    System.out.println(Colors.RED + "Entré invalide . Entrez un entier entre 0 et 60." + Colors.RESET);
                    sc.next(); // Clear invalid input
                }
            }
        } while (minute < 0 || minute > 59);

        System.out.println(Colors.BLUE + "Annee :" + Colors.RESET);
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    annee = sc.nextInt();
                    sc.nextLine();
                    if (annee < LocalDateTime.now().getYear()) {
                        System.out.println(Colors.RED + "L'année doit être supérieure ou égale à l'année actuelle." + Colors.RESET);
                    }
                    break;
                } else {
                    System.out.println(Colors.RED + "Entré invalide . Entrez un entier." + Colors.RESET);
                    sc.next(); // Clear invalid input
                }
            }
        } while (annee < LocalDateTime.now().getYear());

        RDV.setDateHeure(LocalDateTime.of(annee, mois, jour, heure, minute));
    }

    public void ajouterRDV() {
        System.out.println(Colors.BLUE + "Entrer le Nom : " + Colors.RESET);
        String nom = sc.nextLine();
        System.out.println(Colors.BLUE + "Entrer le Prenom : " + Colors.RESET);
        String prenom = sc.nextLine();
        System.out.println(Colors.BLUE + "Entrer le Numero de telephone : " + Colors.RESET);
        String numero = sc.nextLine();
        System.out.println(Colors.BLUE + "Quel est la raison du Rendez-Vous : " + Colors.RESET);
        String pourquoi = sc.nextLine();

        RendezVous RDV = new RendezVous(null, nom, prenom, numero, pourquoi);

        do {
            System.out.println(Colors.BLUE + "Entrer la date du rendez-vous : " + Colors.RESET);
            RemplireDate(RDV);
        } while (!RendezVous.AjouterRDV(RDVs, RDV));
    }

    public void annulerRDV() {
        RendezVous RDV = new RendezVous();
        RemplireDate(RDV);

        int x = RechercheRDV(RDVs, RDV.getDateHeure());
        if (x != -1) {
            RDVs.remove(x);
            System.out.println(Colors.GREEN + "Rendez vous supprimer" + Colors.RESET);
        } else {
            System.out.println(Colors.RED + "Le rendez vous n'existe pas" + Colors.RESET);
        }
    }

    public void AfficherRDVs() {
        if (RDVs.isEmpty()) {
            System.out.println(Colors.RED + "Il n'y a aucun rendez-vous." + Colors.RESET);
        } else {
            System.out.println(Colors.CYAN + "\n-------------------------------------------------- Liste des Rendez-vous ------------------------------------------------------\n" + Colors.RESET);
            int count = 1;
            for (RendezVous rendezVous : RDVs) {
                System.out.println(Colors.BLUE + "Rendez-vous " + count + " : " + Colors.RESET);
                System.out.print(Colors.GREEN + "Nom: " + Colors.RESET + rendezVous.getNom() + "\t");
                System.out.print(Colors.GREEN + "Prenom: " + Colors.RESET + rendezVous.getPrenom() + "\t");
                System.out.print(Colors.GREEN + "Heure : " + Colors.RESET + rendezVous.getTelephone() + "\t");
                System.out.print(Colors.GREEN + "Raison : " + Colors.RESET + rendezVous.getPourquoi() + '\t');
                System.out.print(Colors.GREEN + "Date : " + Colors.RESET + rendezVous.getDateHeure());
                System.out.println(Colors.CYAN + "\n------------------------------------------------------------------------------------------------------------------------------------" + Colors.RESET);
                count++;
            }
        }
    }

    public int RechercheRDV(ArrayList<RendezVous> listeRDV, LocalDateTime date) {
        int left = 0; // recherche binaire
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

    public void modiferRDV() {
        RendezVous RDV = new RendezVous();
        System.out.println(Colors.BLUE + "Entrer la date du rendez-vous a modifier : " + Colors.RESET);
        RemplireDate(RDV);
        int x = RechercheRDV(RDVs, RDV.getDateHeure());

        if (x == -1) {
            System.out.println(Colors.RED + "Le rendez-vous n'existe pas" + Colors.RESET);
            return;
        }

        System.out.println(Colors.BLUE + "Entrer la nouvelle date du rendez-vous : " + Colors.RESET);
        RemplireDate(RDV); // avoir la nouvelle date

        RendezVous newRDV = RDVs.get(x);
        newRDV.setDateHeure(RDV.getDateHeure());
        Collections.sort(RDVs, Comparator.comparing(RendezVous::getDateHeure));
    }
}
