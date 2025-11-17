package app.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.MedicalRecordBuilder;
import app.adapter.rest.request.MedicalRecordRequest;
import app.adapter.rest.response.MedicalRecordResponse;
import app.domain.model.MedicalRecord;
import app.domain.model.MedicalOrder;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Collections;

@Component
public class MedicalRecordRestMapper {

    @Autowired
    private MedicalRecordBuilder medicalRecordBuilder;

    @Autowired
    private MedicalOrderRestMapper medicalOrderRestMapper;

    public MedicalRecord toDomain(MedicalRecordRequest req) throws Exception {
        if (req == null) return null;

        List<MedicalOrder> orders;
        if (req.getOrders() != null && !req.getOrders().isEmpty()) {
            orders = new java.util.ArrayList<>();
            for (var r : req.getOrders()) {
                orders.add(medicalOrderRestMapper.toDomain(r));
            }
        } else {
            orders = Collections.emptyList();
        }

        return medicalRecordBuilder.build(
                req.getPatientDocument(),
                req.getDoctorDocument(),
                req.getOrderDate(),
                req.getConsultationReason(),
                req.getSymptoms(),
                req.getDiagnosis(),
                orders
        );
    }

    public MedicalRecordResponse toResponse(MedicalRecord domain) {
        if (domain == null) return null;

        MedicalRecordResponse res = new MedicalRecordResponse();
        res.setId(domain.getId());
        res.setPatientDocument(domain.getPatient() != null ? domain.getPatient().getDocument() : 0);
        res.setOrderDate(domain.getOrderDate());
        res.setDoctorDocument(domain.getDoctor() != null ? String.valueOf(domain.getDoctor().getDocument()) : null);
        res.setConsultationReason(domain.getConsultationReason());
        res.setSymptoms(domain.getSymptoms());
        res.setDiagnosis(domain.getDiagnosis());

        if (domain.getOrders() != null && !domain.getOrders().isEmpty()) {
            res.setOrders(domain.getOrders().stream().map(medicalOrderRestMapper::toResponse).collect(Collectors.toList()));
        }

        return res;
    }
}
