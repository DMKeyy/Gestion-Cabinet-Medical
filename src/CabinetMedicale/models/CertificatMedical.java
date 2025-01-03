package CabinetMedicale.models;

import java.time.LocalDate;
import CabinetMedicale.Colors;

public class CertificatMedical {
    private String patientName;
    private String doctorName;
    private LocalDate date;
    private String reason;
    private int duration;

    public CertificatMedical() {
    }

    public CertificatMedical(Patient patientName, String doctorName, String reason, int duration) {
        this.patientName = patientName.getNom() + " " + patientName.getPrenom();
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
        System.out.println(Colors.YELLOW + "---Certificat Medical---" + Colors.RESET);
        System.out.println(Colors.YELLOW + "Nom et prenom du patient : " + Colors.RESET+ this.patientName );
        System.out.println(Colors.YELLOW + "Nom du medecin : "+Colors.RESET + this.doctorName);
        System.out.println(Colors.YELLOW + "Date : " + Colors.RESET+ this.date);
        System.out.println(Colors.YELLOW + "Raison : " + Colors.RESET+ this.reason );
        System.out.println(Colors.YELLOW + "Duree de l'arret de travail : "+ Colors.RESET + this.duration +Colors.YELLOW + " jours"+ Colors.RESET);
        System.out.println(Colors.YELLOW + "-------------------------" + Colors.RESET);
    }
}
