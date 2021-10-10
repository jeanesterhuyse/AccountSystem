package JeanEstProject.translator;

import JeanEstProject.domain.dto.AccountUserDTO;
import java.util.List;

public interface AccountUserTranslator {
    List<AccountUserDTO>getAllAccountUsers();
    AccountUserDTO create(AccountUserDTO accountUser);
    AccountUserDTO getAccountUserByMemberID(String memberID);
    AccountUserDTO updateMember(Long newUnits, String memberID);





}
