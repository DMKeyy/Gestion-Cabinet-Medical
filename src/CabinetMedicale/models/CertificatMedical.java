package CabinetMedicale.models;

import java.time.LocalDate;

public class CertificatMedical {

    private String patientName;
    private String doctorName;
    private LocalDate date;
    private String reason;
    private int duration;

    

    public CertificatMedical() {
    }

    public CertificatMedical(Patient patientName, String doctorName, String reason, int duration) {
        this.patientName = patientName.getNom()+" "+patientName.getPrenom();
        this.doctorName = doctorName;
        this.date = LocalDate.now();
        this.reason = reason;
        this.duration = duration;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    
    public void generateDocument() {
        System.out.println("---Certificat Medical---");
        System.out.println("Nom et prenom du patient : "+this.patientName);
        System.out.println("Nom du medecin : "+this.doctorName);
        System.out.println("Date : "+this.date);
        System.out.println("Raison : "+this.reason);
        System.out.println("Duree de l'arret de travail : "+this.duration+" jours");
        System.out.println("-------------------------");
    }
}
