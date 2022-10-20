package vishesh.assignment.component;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.vishesh.assignment.component.PasswordValidatorComponent;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class PasswordValdatorComponentTest {

    private PasswordValidatorComponent passwordValidatorComponent = new PasswordValidatorComponent();

    @Test
    public void testValidatePassword(){
        String somePassword = "";
        Assertions.assertDoesNotThrow(()->passwordValidatorComponent.validatePassword(somePassword));
    }


}
