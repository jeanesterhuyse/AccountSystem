package JeanEstProject.domain.persistence;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNTTYPE", schema = "ACCOUNTSYSTEM")
public class AccountType implements Serializable {

    private Set<AccountTransaction> accountTransactions;
    private static final long serialVersionUID = 4151563717429808530L;
    @SequenceGenerator(name= "DISCOVERY_SEQ", sequenceName= "ACCOUNTSYSTEM.DISCOVERY_SEQ", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "DISCOVERY_SEQ")
    private Long TYPE_ID;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate dateCreated;

    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate) {
    }

    public AccountType(Long TYPE_ID, String mnemonic, String accountTypeName, LocalDate dateCreated) {
        this.TYPE_ID = TYPE_ID;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.dateCreated = dateCreated;
    }
    @Id
    @Column(name= "TYPE_ID")
    public Long getTYPE_ID() {
        return TYPE_ID;
    }

    public void setTYPE_ID(Long TYPE_ID) {
        this.TYPE_ID = TYPE_ID;
    }

    @Column(name= "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Column(name= "DATE_CREATED")
    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(name= "TYPE_NAME")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions(){
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(TYPE_ID, that.TYPE_ID) &&
                Objects.equals(mnemonic, that.mnemonic) &&
                Objects.equals(accountTypeName, that.accountTypeName) &&
                Objects.equals(dateCreated, that.dateCreated) &&
                Objects.equals(accountTransactions, that.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TYPE_ID, mnemonic, accountTypeName, dateCreated, accountTransactions);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "Type_ID='" + TYPE_ID + '\'' +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", dateCreated=" + dateCreated +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}