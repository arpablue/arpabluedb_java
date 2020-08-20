/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.database;

import com.arpablue.interfaces.IChannel;
import com.arpablue.errors.ErrorCollector;

/**
 * It is the class base that content all setters and getters of the properties of the 
 * database connectors class.
 * @author Augusto Flores
 */
public abstract class DbConnectorBase implements IChannel {
    protected ErrorCollector mErrors = new ErrorCollector(); // It collecte the errors
    protected String mUser; // It is the the user usedd to connect to the database
    protected String mPwd; // It is the password for the connection of the database.
    protected String mHost; // It is the connection to the machine with the database.
    protected String mDbName; // It is the name of the database
    protected String mPort; // It is the connection of the database.
    protected String mType="None"; // It is the database type connection.

    private boolean isOpen;// It verify if the database is open or not.

    /**
     * It return the data of the connection in an string.
     * @return It is the string with the data of the string.
     */
    @Override
    public String toString(){
        String res = this.getType() + ": ";
        res += this.getHost();
        res += ":" + this.getPort();
        res += " - "+this.getDatabase();
        res += "( " + this.getUser() + " / " + this.getPassword() + " )";
        return res;
    }
    /**
     * It verify if the channel is open.
     * @return It is true of the channel is open.
     */
    @Override
    public boolean isOpen(){ return isOpen; }
    /**
     * It return the current error messages.
     * @return 
     */
    public ErrorCollector getErrors(){ return this.mErrors; }
    /**
     * It specify the type of the connection, or the database where is connected.
     * @param name It is the name of the connection or the database where is connected.
     */
    protected void setType( String name){
        mType = name;
        if( mType == null ){
            return;
        }
        mType = mType.trim();
    }
    /**
     * It return the connection type or name.
     * @return It return the type of the connection.
     */
    protected String getType(){ return mType; }
    /**
     * It specify the current state of the channel.
     * @param status It is the new status of the channel.
     */
    protected void setOpen(boolean status){ isOpen = status; }

    /**
     * It specify the user to be used to connect to the database.
     * @param user It is the user to be used for the connection.
     */
    public void setUser(String user ){
        mUser = user;
        if( mUser == null ){
            return;
        }
        mUser = mUser.trim();
    }
    /**
     * It return the current user.
     * @return It is the current user.
     */
    public String getUser(){  return mUser;  }

    /**
     * It specify the user to be used to connect to the database.
     * @param pwd It is the password used for the connection.
     */
    public void setPassword(String pwd ){ mPwd = pwd; }
    /**
     * It return the current user.
     * @return It is the current user.
     */
    public String getPassword(){  return mUser;  }
    /**
     * It specify the user to be used to connect to the database.
     * @param host It is the machine of the database.
     */
    public void setHost(String host ){
        mHost = host;
        if( mHost == null ){
            return;
        }
        mHost = mHost.trim();
    }
    /**
     * It return the current user.
     * @return It is the current host.
     */
    public String getHost(){  return mHost;  }
    /**
     * It specify the user to be used to connect to the database.
     * @param port It is the port to be used.
     */
    public void setPort(String port ){
        mPort = port;
        if( mPort == null ){
            return;
        }
        mPort = mPort.trim();
    }
    /**
     * It return the current user.
     * @return It is the current port.
     */
    public String getPort(){  return mPort;  }
    /**
     * It specify the user to be used to connect to the database.
     * @param db It is the database to be connected.
     */
    public void setDatabase(String db ){
        mDbName = db;
        if( mDbName == null ){
            return;
        }
        mDbName = mDbName.trim();
    }
    /**
     * It return the current user.
     * @return It is the current port.
     */
    public String getDatabase(){  return mDbName;  }
}
