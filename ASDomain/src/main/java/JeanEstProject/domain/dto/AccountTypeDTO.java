package JeanEstProject.domain.dto;

import JeanEstProject.domain.persistence.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value="AccountType",description="A dto that represents the accounttype")
public class AccountTypeDTO implements Serializable {
    private static final Logger LOGGER= LoggerFactory.getLogger(AccountTypeDTO.class);
    private static final long serialVersionUID = -8228431668035557598L;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate dateCreated;

    public AccountTypeDTO(AccountTypeDTO accountType) {

    }

    public AccountTypeDTO(String mnemonic, String accountTypeName, LocalDate dateCreated) {
        LOGGER.info("Constructor created AccountTypeDTO");
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.dateCreated = dateCreated;
    }

    public AccountTypeDTO(AccountType accountType){
        this.setMnemonic(accountType.getMnemonic());
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setDateCreated(accountType.getDateCreated());
    }

    public AccountTypeDTO() {
    }

    @ApiModelProperty(position=1,
            value= "AccountType Mnemonic",
            name="Mnemonic",
            notes="Account type gets identified uniquely by a Mnemonic",
            dataType= "java.lang.String",
            example="MILES",
            required=true)
    public String getMnemonic() {

        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {

        this.mnemonic = mnemonic;
    }

    @ApiModelProperty(position=2,
            value= "AccountType Name",
            name="Name",
            notes="Name assigned to a account type",
            dataType= "java.lang.String",
            example="Miles",
            allowEmptyValue=false,
            required=true)
    public String getAccountTypeName() {

        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {

        this.accountTypeName = accountTypeName;
    }

    @ApiModelProperty(position=3,
            value= "AccountType Creation Date",
            name="CreationDate",
            notes="Date that the account type was created",
            dataType= "java.lang.String",
            example="2019-01-01",
            allowEmptyValue=true,
            required=false)

    public LocalDate getDateCreated() {

        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {

        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDTO that = (AccountTypeDTO) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(dateCreated, that.dateCreated);
    }

    @JsonIgnore
    public AccountType getAccountType(){
        LOGGER.info("JsonIgnore done");
        return new AccountType(getMnemonic(),getAccountTypeName(),getDateCreated());
    }
    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, accountTypeName, dateCreated);
    }

    @Override
    public String toString() {
        return "AccountTypeDTO{" +
                "mnemonic='" + mnemonic +
                ", accountTypeName='" + accountTypeName +
                ", creationDate=" + dateCreated +
                '}';
    }
}
