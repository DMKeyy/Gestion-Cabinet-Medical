package CabinetMedicale.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Ordonnance {
    Scanner sc = new Scanner(System.in);

    private String nom;
    private String prenom;
    private ArrayList<String> medicament;
    private ArrayList<String> doses;
    private LocalDate dateOrdonnance = LocalDate.now();
    private String nomMedecin;

    public Ordonnance() {
        medicament=new ArrayList<String>();
        doses=new ArrayList<String>();
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
        System.out.println("---Ordonnance Médicale---\n");
        System.out.println("Date : " + dateOrdonnance + "\n");
        System.out.println("Patient : " + nom + " "+ prenom + "\n" );
        System.out.println("Docteur : " + nomMedecin + "\n");
        for (String string : doses) {
            System.out.println("Medicament : "+medicament.get(doses.indexOf(string))+"   "+string);
        }
        System.out.println("-------------------------\n");
    }


    
    public void AjouterMedicament(){
        System.out.println("Combien de medicament voulez vous ajouter ?");
        int nbMedicament ;
        do {
            while (true) {
                if (sc.hasNextInt()) {
                    nbMedicament = sc.nextInt();
                    if (nbMedicament<1) {
                        System.out.println("Le nombre de medicaments doit être positif.");
                    }
                    break;
                } else {
                    System.out.println("Entré invalide . Entrez un entier positif.");
                    sc.next(); // Clear invalid input
                }
            }
        } while (nbMedicament<1);
        for (int i = 0; i < nbMedicament; i++) {

            System.out.println("Entrer le nom du medicament : ");
            medicament.add(sc.next());

            System.out.println("Entrer la dose : ");
            doses.add(sc.next());
        }
    }



    public void SupprimerMedicament(){
        System.out.println("Entrer le nom du medicament à supprimer : ");
        String medicamentSupp = sc.next();

        if (medicament.contains(medicamentSupp)) {
            doses.remove(medicament.indexOf(medicamentSupp));
            medicament.remove(medicamentSupp);
            System.out.println("Medicament supprimé avec succès.");
        }
        else {
            System.out.println("Medicament introuvable.");
        }
    }



    public void ModifierDose(){
        System.out.println("Entrer le nom du medicament dont vous voulez modifier la dose : ");
        String medicamentModif = sc.next();

        if (medicament.contains(medicamentModif)) {
            System.out.println("Entrer la nouvelle dose : ");
            doses.set(medicament.indexOf(medicamentModif), sc.next());

            System.out.println("Dose modifiée avec succès.");
        }
        else {
            System.out.println("Medicament introuvable.");
        }
    }


}
