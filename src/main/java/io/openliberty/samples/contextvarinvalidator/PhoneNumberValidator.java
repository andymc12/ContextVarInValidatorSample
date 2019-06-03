package io.openliberty.samples.contextvarinvalidator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequestScoped
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    @Inject
    CustomerResource customerResource;
 
    @Override
    public boolean isValid(String vTelephone, ConstraintValidatorContext pContext) {
        // Get the country in here using the original resource instance
        final String vCountry = customerResource.getHeaderString("COUNTRY");
        try {
            validate(vTelephone, vCountry);
        } catch (Throwable t) {
            System.out.printf("Error parsing {0} as a phone number in {1}: {2}", vTelephone, vCountry, t.getMessage());
            return false;
        }
        return true;
    }

    private void validate(String vTelephone, String vCountry) {
        if ("UK".equals(vCountry) && !vTelephone.startsWith("44")) {
            throw new IllegalPhoneNumberFormatException("UK phone numbers must start with 44");
        }
        if ("US".equals(vCountry) && !vTelephone.startsWith("1")) {
            throw new IllegalPhoneNumberFormatException("US phone numbers must start with 1");
        }
        // ... other validations...
    }
}