package vishesh.assignment.manager;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.vishesh.assignment.exception.BusinessException;
import org.vishesh.assignment.manager.RulesManager;
import org.vishesh.assignment.model.MinLengthRule;

import java.util.ArrayList;
import java.util.Arrays;

public class RulesManagerTest {

    private RulesManager rulesManager;

    @Test
    public void testRulesLength(){
        rulesManager = new RulesManager(Arrays.asList(new MinLengthRule(1)));
        Assertions.assertEquals(1, rulesManager.getRuleList().size());
    }

    @Test
    public void testRulesLengthForEmptyRules(){
        rulesManager = new RulesManager(new ArrayList());
        Assertions.assertEquals(0, rulesManager.getRuleList().size());
    }

    @Test
    public void testNullRules(){
        Assertions.assertThrows(BusinessException.class,  ()->new RulesManager(null));
    }

}
