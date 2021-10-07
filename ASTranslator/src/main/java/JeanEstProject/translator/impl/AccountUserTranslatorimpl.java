package JeanEstProject.translator.impl;
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
        return accountUserDtos;
    }


    @Override
    public AccountUserDTO create(AccountUserDTO accountUserDto) {
        try{
            AccountUser accountUser = accountUserRepository.save(accountUserDto.getAccountUser());
            return new AccountUserDTO(accountUser);
        } catch(Exception e){
            throw new RuntimeException("cant save to the database",e);
        }
    }

    @Override
    public AccountUserDTO getAccountUserByMemberIDNativeQuery(String memberID) {
        try{
            AccountUser accountUser = accountUserRepository.getAccountUserByMemberIDNativeQuery(memberID);
            return new AccountUserDTO(accountUser);
        } catch(Exception e){
            throw new RuntimeException("cant save to the database",e);
        }
    }

    @Override
    public AccountUserDTO getAccountUserByMemberID(String memberID) {
        try{
            AccountUser accountUser = accountUserRepository.getAccountUserByMemberID(memberID);
            return new AccountUserDTO(accountUser);
        } catch(Exception e){
            throw new RuntimeException("cant save to the database",e);
        }
    }

    @Override
    public AccountUserDTO getAccountUserDTOByMemberID(String memberID) {
        return null;
    }



    public AccountUserDTO getAccountUserDtoByMemberID(String memberID) {
        try{
            return accountUserRepository.getAccountUserDTOByMemberID(memberID);
        } catch(Exception e){
            throw new RuntimeException("cant save to the database",e);
        }
    }


}


