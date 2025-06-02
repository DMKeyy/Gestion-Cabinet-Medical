package CabinetMedicale.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Ordonnance {
    private Scanner sc = new Scanner(System.in);
    private String nom;
    private String prenom;
    private ArrayList<String> medicament;
    private ArrayList<String> doses;
    private LocalDate dateOrdonnance = LocalDate.now();
    private String nomMedecin;

    public Ordonnance() {
        medicament = new ArrayList<>();
        doses = new ArrayList<>();
    }

    public Ordonnance(String nom, String prenom, ArrayList<String> medicament, ArrayList<String> doses, String nomMedecin) {
        this.nom = nom;
        this.prenom = prenom;
        this.medicament = medicament;
        this.doses = doses;
        this.nomMedecin = nomMedecin;
    }

    public ArrayList<String> getMedicament() {
        return medicament;
    }

    public void setMedicament(ArrayList<String> medicament) {
        this.medicament = medicament;
    }

    public ArrayList<String> getDoses() {
        return doses;
    }

    public void setDoses(ArrayList<String> doses) {
        this.doses = doses;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateOrdonnance() {
        return dateOrdonnance;
    }

    public void setDateOrdonnance(LocalDate dateOrdonnance) {
        this.dateOrdonnance = dateOrdonnance;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
        }

        public void generateDocument() {
        System.out.println(Colors.CYAN + "---Ordonnance Médicale---\n");
        System.out.println("Date : " + Colors.RESET + dateOrdonnance + "\n");
        System.out.println(Colors.CYAN + "Patient : " + Colors.RESET + nom + " " + prenom + "\n");
        System.out.println(Colors.CYAN + "Docteur : " + Colors.RESET + nomMedecin + "\n");
        for (String dose : doses) {
            System.out.println(Colors.CYAN + "Medicament : " + Colors.RESET + medicament.get(doses.indexOf(dose)) + "   " + dose);
        }
        System.out.println(Colors.CYAN + "-------------------------\n" + Colors.RESET);
        }

        public void AjouterMedicament() {
        System.out.println(Colors.YELLOW + "Combien de medicament voulez vous ajouter ?" + Colors.RESET);
        int nbMedicament;
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    nbMedicament = sc.nextInt();
                    if (nbMedicament < 1) {
                        System.out.println(Colors.RED + "Le nombre de medicaments doit être positif." + Colors.RESET);
                    }
                    break;
                } else {
                    System.out.println(Colors.RED + "Entré invalide. Entrez un entier positif." + Colors.RESET);
                    sc.next(); // Clear invalid input
                }
            }
        } while (nbMedicament < 1);
        for (int i = 0; i < nbMedicament; i++) {
            System.out.println(Colors.BLUE + "Entrer le nom du medicament : " + Colors.RESET);
            medicament.add(sc.next());

            System.out.println(Colors.BLUE + "Entrer la dose : " + Colors.RESET);
            doses.add(sc.next());
        }
    }

    public void SupprimerMedicament() {
        System.out.println(Colors.BLUE + "Entrer le nom du medicament à supprimer : " + Colors.RESET);
        String medicamentSupp = sc.next();

        if (medicament.contains(medicamentSupp)) {
            doses.remove(medicament.indexOf(medicamentSupp));
            medicament.remove(medicamentSupp);
            System.out.println(Colors.GREEN + "Medicament supprimé avec succès." + Colors.RESET);
        } else {
            System.out.println(Colors.RED + "Medicament introuvable." + Colors.RESET);
        }
    }

    public void ModifierDose() {
        System.out.println(Colors.BLUE + "Entrer le nom du medicament dont vous voulez modifier la dose : " + Colors.RESET);
        String medicamentModif = sc.next();

        if (medicament.contains(medicamentModif)) {
            System.out.println(Colors.BLUE + "Entrer la nouvelle dose : " + Colors.RESET);
            doses.set(medicament.indexOf(medicamentModif), sc.next());
            System.out.println(Colors.GREEN + "Dose modifiée avec succès." + Colors.RESET);
        } else {
            System.out.println(Colors.RED + "Medicament introuvable." + Colors.RESET);
        }
    }
}
