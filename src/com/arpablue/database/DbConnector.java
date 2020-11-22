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
    public abstract ArrayList<String> executeQuery(String sql);
    /**
     * It return the columns ofthe last query.
     * @return 
     */
    public abstract ArrayList<String> getColums();
    /**
     * It reurn the description of table.
     * @param table It is the name of the table to get the description.
     * @return
     */
    public abstract  String getTableDescription(String table);
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
