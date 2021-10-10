package JeanEstProject.logic.flow;

import JeanEstProject.domain.dto.AccountUserDTO;

import javax.transaction.Transactional;

public interface ModifyAccountUserFlow {

@Transactional
AccountUserDTO subtractUnits(Long units, String memberID);
@Transactional
AccountUserDTO addUnits(Long units,String memberID);
}