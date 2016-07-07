/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mns.rest.messenger.db;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 *
 * @author mns
 */
public class MongoDBManager {

    public static void init() {
        try {

            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // Now connect to your databases
            DB db = mongoClient.getDB("test");
            System.out.println(db.getCollectionNames().toString());
            System.out.println("Connect to database successfully");
            //boolean auth = db.authenticate(myUserName, myPassword);
            //System.out.println("Authentication: " + auth);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
}

