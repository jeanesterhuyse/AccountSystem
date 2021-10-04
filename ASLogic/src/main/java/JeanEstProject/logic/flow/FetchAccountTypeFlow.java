package JeanEstProject.logic.flow;

import JeanEstProject.domain.dto.AccountTypeDTO;
import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDTO> getAllAccountTypes();
}
