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
@Inheritance(strategy = InheritanceType.JOINED)
abstract public class InfoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String email;
    
    @OneToMany(mappedBy = "infoEntity")
    protected List<Phone> phones;
                       
    @ManyToOne
    protected Address address;
        
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

}
