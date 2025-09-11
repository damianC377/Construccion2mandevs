package app.domain.port;

import app.domain.model.MedicalOrder;

public interface MedicalOrderPort {
    public void creatmedicalOrder(MedicalOrder order) throws Exception;

    public void save(MedicalOrder order) throws Exception;

}
