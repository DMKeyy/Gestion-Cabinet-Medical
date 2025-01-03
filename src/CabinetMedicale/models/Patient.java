package CabinetMedicale.models;

import java.util.*;
import CabinetMedicale.Colors;

public class Patient {
    private String numeroDeTel;
    private String nom;
    private String prenom;
    private String DateDeNaissance;
    private double poid;
    private double taille;
    private String adresse;
    private ArrayList<String> AntecedentsMedicaux;
    private ArrayList<String> AntecedentsChirurgicaux;
    private int numeroDossier;
    private static int nbDossier;
    private DossierMedical dossierMedical;
    private Scanner sc = new Scanner(System.in);

    public Patient(String numeroDeTel, String nom, String prenom, String DateDeNaissance, double poid, double taille, String adresse, ArrayList<String> AntecedentsMedicaux, ArrayList<String> AntecedentsChirurgicaux) {
        this.numeroDeTel = numeroDeTel;
        this.nom = nom;
        this.prenom = prenom;
        this.DateDeNaissance = DateDeNaissance;
        this.poid = poid;
        this.taille = taille;
        this.adresse = adresse;
        this.AntecedentsMedicaux = AntecedentsMedicaux;
        this.AntecedentsChirurgicaux = AntecedentsChirurgicaux;
        this.dossierMedical = new DossierMedical(this);
        this.numeroDossier = nbDossier + 1;
        Patient.nbDossier = nbDossier + 1;
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public String getNumeroDeTel() {
        return numeroDeTel;
    }

    public void setNumeroDeTel(String numeroDeTel) {
        this.numeroDeTel = numeroDeTel;
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

    public String getDateDeNaissance() {
        return DateDeNaissance;
    }

    public void setDateDeNaissance(String DateDeNaissance) {
        this.DateDeNaissance = DateDeNaissance;
    }

    public double getPoid() {
        return poid;
    }

    public void setPoid(double poid) {
        this.poid = poid;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumeroDossier() {
        return numeroDossier;
    }

    public ArrayList<String> getAntecedentsMedicaux() {
        return AntecedentsMedicaux;
    }

    public void setAntecedentsMedicaux(ArrayList<String> AntecedentsMedicaux) {
        this.AntecedentsMedicaux = AntecedentsMedicaux;
    }

    public ArrayList<String> getAntecedentsChirurgicaux() {
        return AntecedentsChirurgicaux;
    }

    public void setAntecedentsChirurgicaux(ArrayList<String> AntecedentsChirurgicaux) {
        this.AntecedentsChirurgicaux = AntecedentsChirurgicaux;
    }

    public static int getNbDossier() {
        return nbDossier;
    }

    public static void setNumeroDossier(int numeroDossier) {
        Patient.nbDossier = numeroDossier;
    }

    public void afficherinfo() {
        System.out.println(Colors.BLUE + "\n==========================Patient==========================\n");
        System.out.println(Colors.BLUE + "Nom : " + Colors.RESET + nom);
        System.out.println(Colors.BLUE + "Prenom : " + Colors.RESET + prenom);
        System.out.println(Colors.BLUE + "Date de naissance : "+Colors.RESET + DateDeNaissance);
        System.out.println(Colors.BLUE + "Poid : " + Colors.RESET + poid);
        System.out.println(Colors.BLUE + "Taille : " + Colors.RESET + taille);
        System.out.println(Colors.BLUE + "Adresse : " + Colors.RESET + adresse);
        System.out.println(Colors.BLUE + "Numero de telephone : " + Colors.RESET + numeroDeTel);
        System.out.println(Colors.BLUE + "Numero de dossier : " + Colors.RESET + numeroDossier);
        System.out.println(Colors.BLUE + "Antecedents Medicaux : " + Colors.RESET + AntecedentsMedicaux);
        System.out.println(Colors.BLUE + "Antecedents Chirurgicaux : " + Colors.RESET + AntecedentsChirurgicaux);
        System.out.println("\n");
        System.out.println(Colors.BLUE + "Dossier Medical : " + Colors.RESET);
        dossierMedical.AfficherDossierMedical();
        System.out.println(Colors.BLUE + "\n===========================================================\n" + Colors.RESET);
    }

    public void ajouterAntecedentMedical() {
        System.out.println(Colors.BLUE + "Entrer l'antecedent medical a ajouter : " + Colors.RESET);
        String Antecedent = sc.nextLine();
        AntecedentsMedicaux.add(Antecedent);
    }

    public void modifierAntecedentMedical() {
        System.out.println(Colors.BLUE + "Entrer l'antecedent medical a modifier : " + Colors.RESET);
        String AntecedentAModifier = sc.nextLine();
        System.out.println(Colors.BLUE + "Entrer le nouveau antecedent medical : " + Colors.RESET);
        String NouvelAntecedent = sc.nextLine();

        for (String antecedent : AntecedentsMedicaux) {
            if (antecedent.equalsIgnoreCase(AntecedentAModifier)) {
                AntecedentsMedicaux.set(AntecedentsMedicaux.indexOf(antecedent), NouvelAntecedent);
            }
        }
    }

    public void ajouterAntecedentChirurgical() {
        System.out.println(Colors.BLUE + "Entrer l'antecedent chirurgical a ajouter : " + Colors.RESET);
        String Antecedent = sc.nextLine();
        AntecedentsChirurgicaux.add(Antecedent);
    }

    public void modifierAntecedentChirurgical() {
        System.out.println(Colors.BLUE + "Entrer l'antecedent chirurgical a modifier : " + Colors.RESET);
        String AntecedentAModifier = sc.nextLine();
        System.out.println(Colors.BLUE + "Entrer le nouveau antecedent chirurgical : " + Colors.RESET);
        String NouvelAntecedent = sc.nextLine();

        for (String antecedent : AntecedentsChirurgicaux) {
            if (antecedent.equalsIgnoreCase(AntecedentAModifier)) {
                AntecedentsMedicaux.set(AntecedentsMedicaux.indexOf(antecedent), NouvelAntecedent);
            }
        }
    }

    public void supprimerAntecedentChirurgical() {
        System.out.println(Colors.BLUE + "Entrer l'antecedent chirurgical a supprimer : " + Colors.RESET);
        String AntecedentASupprimer = sc.nextLine();

        for (String antecedent : getAntecedentsChirurgicaux()) {
            if (antecedent.equalsIgnoreCase(AntecedentASupprimer)) {
                getAntecedentsChirurgicaux().remove(antecedent);
                System.out.println(Colors.GREEN + "Antecedent supprimé." + Colors.RESET);
                break;
            } else {
                System.out.println(Colors.RED + "Antecedent non trouvé." + Colors.RESET);
            }
        }
    }

    public void supprimerAntecedentMedical() {
        System.out.println(Colors.BLUE + "Entrer l'antecedent medical a supprimer : " + Colors.RESET);
        String AntecedentASupprimer = sc.nextLine();

        for (String antecedent : getAntecedentsMedicaux()) {
            if (antecedent.equalsIgnoreCase(AntecedentASupprimer)) {
                getAntecedentsMedicaux().remove(antecedent);
                System.out.println(Colors.GREEN + "Antecedent supprimé." + Colors.RESET);
                break;
            } else {
                System.out.println(Colors.RED + "Antecedent non trouvé." + Colors.RESET);
            }
        }
    }
}
