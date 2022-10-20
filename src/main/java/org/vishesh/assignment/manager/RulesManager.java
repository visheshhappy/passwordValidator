package org.vishesh.assignment.manager;

import lombok.NonNull;
import org.vishesh.assignment.exception.BusinessException;
import org.vishesh.assignment.model.Rule;

import java.util.List;

public class RulesManager {

    private List<Rule> ruleList;

    public RulesManager(final List<Rule> rules){
        if(null == rules ){
            throw new BusinessException("Rules cannot be null");
        }
        this.ruleList = rules;
    }

    public List<Rule> getRuleList() {
        return ruleList;
    }





}
