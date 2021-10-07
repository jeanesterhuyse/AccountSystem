package JeanEstProject.logic.flow;

import JeanEstProject.domain.dto.AccountUserDTO;

import java.time.LocalDate;

public interface ModifyAccountUserFlow {
    AccountUserDTO deleteAccountUser(String memberID);

    AccountUserDTO updateAccountUser(String memberID, String newMemberName, LocalDate newDateJoined, Long newTotalMiles);
}