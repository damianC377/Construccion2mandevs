package app.adapter.out.persistence;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.port.MedicalRecordPort;
import app.infrastructure.persistence.entities.MedicalRecordEntity;
import app.infrastructure.persistence.mapper.MedicalRecordMapper;
import app.infrastructure.persistence.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordAdapter implements MedicalRecordPort {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Override
    public void save(MedicalRecord medicalRecord) throws Exception {
        MedicalRecordEntity entity = MedicalRecordMapper.toEntity(medicalRecord);
        medicalRecordRepository.save(entity);
    }

    @Override
    public MedicalRecord findByPatient(Patient patient) throws Exception {
        MedicalRecordEntity entity = medicalRecordRepository.findByPatientId(patient.getId());
        return MedicalRecordMapper.toDomain(entity);
    }
}
