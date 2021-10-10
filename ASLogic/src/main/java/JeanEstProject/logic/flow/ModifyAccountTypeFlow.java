package JeanEstProject.logic.flow;

import JeanEstProject.domain.dto.AccountTypeDTO;

import java.time.LocalDate;

public interface ModifyAccountTypeFlow {
    AccountTypeDTO deleteAccountType(String mnemonic);
    AccountTypeDTO updateAccountType(String mnemonic, String newAccountTypeName, LocalDate newDateCreated);
}
