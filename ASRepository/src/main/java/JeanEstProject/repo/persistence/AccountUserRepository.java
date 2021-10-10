package JeanEstProject.repo.persistence;

import JeanEstProject.domain.persistence.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser,
        Long> {
    @Query(value = "SELECT " +
            "au "+
            "FROM "+
            "AccountUser au "+
            "WHERE au.memberID = :memberID ")
    AccountUser getAccountUserByMemberID(@Param("memberID") String memberID);

    @Modifying
    @Query(value = "UPDATE " +
            "AccountUser au "+
            "SET au.totalUnits = :totalUnits "+
            "WHERE au.memberID = :memberID ")
    void updateMember(@Param("totalUnits") Long newUnits,@Param("memberID")String memberID);

}



