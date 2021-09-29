package JeanEstProject.domain.exception;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name= "ACCOUNTTYPE",schema= "ACCOUNTSYSTEM")
public class AccountType implements Serializable {
    @Id
    @SequenceGenerator(name= "DiscoverySequence", sequenceName= "ACCOUNTSYSTEM.DiscoverySequence", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "DiscoverySequence")

    private String AT_ID;
    private String memonic;
    private String accountTypeName;
    private LocalDate dateCreated;
    private Set<AccountTransaction>accountTransaction;
    public AccountType(String AT_ID, String memonic, String accountTypeName, LocalDate dateCreated) {
        this.AT_ID = AT_ID;
        this.memonic = memonic;
        this.accountTypeName = accountTypeName;
        this.dateCreated = dateCreated;
    }

    public AccountType() {
    }
    @Column(name= "AT_ID")
    public String getAT_ID() {
        return AT_ID;
    }

    public void setAT_ID(String AT_ID) {
        this.AT_ID = AT_ID;
    }
    @Column(name= "MEMONIC")
    public String getMemonic() {
        return memonic;
    }

    public void setMemonic(String memonic) {
        this.memonic = memonic;
    }
    @Column(name= "TYPE_NAME")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }
    @Column(name= "DATE_CREATED")
    public LocalDate getDateCreated() {
        return dateCreated;
    }


    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransaction(){
        return accountTransaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(AT_ID, that.AT_ID) &&
                Objects.equals(memonic, that.memonic) &&
                Objects.equals(accountTypeName, that.accountTypeName) &&
                Objects.equals(dateCreated, that.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AT_ID, memonic, accountTypeName, dateCreated);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "AT_ID='" + AT_ID + '\'' +
                ", memonic='" + memonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
