package io.openliberty.samples.contextvarinvalidator;

public class IllegalPhoneNumberFormatException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;

    IllegalPhoneNumberFormatException(String message) {
        super(message);
    }

    

}