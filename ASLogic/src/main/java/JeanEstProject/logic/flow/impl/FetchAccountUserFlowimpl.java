package JeanEstProject.logic.flow.impl;

import JeanEstProject.domain.dto.AccountUserDTO;
import JeanEstProject.logic.flow.FetchAccountUserFlow;
import JeanEstProject.translator.AccountUserTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountUserFlowimpl implements FetchAccountUserFlow {
    private static final Logger LOGGER= LoggerFactory.getLogger(FetchAccountUserFlowimpl.class);

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
        LOGGER.info("The received ID: {}",memberID);
        try {
            return accountUserTranslator.getAccountUserByMemberID(memberID);
        }catch (Exception e)
        {
            throw new RuntimeException("Can not read from db",e);
        }
    }

}
