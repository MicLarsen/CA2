package objects;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Michael
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class InfoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String email;
    
    
    @OneToMany(mappedBy = "infoEntity")
    private List<Phone> phones;
                       
    @ManyToOne
    private Address address;
        
    public InfoEntity(){}
    
    public InfoEntity(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
