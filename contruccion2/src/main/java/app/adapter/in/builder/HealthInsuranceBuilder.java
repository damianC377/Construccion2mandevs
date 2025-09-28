package app.adapter.in.builder;

import app.adapter.in.validators.HealthInsuranceValidator;
import app.domain.model.HealthInsurance;

public class HealthInsuranceBuilder {

    private HealthInsuranceValidator healthInsuranceValidator;

    public HealthInsurance build(String companyName, String policyNumber,
                                 String active, String endDate) throws Exception {

        HealthInsurance healthInsurance = new HealthInsurance();

        healthInsurance.setCompanyName(healthInsuranceValidator.companyNameValidator(companyName));
        healthInsurance.setPolicyNumber(healthInsuranceValidator.policyNumberValidator(policyNumber));
        healthInsurance.setActive(healthInsuranceValidator.activeValidator(active));
        healthInsurance.setEndDate(healthInsuranceValidator.endDateValidator(endDate));

        return healthInsurance;
    }
}
