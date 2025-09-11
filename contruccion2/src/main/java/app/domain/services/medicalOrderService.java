
package app.domain.services;

import app.domain.model.MedicalOrder;
import app.domain.model.enums.Role;
import app.domain.port.MedicalOrderPort;

public class medicalOrderService  {
    private MedicalOrderPort medicalOrderPort;



    public void creatmedicalOrder(MedicalOrder order) throws Exception{

//verificando que la orden no pude estar vacia
        if (order == null) {
            throw new Exception("La orden no puede estar vacia ");

        }
//Verificacion de personal        
        if (order.getDoctor().getRole() != Role.DOCTOR){
            throw new Exception("Solo personal autorizado ");
        }

        if (order.getPatient()== null || order.getDoctor()== null){
            throw new Exception("La orden debe de tener paciente y doctor ");

        }
//Orden creada
medicalOrderPort.save(order);        
         System.out.println("La orde se ha creado correctamente"+ order);
    }
        
}
