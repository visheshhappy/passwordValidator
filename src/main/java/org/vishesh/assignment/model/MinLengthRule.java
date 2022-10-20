package org.vishesh.assignment.model;

import lombok.NonNull;
import org.vishesh.assignment.exception.InvalidCredentials;

import static org.vishesh.assignment.exception.InvalidCredentials.ErrorCode.MIN_LENGTH;

public class MinLengthRule implements Rule{

    private int minLengthRequired;

    public MinLengthRule(int minLengthRequired){
        this.minLengthRequired = minLengthRequired;
    }

    @Override
    public void execute(@NonNull final String password) {

        if(password.length() < minLengthRequired) {
            throw new InvalidCredentials("The password length is less than required.", MIN_LENGTH);
        }

    }
}
