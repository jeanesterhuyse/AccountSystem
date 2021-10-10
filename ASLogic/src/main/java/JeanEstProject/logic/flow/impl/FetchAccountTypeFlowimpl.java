package JeanEstProject.logic.flow.impl;

import JeanEstProject.domain.dto.AccountTypeDTO;
import JeanEstProject.logic.flow.FetchAccountTypeFlow;
import JeanEstProject.translator.AccountTypeTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Component
public class FetchAccountTypeFlowimpl implements FetchAccountTypeFlow {
    private static final Logger LOGGER= LoggerFactory.getLogger(FetchAccountTypeFlowimpl.class);

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowimpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator=accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDTO> getAllAccountTypes() {

        return accountTypeTranslator.getAllAccountTypes();
    }

    @Override
    public AccountTypeDTO getAccountTypeByMnemonic(String mnemonic){
        LOGGER.info("The received mnemonic: {}",mnemonic);
        return accountTypeTranslator.getAccountTypeByMnemonicNativeQuery(mnemonic);
    }

    public boolean methodTest(){
        return true;
    }
}
