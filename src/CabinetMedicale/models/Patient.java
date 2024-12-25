package CabinetMedicale.models;

import java.util.*;

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


        this.numeroDossier=nbDossier+1;
        Patient.nbDossier=nbDossier+1;
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


    


    @Override
    public String toString() {
        return "Patient [numeroDeTel=" + numeroDeTel + ", nom=" + nom + ", prenom=" + prenom + ", DateDeNaissance="
                + DateDeNaissance + ", poid=" + poid + ", taille=" + taille + ", adresse=" + adresse
                + ", AntecedentsMedicaux=" + AntecedentsMedicaux + ", AntecedentsChirurgicaux="
                + AntecedentsChirurgicaux + ", numeroDossier=" + numeroDossier + "]";
    }


    public void afficherinfo(){
        System.out.println(this.toString());
    }
    
    public void ajouterAntecedentMedical (){
        Scanner sc=new Scanner(System.in);
        System.out.println("entrez l'antecedant Medical du patient");
        this.AntecedentsMedicaux.add(sc.nextLine());
        sc.close();
    }

    public void ajouterAntecedentChirurgical (){
        Scanner sc=new Scanner(System.in);
        System.out.println("entrez l'antecedant chirurgical du patient");
        this.AntecedentsChirurgicaux.add(sc.nextLine());
        sc.close();
    }

    public void SupprimerAntecedentMedical(int n){
        AntecedentsMedicaux.remove(n-1);
    }

    public void SupprimerAntecedentChirurgicaux(int n){
        AntecedentsChirurgicaux.remove(n-1);
    }

    
}
