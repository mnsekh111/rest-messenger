package com.mns.rest.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
import java.util.Date;


@XmlRootElement
public class Message {
    private String id;
    private String content;
    private String receiverPhoneNumber;
    private Date timeStamp;

    public Message() {
    }

    public Message(String id, String content, String receiver) {
        this.id = id;
        this.content = content;
        this.receiverPhoneNumber = receiver;
        this.timeStamp = Calendar.getInstance().getTime();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object obj) {
        Message msgObj = (Message) obj;
        return this.getId().contentEquals(msgObj.getId()) && this.getReceiverPhoneNumber().contentEquals(msgObj.getReceiverPhoneNumber());
    }
}
