package JeanEstProject.repo.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import JeanEstProject.domain.dto.AccountTypeDTO;
import JeanEstProject.domain.persistence.AccountType;
import JeanEstProject.repo.config.RepositoryTestConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfig.class})
public class AccountTypeRepositoryTest {

    @Autowired
    AccountTypeRepository accountTypeRepository;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAccountTypeByMnemonicNativeQueryMiles() {
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonicNativeQuery("MILES");
        assertNotNull(miles);
        assertEquals("MILES", miles.getMnemonic());
    }

    @Test
    public void getAccountTypeByMnemonicNativeQuery() {
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonicNativeQuery("MILESS");
        assertNotNull(miles);
    }

    @Test
    public void getAccountTypeByMnemonicMiles() {
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonicNativeQuery("MILES");
        assertNotNull(miles);
        assertEquals("MILES", miles.getMnemonic());
    }

    @Test
    public void getAccountTypeByMnemonicPlay(){
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonicNativeQuery("PLAY");
        assertNotNull(miles);
        assertEquals("PLAY", miles.getMnemonic());
    }

    @Test
    public void getAccountTypeByMnemonic() {
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonic("R");
        assertNotNull(miles);
    }

    @Test
    public void getAccountTypeDtoByMnemonicMiles() {
        AccountTypeDTO miles = accountTypeRepository.getAccountTypeDTOByMnemonic("MILES");
        assertNotNull(miles);
        assertEquals("MILES", miles.getMnemonic());
    }

    @Test
    public void getAccountTypeDtoByMnemonicPlay(){
        AccountTypeDTO miles = accountTypeRepository.getAccountTypeDTOByMnemonic("PLAY");
        assertNotNull(miles);
        assertEquals("PLAY", miles.getMnemonic());
    }

    @Test
    public void getAccountTypeDtoByMnemonic() {
        AccountTypeDTO miles = accountTypeRepository.getAccountTypeDTOByMnemonic("R");
        assertNotNull(miles);
    }
}



