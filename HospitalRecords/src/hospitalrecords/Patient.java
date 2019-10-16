/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalrecords;

/**
 *
 *   Author Meyer Evenblij
 *   13/10/19
 *   Here's the "Patient" class where a list of required patient info is held 
 * 
 */
public class Patient {
    public String patientId;
    public String name;
    public String checkInDate;
    public String assignedMedicalPersonnel;


    public Patient(String patientId, String name, String checkInDate, String assignedMedicalPersonnel) {
        this.patientId = patientId;
        this.name = name;
        this.checkInDate = checkInDate;
        this.assignedMedicalPersonnel = assignedMedicalPersonnel;
    } 
    
    @Override
    public String toString() {
        return("Patient ID: " + patientId + "\nName: " + name + "\nCheck in Date: "
                + checkInDate + "\nAssigned Medical Personal: " + assignedMedicalPersonnel);
    }
}
