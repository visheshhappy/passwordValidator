package vishesh.assignment.component;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.vishesh.assignment.component.PasswordValidator;
import org.vishesh.assignment.component.PasswordValidatorComponentMinRules;
import org.vishesh.assignment.exception.InvalidCredentials;
import org.vishesh.assignment.manager.RulesManager;
import org.vishesh.assignment.model.*;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PasswordValidatorComponentMinRulesTest {

    @Mock
    private RulesManager rulesManager;
    private PasswordValidator passwordValidatorComponent;

    private String password1 = "Abcd1234";
    private String password2 = "ABCDEFGHI";
    private String password3 = "abcd1234";
    private String password4 = "abcd";
    private String password5 = "AbdfeFGHii";

    @Before
    public void setUp(){
       passwordValidatorComponent = new PasswordValidatorComponentMinRules(rulesManager, 3);
    }

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
        Assertions.assertDoesNotThrow(()->passwordValidatorComponent.validatePassword(password3));
    }

    @Test
    public void testValidatePassword_ForPasswordWithMinLengthLessThanRequired(){
        Mockito.doReturn(getRules()).when(rulesManager).getRuleList();
        Assertions.assertThrows(InvalidCredentials.class, ()->passwordValidatorComponent.validatePassword(password4));
    }

    @Test
    public void testValidatePassword_ForPasswordWithNoNumbers(){
        Mockito.doReturn(getRules()).when(rulesManager).getRuleList();
        Assertions.assertDoesNotThrow(()->passwordValidatorComponent.validatePassword(password5));
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
