/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTfacade;

import objects.Company;

/**
 *
 * @author Michael
 */
public interface CompanyFacade {
    public Company getCompany(String type, int typeNumber);
    public Company deleteCompany(int cvr);
    public Company editCompany(int cvr);
    
    
}
