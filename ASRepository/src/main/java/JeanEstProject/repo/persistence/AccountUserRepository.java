package JeanEstProject.repo.persistence;

import JeanEstProject.domain.dto.AccountTypeDTO;
import JeanEstProject.domain.persistence.AccountUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser,
        Long> {
    @Query(value = "SELECT " +
            " au "+
            " FROM "+
            " AccountUser au "+
            " WHERE au.memberID = :member ")
    AccountUser getAccountUserByMemberID(@Param("member") String memberID);

    @Modifying
    @Query(value = "UPDATE " +
            " AccountUser au "+
            " SET au.totalUnits = :tu "+
            " WHERE au.memberID = :member ")
    void updateMember(@Param("tu") Long newUnits,@Param("member")String memberID);

}



