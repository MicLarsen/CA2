/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Michael
 */
@Entity
@Table(name = "CITYINFO")
public class CityInfo {

    @Id
    private int ZIP;
    private String CITY;

    public CityInfo() {
    }

    public CityInfo(int zipCode, String city) {
        this.ZIP = zipCode;
        this.CITY = city;
    }

    public int getZipCode() {
        return ZIP;
    }

    public String getCity() {
        return CITY;
    }
}
