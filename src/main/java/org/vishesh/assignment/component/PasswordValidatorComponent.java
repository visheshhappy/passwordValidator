package org.vishesh.assignment.component;

import org.vishesh.assignment.exception.InvalidCredentials;
import org.vishesh.assignment.manager.RulesManager;
import org.vishesh.assignment.model.Rule;

public class PasswordValidatorComponent {

    private final RulesManager rulesManager;

    public PasswordValidatorComponent(RulesManager rulesManager) {
        this.rulesManager = rulesManager;
    }

    public void validatePassword(final String password){

        if(null == password) {
            throw new InvalidCredentials("Password is null", InvalidCredentials.ErrorCode.NULL_PASSWORD);
        }

        for(Rule rule : rulesManager.getRuleList()) {
            rule.execute(password);
        }
    }

}
