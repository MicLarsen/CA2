package test;

import JPA.CompanyJPA;
import objects.Company;
import objects.InfoEntity;

/**
 *
 * @author nickl
 */
public class companyJPATestRUN {
    
    public static void main(String[] args) {
        
        CompanyJPA cjpa = new CompanyJPA();
        Company comp = new Company("Nicklas A/S", "test", 12345678, 2, 200000);
        
        cjpa.createCompany(comp);
        
        Company c = cjpa.getCompanyByCVR(12345678);
        System.out.println(c.getName());
    }
    
}
