
package app.domain.services;

import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.MedicalOrderPort;
import app.domain.port.PatientPort;


import java.util.List;


public class SearchMedicalOrderByPatientService {
    private MedicalOrderPort medicalOrderPort;
    private PatientPort patientPort;
    private UserRequireAnyRoleService RequireAnyRoleService;




    // Consultar las órdenes médicas de un paciente
    public List<MedicalOrder> search(Patient patient) throws Exception {
        // Validar si el paciente existe
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        List<MedicalOrder> orders = medicalOrderPort.findByPatient(patient);
        if (orders == null || orders.isEmpty()) {
            throw new Exception("El paciente no tiene órdenes médicas registradas");
        }
        
        RequireAnyRoleService.requireAnyRole(Role.NURSE, Role.DOCTOR);
        
        return orders;
    }


}
