package com.mns.rest.messenger.service;

import com.mns.rest.messenger.db.DataStore;
import com.mns.rest.messenger.model.Message;

import java.util.ArrayList;
import java.util.Map;


public class MessageService {

    private Map<String, ArrayList<Message>> userMessageMap = DataStore.getUserMessageMap();
    private static MessageService messageServiceInstance = null;

    private MessageService() {

    }

    public static MessageService getInstance() {
        if (messageServiceInstance == null) {
            messageServiceInstance = new MessageService();
        }
        return messageServiceInstance;
    }


    public void initUserMessageStore(String userPhoneNum) {
        userMessageMap.put(userPhoneNum, new ArrayList<Message>());
    }

    public Message addMessage(String sender, String receiver, String message) {

        ArrayList<Message> allMessages = userMessageMap.get(sender);
        ArrayList<Message> allMessagesFromReceiver = getMessageReceiver(sender,receiver);
        String id = "1";
        if (allMessagesFromReceiver.size() > 0) {
            id = "" + (Integer.parseInt(allMessagesFromReceiver.get(allMessagesFromReceiver.size() - 1).getId()) + 1);
        }
        Message message1 = new Message(id,message,receiver);
        allMessages.add(message1);
        return message1;
    }

    public void deleteMessage(String sender,String receiver,String id){
        ArrayList<Message> allMessages = userMessageMap.get(sender);
        allMessages.remove(new Message(id,null,receiver));
    }

    public void deleteMessages(String sender) {
        ArrayList<Message> allMessages = userMessageMap.get(sender);
        allMessages.clear();
    }

    public void deleteMessageReceiver(String sender,String receiver){
        ArrayList<Message> filteredMessages = new ArrayList<>();
        ArrayList<Message> allMessages = userMessageMap.get(sender);
        for(Message msg : allMessages){
            if(!msg.getReceiverPhoneNumber().contentEquals(receiver)) {
                filteredMessages.add(msg);
            }
        }
        userMessageMap.put(sender,filteredMessages);
    }

    public Message getMessage(String sender,String receiver,String id) {
        ArrayList<Message> allMessagesFromReceiver = getMessageReceiver(sender,receiver);
        for(Message msg : allMessagesFromReceiver){
            if(msg.getId().contentEquals(id)){
                return  msg;
            }
        }
        return null;
    }

    public ArrayList<Message> getMessages(String sender){
        ArrayList<Message> allMessages = userMessageMap.get(sender);
        return allMessages;
    }

    public ArrayList<Message> getMessageReceiver(String sender, String receiver) {
        ArrayList<Message> allMessages = userMessageMap.get(sender);
        ArrayList<Message> filteredMessages = new ArrayList<>();
        for (Message msg : allMessages) {
            if (msg.getReceiverPhoneNumber().contentEquals(receiver)) {
                filteredMessages.add(msg);
            }
        }

        return filteredMessages;
    }
}
