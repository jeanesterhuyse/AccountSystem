package JeanEstProject.domain.persistence;
import JeanEstProject.domain.dto.AccountTypeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_USER", schema = "ACCOUNTSYSTEM")
public class AccountUser implements Serializable {
    private static final Logger LOGGER= LoggerFactory.getLogger(AccountTypeDTO.class);
    private static final long serialVersionUID = 2457651327422354751L;
    private String memberID;
    private String memberName;
    private LocalDate dateJoined;
    private Long totalUnits;


    public AccountUser()
    {

    }

    public AccountUser(String memberID, Long totalUnits) {
       LOGGER.info("Seperate constructor created for add and subtract purposes");
        this.memberID = memberID;
        this.totalUnits = totalUnits;

    }

    public AccountUser(String memberID, String memberName, LocalDate dateJoined, Long totalUnits) {
       LOGGER.info("AccountUser constructor created");
        this.memberID = memberID;
        this.memberName = memberName;
        this.dateJoined = dateJoined;
        this.totalUnits = totalUnits;

    }

    @Id
   @SequenceGenerator(name= "DISCOVERY_SEQ", sequenceName= "ACCOUNT_USER.DISCOVERY_SEQ", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "DISCOVERY_SEQ")
    @Column(name= "MEMBER_ID")

    public String getMemberID()
    {
        return memberID;
    }

    public void setMemberID(String memberID)
    {
        this.memberID = memberID;
    }

    @Column(name= "MEMBER_NAME")
    public String getMemberName()
    {
        return memberName;
    }

    public void setMemberName(String memberName)
    {
        this.memberName = memberName;
    }

    @Column(name= "DATE_JOINED")
    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Column(name= "TOTAL_UNITS")
    public Long getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Long totalUnits) {
        this.totalUnits = totalUnits;
    }

    @JoinColumn(name = "TYPE_ID")
    @ManyToOne(targetEntity = AccountType.class, fetch = FetchType.LAZY)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountUser that = (AccountUser) o;
        return Objects.equals(memberID, that.memberID) && Objects.equals(memberName, that.memberName) && Objects.equals(dateJoined, that.dateJoined) && Objects.equals(totalUnits, that.totalUnits) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, memberName, dateJoined, totalUnits);
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "memberID=" + memberID +
                ", memberName='" + memberName +
                ", dateJoined=" + dateJoined +
                ", totalMiles=" + totalUnits+
                '}';
    }
}
