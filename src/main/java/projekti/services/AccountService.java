/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekti.entities.Account;
import projekti.repositories.AccountRepository;

/**
 *
 * @author hajajaim
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRep;

    public List<Account> list() {
        return accountRep.findAll();
    }

    public boolean addAccount(Account account) {
        if (account == null) {
            return false;
        }

        if (account.getAuthorities() == null
                || account.getFollowers() == null
                || account.getImages() == null
                || account.getMerkkijono() == null
                || account.getMerkkijono().isEmpty()
                || account.getUser() == null
                || account.getUser().isEmpty()
                || account.getPassword() == null
                || account.getPassword().isEmpty()
                || account.getMessages() == null) {
            return false;
        }
        
        if (!accountRep.findAll().contains(account)) {
            accountRep.save(account);
            return true;
        }
        
        return false;
    }

    public Account findByName(String username) {
        return accountRep.findByName(username);
    }
}
