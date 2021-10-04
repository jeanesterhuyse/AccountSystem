package JeanEstProject.translator.impl;
import JeanEstProject.translator.AccountTypeTranslator;
import JeanEstProject.domain.persistence.AccountType;
import JeanEstProject.repo.persistence.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import JeanEstProject.domain.dto.AccountTypeDTO;
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
    public List<AccountTypeDTO> getAllAccountTypes() {
        List<AccountTypeDTO> accountTypeDtos = new ArrayList<>();
        try {
            for (AccountType accountType : accountTypeRepository.findAll()) {
                accountTypeDtos.add(new AccountTypeDTO(accountType));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the Database  ", e);
        }
        return accountTypeDtos;
    }
}
