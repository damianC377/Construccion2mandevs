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
	 private UserPort userPort;
	 
	  public void createMedicalOrder(MedicalOrder order) throws Exception{
		  // Validar si el paciente existe
	        Patient patient = patientPort.findByDocument(order.getPatient());
	        if (patient == null) {
	            throw new Exception("El paciente no existe");
	        }
	      //Verificacion de personal, cambiar al metodo require role
	        User doctor = userPort.findByDocument(order.getDoctor());
	        if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
	            throw new Exception("Solo personal autorizado ");
	        }
	        order.setPatient(patient);
	        order.setDoctor(doctor);

	        //Orden creada
	        medicalOrderPort.save(order);
	        
	        
	  }
	  
	
	
}
