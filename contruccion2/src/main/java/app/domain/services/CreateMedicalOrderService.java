package app.domain.services;



import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.port.MedicalOrderPort;
import app.domain.port.PatientPort;
import app.domain.port.UserPort;

public class CreateMedicalOrderService {
	 private MedicalOrderPort medicalOrderPort;
	private PatientPort patientPort;
	private UserRequireRoleService userRequireRole;
	 private UserPort userPort;
	 
	  public void createMedicalOrder(MedicalOrder order) throws Exception{
		  // Validar si el paciente existe
	        Patient patient = patientPort.findByDocument(order.getPatient());
	        if (patient == null) {
	            throw new Exception("El paciente no existe");
	        }
	      //Verificacion de personal, cambiar al metodo require role
	        User doctor = userPort.findByDocument(order.getDoctor());
	        
	        userRequireRole.requireRole(Role.DOCTOR);
	        
	        order.setPatient(patient);
	        order.setDoctor(doctor);

	        //Orden creada
	        medicalOrderPort.save(order);
	        
	        
	  }
	  
	
	
}
