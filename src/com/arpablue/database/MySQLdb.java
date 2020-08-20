/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.database;

import com.arpablue.tools.StringManager;
import java.sql.*;
import java.util.ArrayList;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.util.Properties;
import java.util.TimeZone;

/**
 *
 * @author engau
 */
public class MySQLdb extends DbConnector {

    protected String mPrefix = "jdbc:mysql:"; // It is the prefix of the connextion 
    protected Connection mCon;
    
    protected ArrayList<TableColumnData> mColumNames = new ArrayList<TableColumnData>();

    public MySQLdb() {
        this.setType("MySql_5.7.28");
        this.setPort("3306");
    }

    /**
     * It create and return the URL connection for MySQL.
     *
     * @return It is the URL connection.
     */
    protected String getURL() {
        if (this.getPort() == null) {
            mErrors.setError("(MySQLdb - getURL): The port is not specified.");
            return null;
        }
        if (this.getHost() == null) {
            mErrors.setError("(MySQLdb - getURL): The host is not specified.");
            return null;
        }
        if (this.getDatabase() == null) {
            mErrors.setError("(MySQLdb - getURL): The database is not specified.");
            return null;
        }
        if (this.getUser() == null) {
            mErrors.setError("(MySQLdb - getURL): The user is not specified.");
            return null;
        }
        if (this.getPassword() == null) {
            mErrors.setError("(MySQLdb - getURL): The password is not specified.");
            return null;
        }
        String res = this.mPrefix + "//";

        res += this.getHost();
        res += ":" + this.getPort();
        res += "/" + this.getDatabase();
        res += "?serverTimezone=" + TimeZone.getDefault().getID();
//        res += "&user=" + this.getUser();
//        res += "&password=" + this.getPassword();

        return res;
    }

    @Override
    public boolean open() {
        mErrors.clearErrors();
        String url = this.getURL();
        if (url == null) {
            return false;
        }
        if (this.isOpen()) {
            if (!this.close()) {
                mErrors.setError("(MySQLdb - open): It is not posible olpen athe connection because the previous connection is open.");
                return false;
            }
        }
        this.setOpen(false);
        try {
            mCon = DriverManager.getConnection(url, this.getUser(), this.getPassword());
            if (mCon == null) {
                mErrors.setError("(MySQLdb - open): It is not possible connect tioo the database.");
                return false;
            }
        } catch (Exception e) {
            mErrors.setError("(MySQLdb - open): " + e.getMessage());
            return false;
        }
        this.setOpen( true );
        return true;
    }
    @Override
    public boolean close() {
        mErrors.clearErrors();
        if (!isOpen()) {
            return true;
        }
        
        try {
            if (mCon != null) {
                mCon.close();
                this.setOpen(false);
            }
        } catch (Exception e) {
            mErrors.setError("(MySQLdb - close): " + e.getMessage());
            return false;
        }
        return true;
    }
    /**
     * It extract the data of the columns like names and quantity.
     * @param rs It is the result set to extract the data
     * @return It is true if the data has been collected without problems.
     */
    public boolean getColumData(ResultSet rs){
        if( rs == null ){
            return false;
        }
        mColumNames.clear();
        try{
            ResultSetMetaData rsmd=rs.getMetaData();
            int size = rsmd.getColumnCount();
            TableColumnData col;
            for (int i = 1; i < size+1; i++) {
                col = new TableColumnData();
                col.setName( rsmd.getColumnName( i ) );
                col.setType(rsmd.getColumnTypeName( i ) );
                this.mColumNames.add( col ); 
                
            }
        }catch( Exception e ){
            mErrors.setError( "(MySQLdb - getColumData): "+e.getMessage() );
        }
        return true;
    }
    /**
     * It execute a query in the database.
     *
     * @param query It is the sql sentences.
     */
    public void executeQuery(String sql) {
        System.out.println("Executing query: ["+sql+"]");
        Statement stmt = null;
        try {
            if (StringManager.isEmpty(sql)) {
                mErrors.setError("(MySQLdb - executeQuery): The sql sentences can not be empty.");
                System.out.println("Error 1");
                return;
            }
            if (!isOpen()) {
                mErrors.setError("(MySQLdb - executeQuery): The database connection is not open.");
                System.out.println("Error 2");
                return;
            }
            stmt = mCon.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if(!getColumData( rs )){
                System.out.println("Error 3");
                return;
            }
            System.out.println("...Showing"); 
            for( TableColumnData col : this.mColumNames){
                System.out.println("Column: ["+col+"]");
            }
//            ResultSetMetaData rsmd = rs.getMetaData();
//            int size = rsmd.getColumnCount();
//
//            // Extract data from result set
//            while (rs.next()) {
//                //Retrieve by column name
//                int id = rs.getInt("id");
//                int age = rs.getInt("age");
//                String first = rs.getString("first");
//                String last = rs.getString("last");
//                
//
//                //Display values
//                System.out.print("ID: " + id);
//                System.out.print(", Age: " + age);
//                System.out.print(", First: " + first);
//                System.out.println(", Last: " + last);
//            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            
        } catch (Exception e) {
            mErrors.setError("(MySQLdb - executeQuery):" + e.getMessage());
        }
    }
}
