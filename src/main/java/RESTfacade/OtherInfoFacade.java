/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTfacade;

import java.util.List;
import objects.Address;
import objects.CityInfo;
import objects.Phone;

/**
 *
 * @author Michael
 */
public interface OtherInfoFacade {
    
    public List<Phone> getPhone(String type, String name);
    public List<Phone> getPhone(String type, int id);
    public Address getAddress();
    public List<CityInfo> getCityInfo();
}
