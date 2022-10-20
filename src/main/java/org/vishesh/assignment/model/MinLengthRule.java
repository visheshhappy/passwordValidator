package org.vishesh.assignment.model;

import org.vishesh.assignment.exception.InvalidCredentials;

import static org.vishesh.assignment.exception.InvalidCredentials.ErrorCode.MIN_LENGTH;

public class LengthRule implements Rule{

    private int minLengthRequired = 8;

    @Override
    public void execute(String password) {

        if(password.length() < minLengthRequired) {
            throw new InvalidCredentials("The password length is less than required.", MIN_LENGTH);
        }

    }
}
