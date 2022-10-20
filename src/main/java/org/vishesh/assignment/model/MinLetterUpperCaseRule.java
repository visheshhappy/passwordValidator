package org.vishesh.assignment.model;

import org.vishesh.assignment.exception.InvalidCredentials;

import static org.vishesh.assignment.exception.InvalidCredentials.ErrorCode.MIN_UPPER_CASE;

public class MinLetterUpperCaseRule implements Rule{

    private int minUpperCaseLetterRequired;

    public  MinLetterUpperCaseRule(int minUpperCaseLetterRequired){
        this.minUpperCaseLetterRequired = minUpperCaseLetterRequired;
    }


    @Override
    public void execute(String password) {
        int count =0;
        for (char c : password.toCharArray()) {
            int ascii = (int) c;
            if( ascii >=65 && ascii <= 90){
                count++;
            }
        }

        if(count < minUpperCaseLetterRequired){
            throw new InvalidCredentials("Min upper case letter not found", MIN_UPPER_CASE);
        }
    }
}
