/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.database;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author engau
 */
public class MySQLdbTest {
    
    public MySQLdbTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    public MySQLdb initDb(){
        MySQLdb db = new MySQLdb();
        db.setHost("localhost");
        db.setDatabase("ablightningbug");
        db.setUser("noroot");
        db.setPassword("noroot");
        return db;
    }
    @Test
    public void test_toString_Data(){
        System.out.println("--------------test_toString_Data");
        MySQLdb db = initDb();
        System.out.println( db );
    }

    /**
     * Test of open method, of class MySQLdb.
     */
    @Test
    public void test_MySQLdb_Open() {
        
        System.out.println("--------------test_MySQLdb_Open");
        MySQLdb db = initDb();
        if( !db.open() ){
            System.out.println( db.getErrors() );
            fail("It is not possible connect with the database.");
        }
        if( !db.close() ){
            System.out.println( db.getErrors() );
            fail("It is not possible close the connection with the database");
        }
        
    }
    /**
     * Test of open method, of class MySQLdb.
     */
    @Test
    public void test_MySQLdb_GetTables() {
        
        System.out.println("--------------test_MySQLdb_GetTables");
        MySQLdb db = initDb();
        if( !db.open() ){
            System.out.println( db.getErrors() );
            fail("It is not possible connect with the database.");
        }

        db.getTables();

        if( !db.close() ){
            System.out.println( db.getErrors() );
            fail("It is not possible close the connection with the database");
        }
        
    }
    
    
}
