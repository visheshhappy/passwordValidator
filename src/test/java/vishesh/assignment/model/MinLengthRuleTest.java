package vishesh.assignment.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.vishesh.assignment.exception.InvalidCredentials;
import org.vishesh.assignment.model.MinLengthRule;

public class MinLengthRuleTest {

    private MinLengthRule minLengthRule = new MinLengthRule(8);

    @Test
    public void testWhenLengthIsGreaterThanEight(){
        String password = "teestdummypass";
        Assertions.assertDoesNotThrow(()-> minLengthRule.execute(password));
    }

    @Test
    public void testWhenLengthIsLessThanEight(){
        String password = "teest";
        Assertions.assertThrows(InvalidCredentials.class, ()-> minLengthRule.execute(password));
    }

    @Test
    public void testWhenPasswordIsEmpty(){
        String password = "";
        Assertions.assertThrows(InvalidCredentials.class, ()-> minLengthRule.execute(password));
    }
}
