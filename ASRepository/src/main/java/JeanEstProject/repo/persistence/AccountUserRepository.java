package JeanEstProject.repo.persistence;

import JeanEstProject.domain.dto.AccountUserDTO;
import JeanEstProject.domain.persistence.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser,
        Long> {
    @Query(value = "SELECT" +
            " MEMBER_ID,"+
            " MEMBER_NAME"+
            " DATE_JOINED,"+
            " TOTAL_MILES," +
            " FROM"+
            " ACCOUNTSYSTEM.ACCOUNT_USER" +
            " WHERE MEMBER_ID = :memberID", nativeQuery = true)
    AccountUser getAccountUserByMemberIDNativeQuery(String memberID);
    @Query(value = "SELECT" +
            " at"+
            " FROM"+
            " AccountUser at"+
            " WHERE at.memberID = :memberID")
    AccountUser getAccountUserByMemberID(String memberID);
    @Query(value = "SELECT new JeanEstProject.domain.dto.AccountUserDTO( " +
            " at.memberID,"+
            " at.memberName,"+
            " at.dateJoined, "+
            "at.totalMiles)"+
            " FROM " +
            " AccountUser at" +
            " WHERE at.memberID = :memberID ")
    AccountUserDTO getAccountUserDTOByMemberID(String memberID);
}



