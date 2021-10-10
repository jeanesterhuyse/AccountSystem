package JeanEstProject.logic.flow.impl;
import JeanEstProject.domain.dto.AccountUserDTO;
import JeanEstProject.logic.flow.ModifyAccountUserFlow;
import JeanEstProject.translator.AccountUserTranslator;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;


@Component
public class ModifyAccountUserFlowimpl implements ModifyAccountUserFlow
{
    private static final Logger LOGGER= LoggerFactory.getLogger(ModifyAccountUserFlowimpl.class);

    private final AccountUserTranslator accountUserTranslator;

    public ModifyAccountUserFlowimpl(AccountUserTranslator accountUserTranslator)
    {
        this.accountUserTranslator = accountUserTranslator;
    }

    @Transactional
    @Override
    public AccountUserDTO subtractUnits(Long units, String memberID)
    {
        LOGGER.info("The received units to be subtracted: {}",units);
        LOGGER.info("The received memberID: {}",memberID);
        Long oldunits = 0L;
        oldunits =Long.parseLong(String.valueOf(accountUserTranslator.getAccountUserByMemberID(memberID).getTotalUnits()));
        Long newunits = oldunits - units;
        AccountUserDTO result =accountUserTranslator.updateMember(newunits, memberID);
        return result;
    }

    @Override
    public AccountUserDTO addUnits(Long units, String memberID)
    {
        LOGGER.info("The received units to be added: {}",units);
        LOGGER.info("The received memberID: {}",memberID);
        Long oldunits = 0L;

        oldunits =Long.parseLong(String.valueOf(accountUserTranslator.getAccountUserByMemberID(memberID).getTotalUnits()));


        Long newunits = oldunits + units;

        AccountUserDTO result =accountUserTranslator.updateMember(newunits, memberID);

        return result;
    }
}