package JeanEstProject.logic.flow.impl;

import JeanEstProject.domain.dto.AccountTypeDTO;
import JeanEstProject.translator.AccountTypeTranslator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeFlowimplTest {
    @Mock
    private AccountTypeTranslator translator;
  @InjectMocks
    private CreateAccountTypeFlowimpl flow;



    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        doThrow(new RuntimeException()).when(translator).someMethod();
        try {
            flow.create(new AccountTypeDTO());
            fail("Should throw exception");
        } catch (Exception e){

        }
        verify(translator,times(1)).someMethod();
        verify(translator,never()).create(any(AccountTypeDTO.class));

    }
}