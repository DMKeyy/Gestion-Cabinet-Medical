package CabinetMedicale;

import java.util.ArrayList;

import CabinetMedicale.gestion.gestionRDV;
import CabinetMedicale.models.Ordonnance;
import CabinetMedicale.models.Patient;

public class App {
    public static void main(String[] args) throws Exception {
        gestionRDV GRDV = new gestionRDV();
        GRDV.GestionRDV();
        // Ordonnance ord=new Ordonnance(new Patient(null, "john", "abruzzi", null, 0, 0, null, new ArrayList<String>(), new ArrayList<String>()),"Doliprane","2");
        // System.out.println(ord.toString());
    } 

}