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

    private static MongoClient mongoClient = null;

    public static MongoClient getMongoClient() {
        if (mongoClient == null) {
            try {
                mongoClient = new MongoClient("localhost", 27017);

            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
        return mongoClient;
    }


    public void closeMongoClient() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

}
