package vishesh.assignment.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.vishesh.assignment.exception.InvalidCredentials;
import org.vishesh.assignment.model.MinLetterLowerCaseRule;

public class MinLetterLowerCaseRuleTest {


    private MinLetterLowerCaseRule minLengthRule = new MinLetterLowerCaseRule(1);

    @Test
    public void testWhenLengthIsGreaterThanEight(){
        String password = "tEESTDUMMYPASS";
        Assertions.assertDoesNotThrow(()-> minLengthRule.execute(password));
    }

    @Test
    public void testWhenLengthIsLessThanEight(){
        String password = "TEEST";
        Assertions.assertThrows(InvalidCredentials.class, ()-> minLengthRule.execute(password));
    }

    @Test
    public void testWhenPasswordIsEmpty(){
        String password = "";
        Assertions.assertThrows(InvalidCredentials.class, ()-> minLengthRule.execute(password));
    }
}
