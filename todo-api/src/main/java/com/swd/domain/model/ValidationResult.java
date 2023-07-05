package com.swd.domain.model;

import java.util.ArrayList;
import java.util.Collection;

public class ValidationResult {
    public boolean success;
    public Collection<ModelError> errors = new ArrayList<>();

    private StringBuilder stringBuilder = new StringBuilder();

    public String toString(){

        if(success) {
            stringBuilder.append("Validation successful.");
        } else {
            stringBuilder.append("Validation failed: ");

            for (ModelError item : errors) {
                stringBuilder.append(" \n ");
                stringBuilder.append(item.getErrorCode());
                stringBuilder.append("-");
                stringBuilder.append(item.getErrorMessage());
            }
        }

        return stringBuilder.toString();
    }
}
