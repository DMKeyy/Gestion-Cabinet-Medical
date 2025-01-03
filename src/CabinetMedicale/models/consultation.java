package CabinetMedicale.models;
import java.time.LocalDate;

import CabinetMedicale.Colors;

public class consultation {
    private String Compterendu;
    private LocalDate Date = LocalDate.now();
    private String etatpatient;
    private Ordonnance ordonnance;
    private CertificatMedical certificatMedical;

    public consultation() {
    }

    public consultation(String compterendu, Ordonnance ordonnance, CertificatMedical certificatMedical) {
        this.Compterendu = compterendu;
        this.ordonnance = ordonnance;
        this.certificatMedical = certificatMedical;
    }

    public String getCompterendu() {
        return Compterendu;
    }

    public void setCompterendu(String compterendu) {
        Compterendu = compterendu;
    }

    public Ordonnance getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public String getEtatpatient() {
        return etatpatient;
    }

    public void setEtatpatient(String etatpatient) {
        this.etatpatient = etatpatient;
    }

    public CertificatMedical getCertificatMedical() {
        return certificatMedical;
    }

    public void setCertificatMedical(CertificatMedical certificatMedical) {
        this.certificatMedical = certificatMedical;
    }

    public void AfficherConsultation() {
        System.out.println(Colors.GREEN+"--------------------Consultation----------------------");
        System.out.println("Date : " +Colors.RESET+ this.Date);
        System.out.println(Colors.GREEN+"Compte rendu : "+Colors.RESET + this.Compterendu);
        System.out.println(Colors.GREEN+"Etat du patient : "+Colors.RESET + this.etatpatient);

        System.out.println(Colors.GREEN+"Ordonnance : "+Colors.RESET);
        if (ordonnance != null) {
            ordonnance.generateDocument();
        } else {
            System.out.println(Colors.RED+"Pas d'ordonnance"+Colors.RESET);
        }

        System.out.println(Colors.GREEN+"Certificat Medical : "+Colors.RESET);
        if (certificatMedical != null) {
            certificatMedical.generateDocument();
        } else {
            System.out.println(Colors.RED+"Pas de certificat medical"+Colors.RESET);
        }
        System.out.println(Colors.GREEN+"--------------------------------------------------------\n"+Colors.RESET);
    }
}
