package JeanEstProject.logic.flow.impl;
import JeanEstProject.domain.dto.AccountTypeDTO;
import JeanEstProject.logic.flow.ModifyAccountTypeFlow;
import JeanEstProject.translator.AccountTypeTranslator;
import java.time.LocalDate;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Transactional
@Component("modifyAccountTypeFlowName")
public class ModifyAccountTypeFlowimpl implements ModifyAccountTypeFlow {
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
        return null;
    }
}


