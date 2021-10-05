package JeanEstProject.translator;

import JeanEstProject.domain.dto.AccountTypeDTO;

import java.util.List;

public interface AccountTypeTranslator {
    List<AccountTypeDTO>getAllAccountTypes();

    AccountTypeDTO create(AccountTypeDTO accountType);
    AccountTypeDTO getAccountTypeByMnemonicNativeQuery(String mnemonic);
    AccountTypeDTO getAccountTypeByMnemonic(String mnemonic);
    AccountTypeDTO getAccountTypeDTOByMnemonic(String mnemonic);
    void someMethod();


}
