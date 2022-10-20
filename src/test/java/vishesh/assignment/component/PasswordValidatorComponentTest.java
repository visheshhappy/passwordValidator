package vishesh.assignment.component;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.vishesh.assignment.component.PasswordValidatorComponent;
import org.vishesh.assignment.exception.InvalidCredentials;
import org.vishesh.assignment.manager.RulesManager;
import org.vishesh.assignment.model.*;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PasswordValidatorComponentTest {

    @Mock
    private RulesManager rulesManager;

    @InjectMocks
    private PasswordValidatorComponent passwordValidatorComponent;

    private String password1 = "Abcd1234";
    private String password2 = "ABCDEFGHI";
    private String password3 = "abcd1234";
    private String password4 = "abcd";
    private String password5 = "AbdfeFGHii";


    @Test
    public void testValidatePassword_ForValidPassword(){
        Mockito.doReturn(getRules()).when(rulesManager).getRuleList();
        Assertions.assertDoesNotThrow(()->passwordValidatorComponent.validatePassword(password1));
    }

    @Test
    public void testValidatePassword_ForAllUpperCasePassword(){
        Mockito.doReturn(getRules()).when(rulesManager).getRuleList();
        Assertions.assertThrows(InvalidCredentials.class, ()->passwordValidatorComponent.validatePassword(password2));
    }

    @Test
    public void testValidatePassword_ForAllLowerCasePassword(){
        Mockito.doReturn(getRules()).when(rulesManager).getRuleList();
        Assertions.assertThrows(InvalidCredentials.class, ()->passwordValidatorComponent.validatePassword(password3));
    }

    @Test
    public void testValidatePassword_ForPasswordWithMinLengthLessThanRequired(){
        Mockito.doReturn(getRules()).when(rulesManager).getRuleList();
        Assertions.assertThrows(InvalidCredentials.class, ()->passwordValidatorComponent.validatePassword(password4));
    }

    @Test
    public void testValidatePassword_ForPasswordWithNoNumbers(){
        Mockito.doReturn(getRules()).when(rulesManager).getRuleList();
        Assertions.assertThrows(InvalidCredentials.class, ()->passwordValidatorComponent.validatePassword(password5));
    }

    private List<Rule> getRules(){

        return Arrays.asList(
                new MinLengthRule(8),
                new MinLetterUpperCaseRule(1),
                new MinLetterLowerCaseRule(1),
                new MinNumberRule(1)

        );

    }


}
