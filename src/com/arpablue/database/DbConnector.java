/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.database;

import java.util.ArrayList;

/**
 * It class contains all method to execute SQL sentences over the database,
 * @author Augusto Flores
 */
public abstract class DbConnector extends DbConnectorBase{  
    /**
     * It execute an SQL sentences and return the response.
     * @param sql 
     */
    public abstract void executeQuery(String sql);
    /**
     * It return the tables of the database.
     * @return It is the list of the tables in the database.
     */
    public ArrayList<String> getTables(){
        ArrayList<String> res = new ArrayList<String>();
        executeQuery("SHOW TABLES");
        return res;
    }
    
}
