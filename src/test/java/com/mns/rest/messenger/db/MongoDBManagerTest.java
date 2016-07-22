/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mns.rest.messenger.db;

import com.mongodb.MongoClient;
import org.glassfish.hk2.utilities.reflection.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mns
 */
public class MongoDBManagerTest {
    
    public MongoDBManagerTest() {
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

    /**
     * Test of getMongoClient method, of class MongoDBManager.
     */
    @Test
    public void testGetMongoClient() {
        System.out.println("getMongoClient");
        MongoClient expResult = null;
        MongoClient client = MongoDBManager.getMongoClient();
        
        System.out.println(client.getDatabaseNames().toString());
        
    }

    /**
     * Test of closeMongoClient method, of class MongoDBManager.
     */
    @Test
    public void testCloseMongoClient() {
        System.out.println("closeMongoClient");
        MongoDBManager instance = new MongoDBManager();
        instance.closeMongoClient();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
