package CabinetMedicale.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import CabinetMedicale.Colors;

public class RendezVous {

    Scanner sc = new Scanner(System.in);

    private LocalDateTime dateHeure;
    private String nom;
    private String prenom;
    private String telephone;
    private String pourquoi;
    
    public RendezVous() {
    }


    public RendezVous(LocalDateTime dateHeure, String nom, String prenom, String telephone,String pourquoi) {
        this.dateHeure = dateHeure;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.pourquoi=pourquoi;
    }


    public String getPourquoi() {
        return pourquoi;
    }


    public void setPourquoi(String pourquoi) {
        this.pourquoi = pourquoi;
    }


    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public LocalDateTime getDateHeure() {
        return dateHeure;
    }


    public String getNom() {
        return nom;
    }


    public String getPrenom() {
        return prenom;
    }


    public String getTelephone() {
        return telephone;
    }


   

    @Override
    public String toString() {
        return "RendezVous [nom : " + nom + ", prenom : " + prenom + ", Telephone : " + telephone
                + ", Motif du rendez-vous : " + pourquoi +", Date  Heure=" + dateHeure + "]";
    }



    public static boolean AjouterRDV(ArrayList<RendezVous> listeRDV,RendezVous RDV){ //// ajouter un intervale de 15min
        if (verifRDV(listeRDV,RDV.getDateHeure())) {
            System.out.println(Colors.RED+"Date non disponible"+Colors.RESET);
            return false;
        }
        System.out.println(Colors.GREEN+"Rendez vous ajouter"+Colors.RESET);
        listeRDV.add(RDV);
        listeRDV.sort((rdv1, rdv2) -> rdv1.getDateHeure().compareTo(rdv2.getDateHeure()));
        return true;
    }


    
    public static boolean verifRDV(ArrayList<RendezVous> listeRDV,LocalDateTime date){
        for (RendezVous rendezVous : listeRDV) {
            if (rendezVous.getDateHeure().isEqual(date)) {
                return true;
            }
        }
        return false;
    }

}
