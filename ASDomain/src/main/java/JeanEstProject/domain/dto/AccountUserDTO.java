package JeanEstProject.domain.dto;


import JeanEstProject.domain.persistence.AccountUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value="AccountUser",description="A dto that represents the account user")
public class AccountUserDTO implements Serializable {
    private static final long serialVersionUID = 4619913205443709973L;
    private String memberID;
    private String memberName;
    private LocalDate dateJoined;
    private Long totalMiles;


    public AccountUserDTO(AccountUserDTO accountUser) {
    }

    public AccountUserDTO(String memberID, String memberName, LocalDate dateJoined, Long totalMiles) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.dateJoined = dateJoined;
        this.totalMiles = totalMiles;
    }
    public AccountUserDTO(AccountUser accountUser) {
       this.setMemberID(accountUser.getMemberID());
       this.setMemberName(accountUser.getMemberName());
        this.setDateJoined(accountUser.getDateJoined());
        this.setTotalMiles(accountUser.getTotalMiles());

    }
    public AccountUserDTO() {
    }

    @ApiModelProperty(position=1,
            value= "MEMBER_ID",
            name="MEMBER_ID",
            notes="Uniquely identifies user",
            dataType= "java.lang.String",
            example="123",
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
            example="Rian",
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
            notes="The date that the member joined",
            dataType= "java.lang.String",
            example="2020-01-01",
            allowEmptyValue=false,
            required=true)
    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    @ApiModelProperty(position=4,
            value= "Total Miles",
            name="TOTAL_MILES",
            notes="Total miles of member",
            dataType= "java.lang.String",
            example="200",
            allowEmptyValue=false,
            required=true)
    public Long getTotalMiles() {
        return totalMiles;
    }

    public void setTotalMiles(Long totalMiles) {
        this.totalMiles = totalMiles;
    }

    @JsonIgnore
    public AccountUser getAccountUser(){
        return new AccountUser(getMemberID(),getMemberName(),getDateJoined(),getTotalMiles());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountUserDTO that = (AccountUserDTO) o;
        return Objects.equals(memberID, that.memberID) && Objects.equals(memberName, that.memberName) && Objects.equals(dateJoined, that.dateJoined) && Objects.equals(totalMiles, that.totalMiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, memberName, dateJoined, totalMiles);
    }

    @Override
    public String toString() {
        return "AccountUserDTO{" +
                "memberID=" + memberID +
                ", memberName='" + memberName + '\'' +
                ", dateJoined=" + dateJoined +
                ", totalMiles=" + totalMiles +
                '}';
    }
}
