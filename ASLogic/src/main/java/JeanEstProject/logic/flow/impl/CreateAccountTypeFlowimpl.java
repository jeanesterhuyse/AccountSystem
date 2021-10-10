package JeanEstProject.logic.flow.impl;
import JeanEstProject.domain.dto.AccountTypeDTO;
import JeanEstProject.logic.flow.CreateAccountTypeFlow;
import JeanEstProject.translator.AccountTypeTranslator;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowimpl implements CreateAccountTypeFlow {
    private static final Logger LOGGER= LoggerFactory.getLogger(CreateAccountTypeFlowimpl.class);
    private final AccountTypeTranslator accountTypeTranslator;
    public CreateAccountTypeFlowimpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator=accountTypeTranslator;
    }

    @Override
    public AccountTypeDTO create(AccountTypeDTO accountType){
        LOGGER.info("The received object: {}",accountType);
        if(null== accountType.getDateCreated()){
            accountType.setDateCreated(LocalDate.now());
        }
        accountTypeTranslator.someMethod();
        return accountTypeTranslator.create(accountType);
    }
}
