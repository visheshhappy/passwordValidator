package vishesh.assignment.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.vishesh.assignment.exception.InvalidCredentials;
import org.vishesh.assignment.model.LengthRule;

public class LengthRuleTest {

    private LengthRule lengthRule = new LengthRule();

    @Test
    public void testWhenLengthIsGreaterThanEight(){
        String password = "teestdummypass";
        Assertions.assertDoesNotThrow(()->lengthRule.execute(password));
    }

    @Test
    public void testWhenLengthIsLessThanEight(){
        String password = "teest";
        Assertions.assertThrows(InvalidCredentials.class, ()->lengthRule.execute(password));
    }

    @Test
    public void testWhenPasswordIsEmpty(){
        String password = "";
        Assertions.assertThrows(InvalidCredentials.class, ()->lengthRule.execute(password));
    }
}
