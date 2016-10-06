/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Persistence;

/**
 *
 * @author Michael
 */
public class schemaBuilder {
    
    public static void main(String[] args) {
        
        Map<String, String> prorperties = new HashMap();
//        prorperties.put("javax.persistence.sql-load-script-source", "SQL/buildDatabase.sql");
        prorperties.put("javax.persistence.sql-load-script-source", "SQL/populate.sql");
//        prorperties.put("javax.persistence.sql-load-script-source", "SQL/SQLQueryTests.sql");
        
        Persistence.generateSchema("CA2", prorperties);
    }
    
}
