package projekti;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import projekti.entities.Account;
import projekti.repositories.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountTest extends org.fluentlenium.adapter.junit.FluentTest {

    @LocalServerPort
    private Integer port;
    
    @Autowired
    private AccountRepository accountRep;
    
    @Test
    public void luoAccount(){
        Account account = new Account();
        
        account.setName("James Bond");
        account.setMerkkijono("Ja");
        
        accountRep.save(account);
        
        assertTrue(accountRep.findAll().contains(account));
    }
}
