package JeanEstProject.logic.flow.impl;
import JeanEstProject.domain.dto.AccountUserDTO;
import JeanEstProject.logic.flow.CreateAccountUserFlow;
import JeanEstProject.translator.AccountUserTranslator;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Transactional
@Component("createAccountUserFlowName")
public class CreateAccountUserFlowimpl implements CreateAccountUserFlow {
    private static final Logger LOGGER= LoggerFactory.getLogger(CreateAccountUserFlowimpl.class);

    private final AccountUserTranslator accountUserTranslator;
    public CreateAccountUserFlowimpl(AccountUserTranslator accountUserTranslator){
        this.accountUserTranslator=accountUserTranslator;
    }
    @Override
    public AccountUserDTO create(AccountUserDTO accountUser){
        LOGGER.info("The received object: {}",accountUser);
        if(null== accountUser.getDateJoined()){
            accountUser.setDateJoined(LocalDate.now());
        }

        return accountUserTranslator.create(accountUser);
    }
}

