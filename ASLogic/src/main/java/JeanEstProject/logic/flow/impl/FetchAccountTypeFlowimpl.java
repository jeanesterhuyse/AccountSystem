package JeanEstProject.logic.flow.impl;

import JeanEstProject.domain.dto.AccountTypeDTO;
import JeanEstProject.logic.flow.FetchAccountTypeFlow;
import JeanEstProject.translator.AccountTypeTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Component
public class FetchAccountTypeFlowimpl implements FetchAccountTypeFlow {
private final AccountTypeTranslator accountTypeTranslator;

@Autowired
public FetchAccountTypeFlowimpl(AccountTypeTranslator accountTypeTranslator){
    this.accountTypeTranslator=accountTypeTranslator;
}
@Override
    public List<AccountTypeDTO> getAllAccountTypes() {
        return accountTypeTranslator.getAllAccountTypes();
    }
}