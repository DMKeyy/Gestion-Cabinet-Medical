package CabinetMedicale.models;

import java.util.*;

public class Patient {
    Scanner sc = new Scanner(System.in);

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

    public Patient(String numeroDeTel, String nom, String prenom,String DateDeNaissance, double poid, double taille, String adresse,ArrayList<String> AntecedentsMedicaux,ArrayList<String> AntecedentsChirurgicaux) {
        this.numeroDeTel = numeroDeTel;
        this.nom = nom;
        this.prenom = prenom;
        this.DateDeNaissance =DateDeNaissance ;

        this.poid = poid;
        this.taille = taille;
        this.adresse = adresse;

        this.AntecedentsChirurgicaux=AntecedentsChirurgicaux;
        this.AntecedentsMedicaux = AntecedentsMedicaux;

        this.dossierMedical = new DossierMedical(this);

        this.numeroDossier=nbDossier+1;
        Patient.nbDossier=nbDossier+1;
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


    public void setAge(String DateDeNaissance) {
        this.DateDeNaissance =DateDeNaissance;
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


    public void setAntecedentsMedicaux(ArrayList<String> antecedentsMedicaux) {
        AntecedentsMedicaux = antecedentsMedicaux;
    }


    public static int getNbDossier() {
        return nbDossier;
    }


    public static void setNumeroDossier(int numeroDossier) {
        Patient.nbDossier = numeroDossier;
    }

    

    public ArrayList<String> getAntecedentsChirurgicaux() {
        return AntecedentsChirurgicaux;
    }


    public void setAntecedentsChirurgicaux(ArrayList<String> antecedentsChirurgicaux) {
        AntecedentsChirurgicaux = antecedentsChirurgicaux;
    }


    public void setDateDeNaissance(String dateDeNaissance) {
        DateDeNaissance = dateDeNaissance;
    }



    public void afficherinfo(){
        System.out.println("\n-----------------------------\n");
        System.out.println("Nom : "+nom);
        System.out.println("Prenom : "+prenom);
        System.out.println("Date de naissance : "+DateDeNaissance);
        System.out.println("Poid : "+poid);
        System.out.println("Taille : "+taille);
        System.out.println("Adresse : "+adresse);
        System.out.println("Numero de telephone : "+numeroDeTel);
        System.out.println("Numero de dossier : "+numeroDossier);
        System.out.println("Antecedents Medicaux : "+AntecedentsMedicaux);
        System.out.println("Antecedents Chirurgicaux : "+AntecedentsChirurgicaux);
        System.out.println("\n-----------------------------\n");
        System.out.println("Dossier Medical : ");
        dossierMedical.AfficherDossierMedical();

    }
    
    public void ajouterAntecedentMedical (){
        System.out.println("Entrer l'antecedent medical a ajouter : ");
        String Antecedent = sc.nextLine();
        AntecedentsMedicaux.add(Antecedent);
    }

    public void modifierAntecedentMedical(){
        System.out.println("Entrer l'antecedent medical a modifier : ");
        String AntecedentAModifier = sc.nextLine();
        System.out.println("Entrer le nouveau antecedent medical : ");
        String NouvelAntecedent = sc.nextLine();

        for (String antecedent : AntecedentsMedicaux) {
            if (antecedent.equalsIgnoreCase(AntecedentAModifier)) {
                AntecedentsMedicaux.set(AntecedentsMedicaux.indexOf(antecedent), NouvelAntecedent);
            }
        }
    }

    public void ajouterAntecedentChirurgical (){
        System.out.println("Entrer l'antecedent chirurgical a ajouter : ");
        String Antecedent = sc.nextLine();
        AntecedentsChirurgicaux.add(Antecedent);
    }

    public void modifierAntecedentChirurgical(){
        System.out.println("Entrer l'antecedent chirurgical a modifier : ");
        String AntecedentAModifier = sc.nextLine();
        System.out.println("Entrer le nouveau antecedent cirurgical : ");
        String NouvelAntecedent = sc.nextLine();

        for (String antecedent : AntecedentsChirurgicaux) {
            if (antecedent.equalsIgnoreCase(AntecedentAModifier)) {
                AntecedentsMedicaux.set(AntecedentsMedicaux.indexOf(antecedent), NouvelAntecedent);
            }
        }
    }   
    
    public void supprimerAntecedentChirurgical(){
        System.out.println("Entrer l'antecedent chirurgical a supprimer : ");
        String AntecedentASupprimer = sc.nextLine();

        for (String antecedent : getAntecedentsChirurgicaux()) {

            if (antecedent.equalsIgnoreCase(AntecedentASupprimer)) {
                getAntecedentsChirurgicaux().remove(antecedent);
                System.out.println("Antecedent supprimé.");
                    break;
            }
            else {
                System.out.println("Antecedent non trouvé.");
            }
        }
    }

    public void supprimerAntecedentMedical(){
        System.out.println("Entrer l'antecedent medical a supprimer : ");
        String AntecedentASupprimer = sc.nextLine();

        for (String antecedent : getAntecedentsMedicaux()) {

            if (antecedent.equalsIgnoreCase(AntecedentASupprimer)) {
                getAntecedentsMedicaux().remove(antecedent);
                System.out.println("Antecedent supprimé.");
                    break;
            }
            else {
                System.out.println("Antecedent non trouvé.");
            }
        }
    }
}
