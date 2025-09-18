package app.domain.services;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.MedicalRecordPort;
import app.domain.port.PatientPort;

public class MedicalRecordGetByPatientService {
	
    private PatientPort patientPort;
    private MedicalRecordPort medicalRecordPort;
    private UserRequireAnyRoleService RequireAnyRoleService;
	
	// Consultar historia clínica
    public MedicalRecord getByPatient(Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        MedicalRecord record = medicalRecordPort.findByPatient(patient);
        if (record == null) {
            throw new Exception("El paciente no tiene historia clínica registrada");
        }
        
        RequireAnyRoleService.requireAnyRole(Role.NURSE, Role.DOCTOR);

        return record;
    }
}
