package com.mns.rest.messenger.db;
import com.mns.rest.messenger.model.User;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mns on 8/7/16.
 */
public class DataStore {
    private static Map<String,User> userMap = new HashMap<>();
    public static Map<String,User> getUserMap(){
        return userMap;
    }
}
