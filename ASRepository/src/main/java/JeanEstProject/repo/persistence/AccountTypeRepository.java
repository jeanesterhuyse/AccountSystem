package JeanEstProject.repo.persistence;

import JeanEstProject.domain.dto.AccountTypeDTO;
import JeanEstProject.domain.persistence.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,
        Long> {
    @Query(value = "SELECT" +
            " TYPE_ID,"+
            " DATE_CREATED,"+
            " MNEMONIC," +
            " TYPE_NAME"+
            " FROM"+
            " ACCOUNTSYSTEM.ACCOUNTTYPE" +
            " WHERE MNEMONIC = :mnemonic", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);
    @Query(value = "SELECT" +
            " at"+
            " FROM"+
            " AccountType at"+
            " WHERE at.mnemonic = :mnemonic")
    AccountType getAccountTypeByMnemonic(String mnemonic);
    @Query(value = "SELECT new JeanEstProject.domain.dto.AccountTypeDTO( " +
            " at.mnemonic,"+
            " at.accountTypeName,"+
            " at.dateCreated ) "+
            " FROM " +
            " AccountType at" +
            " WHERE at.mnemonic = :mnemonic ")
    AccountTypeDTO getAccountTypeDTOByMnemonic(String mnemonic);
}


