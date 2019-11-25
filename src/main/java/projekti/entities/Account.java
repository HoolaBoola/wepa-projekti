/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.entities;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author hajajaim
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
public class Account extends AbstractPersistable<Long> {

    @OneToMany(mappedBy = "poster")
    private List<Image> images;

    @OneToMany(mappedBy = "account")
    private List<Message> messages;

    private String name;

    private String merkkijono;

    private String password;

    @ElementCollection(fetch = FetchType.EAGER)

    private List<String> authorities;

    @OneToMany
    private List<Account> followers;

    public boolean equals(Account other) {
        if (other == null) {
            return false;
        }

        if (!other.name.equals(this.name)) {
            return false;
        }

        if (!other.merkkijono.equals(this.merkkijono)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return name + ", " + merkkijono;
    }
}
