package JeanEstProject.logic.flow.impl;
import JeanEstProject.domain.dto.AccountUserDTO;
import JeanEstProject.logic.flow.ModifyAccountUserFlow;
import JeanEstProject.translator.AccountUserTranslator;
import java.time.LocalDate;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Transactional
@Component("modifyAccountUserFlowName")
public class ModifyAccountUserFlowimpl implements ModifyAccountUserFlow {
    private final AccountUserTranslator accountUserTranslator;

    public ModifyAccountUserFlowimpl(AccountUserTranslator accountUserTranslator) {
        this.accountUserTranslator = accountUserTranslator;
    }

    @Override
    public AccountUserDTO deleteAccountUser(String memberID) {
        return null;
    }

    @Override
    public AccountUserDTO updateAccountUser(String memberID, String memberName, LocalDate dateJoined, Long totalMiles) {
        return null;
    }
}