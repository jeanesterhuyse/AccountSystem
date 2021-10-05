package JeanEstProject.translator.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import JeanEstProject.domain.dto.AccountTypeDTO;
import JeanEstProject.domain.persistence.AccountType;
import JeanEstProject.repo.persistence.AccountTypeRepository;
import JeanEstProject.translator.AccountTypeTranslator;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorimpl implements AccountTypeTranslator {

    private final AccountTypeRepository accountTypeRepository;
    @Autowired
    public AccountTypeTranslatorimpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }
    @Override
    public List<AccountTypeDTO> getAllAccountTypes(){
        List<AccountTypeDTO> accountTypeDtos = new ArrayList<>();
        try {
            for (AccountType accountType : accountTypeRepository.findAll()){
                accountTypeDtos.add(new AccountTypeDTO(accountType));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return accountTypeDtos;
    }


    @Override
    public AccountTypeDTO create(AccountTypeDTO accountTypeDto) {
        try{
            AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDTO(accountType);
        } catch(Exception e){
            throw new RuntimeException("cant save to the database",e);
        }
    }

    @Override
    public AccountTypeDTO getAccountTypeByMnemonicNativeQuery(String mnemonic) {
        try{
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonicNativeQuery(mnemonic);
            return new AccountTypeDTO(accountType);
        } catch(Exception e){
            throw new RuntimeException("cant save to the database",e);
        }
    }

    @Override
    public AccountTypeDTO getAccountTypeByMnemonic(String mnemonic) {
        try{
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDTO(accountType);
        } catch(Exception e){
            throw new RuntimeException("cant save to the database",e);
        }
    }

    @Override
    public AccountTypeDTO getAccountTypeDTOByMnemonic(String mnemonic) {
        return null;
    }

    @Override
    public void someMethod() {

    }

    public AccountTypeDTO getAccountTypeDtoByMnemonic(String mnemonic) {
        try{
            return accountTypeRepository.getAccountTypeDTOByMnemonic(mnemonic);
        } catch(Exception e){
            throw new RuntimeException("cant save to the database",e);
        }
    }


}


