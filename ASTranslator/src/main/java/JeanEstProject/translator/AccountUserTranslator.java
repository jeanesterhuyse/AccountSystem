package JeanEstProject.translator;

import JeanEstProject.domain.dto.AccountUserDTO;

import java.util.List;

public interface AccountUserTranslator {
    List<AccountUserDTO>getAllAccountUsers();

    AccountUserDTO create(AccountUserDTO accountUser);
    AccountUserDTO getAccountUserByMemberIDNativeQuery(String memberID);
    AccountUserDTO getAccountUserByMemberID(String memberID);
    AccountUserDTO getAccountUserDTOByMemberID(String memberID);



}
