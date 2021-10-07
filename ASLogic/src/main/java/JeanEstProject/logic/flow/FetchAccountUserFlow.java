package JeanEstProject.logic.flow;
import JeanEstProject.domain.dto.AccountUserDTO;
import java.util.List;

public interface FetchAccountUserFlow {
    List<AccountUserDTO> getAllAccountUsers();
    AccountUserDTO getAccountUserByMemberID(String memberID);
}
