package CabinetMedicale.models;
import java.time.LocalDate;

public class consultation {
    private String Compterendu ;
    private LocalDate Date= LocalDate.now();
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


    public void AfficherConsultation(){
        System.out.println("--------------------Consultation----------------------");
        System.out.println("Date : "+this.Date);
        System.out.println("Compte rendu : "+this.Compterendu);
        System.out.println("Etat du patient : "+this.etatpatient);

        System.out.println("Ordonnance : ");
        if (ordonnance!=null){
            ordonnance.generateDocument();
        }
        else {
            System.out.println("Pas d'ordonnance");
        }

        System.out.println("Certificat Medical : ");
        if (certificatMedical!=null){
            certificatMedical.generateDocument();
        }
        else {
            System.out.println("Pas de certificat medical");
        }
        System.out.println("--------------------------------------------------------\n");
        
    }

    
}
