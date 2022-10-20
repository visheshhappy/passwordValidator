package org.vishesh.assignment.model;

import org.vishesh.assignment.exception.InvalidCredentials;

import static org.vishesh.assignment.exception.InvalidCredentials.ErrorCode.MIN_NUMBER;

public class MinNumberRule implements Rule{

    private int minNumberRequired;

    public MinNumberRule(int  minNumberRequired){
        this.minNumberRequired = minNumberRequired;
    }

    @Override
    public void execute(String password) {
        int count =0;
        for (char c : password.toCharArray()) {
            int ascii = (int) c;
            if( ascii >=48 && ascii <= 57){
                count++;
            }
        }

        if(count < minNumberRequired){
            throw new InvalidCredentials("Password does contain min Numbers", MIN_NUMBER);
        }
    }
}
