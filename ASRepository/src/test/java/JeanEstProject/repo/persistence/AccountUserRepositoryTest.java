package JeanEstProject.repo.persistence;

import JeanEstProject.domain.persistence.AccountUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import JeanEstProject.repo.config.RepositoryTestConfig;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfig.class})
public class AccountUserRepositoryTest {

    @Autowired
    AccountUserRepository accountUserRepository;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAccountUserByMemberID() {
        AccountUser au = accountUserRepository.getAccountUserByMemberID("112");
        assertNotNull(au);
    }
    @Test
    public void updateMember() {
       accountUserRepository.updateMember(5L,"112");

    }
}




