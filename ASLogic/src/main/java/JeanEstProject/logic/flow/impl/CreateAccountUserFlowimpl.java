package JeanEstProject.logic.flow.impl;
import JeanEstProject.domain.dto.AccountUserDTO;
import JeanEstProject.logic.flow.CreateAccountUserFlow;
import JeanEstProject.translator.AccountUserTranslator;
import java.time.LocalDate;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Transactional
@Component("createAccountUserFlowName")
public class CreateAccountUserFlowimpl implements CreateAccountUserFlow {
    private final AccountUserTranslator accountUserTranslator;
    public CreateAccountUserFlowimpl(AccountUserTranslator accountUserTranslator){
        this.accountUserTranslator=accountUserTranslator;
    }
    @Override
    public AccountUserDTO create(AccountUserDTO accountUser){
        if(null== accountUser.getDateJoined()){
            accountUser.setDateJoined(LocalDate.now());
        }

        return accountUserTranslator.create(accountUser);
    }
}

