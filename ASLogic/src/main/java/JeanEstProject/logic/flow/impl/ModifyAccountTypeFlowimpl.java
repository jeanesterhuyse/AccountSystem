package JeanEstProject.logic.flow.impl;
import JeanEstProject.domain.dto.AccountTypeDTO;
import JeanEstProject.logic.flow.ModifyAccountTypeFlow;
import JeanEstProject.translator.AccountTypeTranslator;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Transactional
@Component("modifyAccountTypeFlowName")
public class ModifyAccountTypeFlowimpl implements ModifyAccountTypeFlow {
    private static final Logger LOGGER= LoggerFactory.getLogger(ModifyAccountTypeFlowimpl.class);

    private final AccountTypeTranslator accountTypeTranslator;

    public ModifyAccountTypeFlowimpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDTO deleteAccountType(String mnemonic) {
        return null;
    }

    @Override
    public AccountTypeDTO updateAccountType(String mnemonic, String newAccountTypeName, LocalDate newDateCreated) {
        LOGGER.info("Account type updated");
        return null;
    }
}


