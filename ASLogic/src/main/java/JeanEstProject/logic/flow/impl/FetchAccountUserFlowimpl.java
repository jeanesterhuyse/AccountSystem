package JeanEstProject.logic.flow.impl;

import JeanEstProject.domain.dto.AccountUserDTO;
import JeanEstProject.logic.flow.FetchAccountUserFlow;
import JeanEstProject.translator.AccountUserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Component
public class FetchAccountUserFlowimpl implements FetchAccountUserFlow {

    private final AccountUserTranslator accountUserTranslator;

    @Autowired
    public FetchAccountUserFlowimpl(AccountUserTranslator accountUserTranslator){
        this.accountUserTranslator=accountUserTranslator;
    }
    @Override
    public List<AccountUserDTO> getAllAccountUsers() {
        return accountUserTranslator.getAllAccountUsers();
    }
    @Override
    public AccountUserDTO getAccountUserByMemberID(String memberID){
        return accountUserTranslator.getAccountUserByMemberIDNativeQuery(memberID);
    }

}
