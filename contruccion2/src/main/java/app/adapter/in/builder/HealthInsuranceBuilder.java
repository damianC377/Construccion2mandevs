package app.adapter.in.builder;

import app.adapter.in.validators.HealthInsuranceValidator;
import app.domain.model.HealthInsurance;
import app.domain.model.Patient;

public class HealthInsuranceBuilder {

    private final HealthInsuranceValidator healthInsuranceValidator;

    public HealthInsurance build(Patient patient, String companyName, String policyNumber,
                                 String active, String endDate) throws Exception {

        HealthInsurance healthInsurance = new HealthInsurance();

        healthInsurance.setPatient(healthInsuranceValidator.patientValidator(patient));
        healthInsurance.setCompanyName(healthInsuranceValidator.companyNameValidator(companyName));
        healthInsurance.setPolicyNumber(healthInsuranceValidator.policyNumberValidator(policyNumber));
        healthInsurance.setActive(healthInsuranceValidator.activeValidator(active));
        healthInsurance.setEndDate(healthInsuranceValidator.endDateValidator(endDate));

        return healthInsurance;
    }
}
