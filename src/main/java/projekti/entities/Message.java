/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.entities;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

/**
 *
 * @author hajajaim
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message extends AbstractPersistable<Long>{
    
    @ManyToOne
    private Account account;
    
    @Column
    private Timestamp timestamp;
}
