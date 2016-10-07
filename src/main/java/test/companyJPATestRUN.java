package test;

import JPA.CompanyJPA;
import JPA.PersonJPA;
import java.util.ArrayList;
import java.util.List;
import objects.Address;
import objects.CityInfo;
import objects.Company;
import objects.Hobby;
import objects.Person;
import objects.Phone;

/**
 *
 * @author nickl
 */
public class companyJPATestRUN {

    public static void main(String[] args) {

        CompanyJPA cjpa = new CompanyJPA();
        PersonJPA pjpa = new PersonJPA();
        
        Company comp = new Company("Nicklas A/S", "test", 12345678, 2, 200000);
        comp.setEmail("NicklasMolving@gmail.com");
        comp.setAddress(new Address("Hej", "ldsf", new CityInfo(3992, "Slædepatrulje Sirius")));
        List<Phone> phones = new ArrayList();
        phones.add(new Phone(52506288, "new phone"));
        comp.setPhones(phones);
        comp.addIEToPhone();

//        cjpa.createCompany(comp);
//        
////        System.out.println("GET COMPANY BY CVR!!!");
////        Company c = cjpa.getCompanyByCVR(12345678);
////        System.out.println(c.getName());
////        System.out.println(c.getPhones().get(0).getNumber());
////        System.out.println(c.getAddress().getStreet());
////        
////        System.out.println("\nGET COMPANY BY PHONE!!!");
////        Company c2 = cjpa.getCompanyByPhone(52506288);
////        System.out.println(c2.getCvr());
////        System.out.println(c2.getName());
////        
////        
////        Company comp2 = new Company("Michael A/S", "Test", 13245678, 2, 200000);
////        Company comp3 = new Company("Nicolai A/S", "Test", 13255678, 1, 200000);
////        
////        cjpa.createCompany(comp2);
////        cjpa.createCompany(comp3);
////        System.out.println("\nLIST OF COMPANIES!!!");
////        List<Company> companies = cjpa.getCompaniesWithXOrMoreEmpl(2);
////        System.out.println(companies.size());





//        List<Hobby> hobbies = new ArrayList();
//        hobbies.add(new Hobby("guitar", "sdsf"));
//
//        Person p = new Person("Nicklas", "Molving", new Address("Hej", "asd", new CityInfo(3992, "Slædepatrulje Sirius")), hobbies, phones);
//        
//        pjpa.addPerson(p);
//        
//        List<Person> persons = pjpa.getPersonsByZip(3992);
//        System.out.println(persons.get(0).getFirstName());
//        
//        
//        persons = pjpa.getAllPersonWithHobby(new Hobby("guitar", "sdsf"));
//        
//        System.out.println(persons.get(0).getFirstName());
//        
//        System.out.println(pjpa.getHobbyCount(hobbies.get(0)));
//        
    }

}
