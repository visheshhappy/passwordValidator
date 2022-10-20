package org.vishesh.assignment.model;

import lombok.NonNull;
import org.vishesh.assignment.exception.InvalidCredentials;

import static org.vishesh.assignment.exception.InvalidCredentials.ErrorCode.MIN_LOWER_CASE;

public class MinLetterLowerCaseRule implements Rule {

    private int minLowerCaseLetterRequired;

    public  MinLetterLowerCaseRule(int minLowerCaseLetterRequired){
        this.minLowerCaseLetterRequired = minLowerCaseLetterRequired;
    }

    @Override
    public void execute(@NonNull final String password) {

        int count =0;
        for (char c : password.toCharArray()) {
            int ascii = (int) c;
            if( ascii >=97 && ascii <= 126){
                count++;
            }
        }

        if(count < minLowerCaseLetterRequired){
            throw new InvalidCredentials("Min lower case letter not found", MIN_LOWER_CASE);
        }

    }
}
