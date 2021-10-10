package JeanEstProject.domain.dto;
import JeanEstProject.domain.persistence.AccountUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Objects;
import java.io.Serializable;

@ApiModel(value="AccountUser",description="A dto that represents the account user")
public class AccountUserDTO implements Serializable {
    private static final Logger LOGGER= LoggerFactory.getLogger(AccountUserDTO.class);
    private static final long serialVersionUID = 8320124586839145675L;
    private String memberID;
    private String memberName;
    private LocalDate dateJoined;
    private Long totalUnits;

    public AccountUserDTO(AccountUserDTO accountUser) {
    }

    public AccountUserDTO(String memberID, String memberName, LocalDate dateJoined, Long totalUnits) {
       LOGGER.info("Constructor made for AccountUserDTO");
        this.memberID = memberID;
        this.memberName = memberName;
        this.dateJoined = dateJoined;
        this.totalUnits = totalUnits;
    }

    public AccountUserDTO(AccountUser accountUser) {
       this.setMemberID(accountUser.getMemberID());
       this.setMemberName(accountUser.getMemberName());
        this.setDateJoined(accountUser.getDateJoined());
        this.setTotalUnits(accountUser.getTotalUnits());
    }

    public AccountUserDTO() {
    }

    @ApiModelProperty(position=1,
            value= "MEMBER_ID",
            name="MEMBER_ID",
            notes="Uniquely identifies user",
            dataType= "java.lang.String",
            example="112",
            required=true)
    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    @ApiModelProperty(position=2,
            value= "Member name",
            name="MEMBER_NAME",
            notes="The name of the member",
            dataType= "java.lang.String",
            example="Jean",
            allowEmptyValue=false,
            required=true)
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @ApiModelProperty(position=3,
            value= "Date joined",
            name="DATE_JOINED",
            notes="The date that the member joined Discovery",
            dataType= "java.lang.String",
            example="2019-01-01",
            allowEmptyValue=false,
            required=true)
    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    @ApiModelProperty(position=4,
            value= "Total Units",
            name="TOTAL_UNITS",
            notes="Total Units assigned to member",
            dataType= "java.lang.Long",
            example="250",
            allowEmptyValue=false,
            required=true)
    public Long getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Long totalUnits) {
        this.totalUnits = totalUnits;
    }

    @JsonIgnore
    public AccountUser getAccountUser(){
        return new AccountUser(getMemberID(),getMemberName(),getDateJoined(),getTotalUnits());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountUserDTO that = (AccountUserDTO) o;
        return Objects.equals(memberID, that.memberID) && Objects.equals(memberName, that.memberName) && Objects.equals(dateJoined, that.dateJoined) && Objects.equals(totalUnits, that.totalUnits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, memberName, dateJoined, totalUnits);
    }

    @Override
    public String toString() {
        return "AccountUserDTO{" +
                "memberID=" + memberID +
                ", memberName='" + memberName +
                ", dateJoined=" + dateJoined +
                ", totalUnits=" + totalUnits +
                '}';
    }
}
