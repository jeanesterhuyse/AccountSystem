package JeanEstProject.translator.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import JeanEstProject.domain.dto.AccountUserDTO;
import JeanEstProject.domain.persistence.AccountUser;
import JeanEstProject.repo.persistence.AccountUserRepository;
import JeanEstProject.translator.AccountUserTranslator;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountUserTranslatorimpl implements AccountUserTranslator {
    private static final Logger LOGGER= LoggerFactory.getLogger(AccountTypeTranslatorimpl.class);


    private final AccountUserRepository accountUserRepository;
    @Autowired
    public AccountUserTranslatorimpl(AccountUserRepository accountUserRepository) {
        this.accountUserRepository = accountUserRepository;
    }
    @Override
    public List<AccountUserDTO> getAllAccountUsers(){
        List<AccountUserDTO> accountUserDtos = new ArrayList<>();
        try {
            for (AccountUser accountUser : accountUserRepository.findAll()){
                accountUserDtos.add(new AccountUserDTO(accountUser));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
        LOGGER.info("Got all users");
        return accountUserDtos;
    }

    @Override
    public AccountUserDTO create(AccountUserDTO accountUserDto) {
        LOGGER.info("Object received: {}",accountUserDto);
        try{
            AccountUser accountUser = accountUserRepository.save(accountUserDto.getAccountUser());
            return new AccountUserDTO(accountUser);
        } catch(Exception e){
            throw new RuntimeException("Cant save to the database",e);
        }
    }

    @Override
    public AccountUserDTO getAccountUserByMemberID(String memberID) {
        LOGGER.info("MemberID received: {}",memberID);
        try{
            AccountUser au = accountUserRepository.getAccountUserByMemberID(memberID);
            return new AccountUserDTO(au);
        } catch(Exception e){
            throw new RuntimeException("Cant connect to the database",e);
        }
    }

    @Override
    public AccountUserDTO updateMember(Long newUnits, String memberID) {
        LOGGER.info("MemberID received: {}",memberID);
        LOGGER.info("Units received: {}",newUnits);
        try{
            AccountUser au = new AccountUser(memberID,newUnits);
            accountUserRepository.updateMember(newUnits,memberID);
            return null;
        }catch (Exception e)
        {
            throw new RuntimeException("Cant update the table",e);
        }
    }



}


