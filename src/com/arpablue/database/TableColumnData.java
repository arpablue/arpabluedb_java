/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.database;

import java.sql.ResultSetMetaData;

/**
 *
 * @author engau
 */
public class TableColumnData {
    protected String mName, mType;
    /**
     * It format a string, if the string is empty return null.
     * @param target It is the string to format.
     * @return I is the string on format.
     */
    public static String format(String name){
        if( name  == null ) {
            return null;
        }
        name = name.trim();
        if( name.length() < 1){
            return null;
        }
        return name;
    }
    @Override
    public String toString(){
        String res = this.getName()+" - "+this.getType();
        return res;
    }
    /**
     * It specify the name of the column.
     * @param name It is the of the column.
     */
    public void setName(String name){   mName = format(name); }
    /**
     * It return the name of the column,
     * @return It is the name of the column..
     */
    public String getName(){ return mName; }
    /**
     * It specify the name of the column.
     * @param name It is the of the column.
     */
    public void setType(String value){   mType = format( value ); }
    /**
     * It return the name of the column,
     * @return It is the name of the column..
     */
    public String getType(){ return mType; }
    
}
