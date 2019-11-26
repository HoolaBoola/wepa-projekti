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

    public void addAccount(Account account) {
        if (account == null) {
            return;
        }
        if (!accountRep.findAll().contains(account)) {
            accountRep.save(account);
        }

    }

    public Account findByName(String username) {
        return accountRep.findByName(username);
    }
}
