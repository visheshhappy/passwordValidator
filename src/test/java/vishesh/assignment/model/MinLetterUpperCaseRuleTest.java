package vishesh.assignment.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.vishesh.assignment.exception.InvalidCredentials;
import org.vishesh.assignment.model.MinLetterUpperCaseRule;

public class MinLetterUpperCaseRuleTest {


    private MinLetterUpperCaseRule minLetterUpperCaseRule
            = new MinLetterUpperCaseRule(1);

    @Test
    public void testWhenLengthIsGreaterThanEight(){
        String password = "teestdUmmypass";
        Assertions.assertDoesNotThrow(()-> minLetterUpperCaseRule.execute(password));
    }

    @Test
    public void testWhenLengthIsLessThanEight(){
        String password = "teest";
        Assertions.assertThrows(InvalidCredentials.class, ()-> minLetterUpperCaseRule.execute(password));
    }

    @Test
    public void testWhenPasswordIsEmpty(){
        String password = "";
        Assertions.assertThrows(InvalidCredentials.class, ()-> minLetterUpperCaseRule.execute(password));
    }
}
