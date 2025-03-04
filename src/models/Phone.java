package models;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
    private String name;
    private String number;
    private List<Message> sendMessageList;
    private List<Message> receivedMessageList;
    private Provider provider;
    private double balance;

    public Phone(String name, String number, Provider provider) {
        this.name = name;
        this.number = number;
        this.balance = 0;
        this.sendMessageList = new ArrayList<>();
        this.receivedMessageList = new ArrayList<>();
        this.provider = provider;
    }

    public void sendMessage(String to, Message message) {

    }

    abstract public boolean canSendMessage(); 




    public void deposit(double amount) {
        this.balance = balance + amount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Message> getSendMessageList() {
        return sendMessageList;
    }

    public List<Message> getReceivedMessageList() {
        return receivedMessageList;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public double getBalance() {
        return balance;
    }

 
}
