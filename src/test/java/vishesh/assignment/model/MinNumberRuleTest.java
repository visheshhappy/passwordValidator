package vishesh.assignment.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.vishesh.assignment.exception.InvalidCredentials;
import org.vishesh.assignment.model.MinNumberRule;

public class MinNumberRuleTest {

    private MinNumberRule minNumberRule
            = new MinNumberRule(1);

    @Test
    public void testWhenLengthIsGreaterThanRequiredLength(){
        String password = "te111tdUmmypass";
        Assertions.assertDoesNotThrow(()-> minNumberRule.execute(password));
    }

    @Test
    public void testWhenLengthIsEqualToRequiredLength(){
        String password = "te9tdUmmypass";
        Assertions.assertDoesNotThrow(()-> minNumberRule.execute(password));
    }

    @Test
    public void testWhenLengthIsLessThanEight(){
        String password = "teSSst";
        Assertions.assertThrows(InvalidCredentials.class, ()-> minNumberRule.execute(password));
    }

    @Test
    public void testWhenPasswordIsEmpty(){
        String password = "";
        Assertions.assertThrows(InvalidCredentials.class, ()-> minNumberRule.execute(password));
    }
}
