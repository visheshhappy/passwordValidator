package org.vishesh.assignment.component;

import org.vishesh.assignment.exception.InvalidCredentials;
import org.vishesh.assignment.manager.RulesManager;
import org.vishesh.assignment.model.Rule;

public class PasswordValidatorComponentMinRules implements PasswordValidator{

    private final RulesManager rulesManager;
    private final int minRuleToPass;

    public PasswordValidatorComponentMinRules(RulesManager rulesManager, int minRuleToPass) {
        this.rulesManager = rulesManager;
        this.minRuleToPass = minRuleToPass;
    }

    @Override
    public void validatePassword(String password) {

        if(null == password) {
            throw new InvalidCredentials("Password is null", InvalidCredentials.ErrorCode.NULL_PASSWORD);
        }

        int count =0;
        boolean isValid = false;
        InvalidCredentials invalidCredentials = null;
        for(Rule rule : rulesManager.getRuleList()) {
            try{
                rule.execute(password);
                count++;
                if(count == minRuleToPass){
                    isValid = true;
                    break;
                }
            }catch (InvalidCredentials e){
                invalidCredentials = e;
            }
        }

        if(!isValid){
            throw invalidCredentials;
        }
    }
}
