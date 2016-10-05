package RESTfacade;

import objects.Company;

/**
 *
 * @author Michael
 */
public interface CompanyFacade {
    public Company getCompany(int cvr);
    public boolean deleteCompany(int cvr);
    public boolean editCompany(Company comp);
    public boolean createCompany(Company comp);
    
    
}
