package test;

import JPA.CompanyJPA;
import java.util.ArrayList;
import java.util.List;
import objects.Address;
import objects.CityInfo;
import objects.Company;
import objects.InfoEntity;
import objects.Phone;

/**
 *
 * @author nickl
 */
public class companyJPATestRUN {

    public static void main(String[] args) {

        CompanyJPA cjpa = new CompanyJPA();
        
        Company comp = new Company("Nicklas A/S", "test", 12345678, 2, 200000);
        comp.setEmail("NicklasMolving@gmail.com");
        comp.setAddress(new Address("Hej", "ldsf", new CityInfo(3992, "Slædepatrulje Sirius")));
        List<Phone> phones = new ArrayList();
        phones.add(new Phone(52506288, "new phone"));
        comp.setPhones(phones);
        comp.addIEToPhone();

        cjpa.createCompany(comp);

        Company c = cjpa.getCompanyByCVR(12345678);
        System.out.println(c.getName());
        
        Company c2 = cjpa.getCompanyByPhone(52506288);
        System.out.println(c2.getCvr());
        
    }

}
