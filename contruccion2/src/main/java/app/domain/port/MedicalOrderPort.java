package app.domain.port;

import app.domain.model.MedicalOrder;
import app.domain.model.Patient;

import java.util.List;

public interface MedicalOrderPort {
    public void createMedicalOrder(MedicalOrder order) throws Exception;

    public void save(MedicalOrder order) throws Exception;

    List<MedicalOrder> findByPatient(Patient patient);

}
