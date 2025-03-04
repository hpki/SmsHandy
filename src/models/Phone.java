package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Phone {
    private String name;
    private String number;
    private Provider provider;
    private double balance;
    private List<Message> sendMessageList;
    private List<Message> receivedMessageList;

    public Phone(String name, String number, Provider provider) {
        this.name = name;
        this.number = number;
        this.balance = 0;
        this.sendMessageList = new ArrayList<>();
        this.receivedMessageList = new ArrayList<>();
        this.provider = provider;
        this.provider.register(this);
    }

    public void sendMessage(String to, String content) {
        if (to.equals(this.getNumber())) {
                System.out.println("Пожалуйста, введите номер, отличный от Вашего");
        } else if (to.equals("*500#")) {
            System.out.println("На Вашем балансе " + this.getBalance() + " руб.");
        } else if (this.canSendMessage()) {
            Message message = new Message(content, this.getNumber(), to, new Date());
            this.getProvider().sendMessage(message);
        } else {
            System.out.println("Не удалось отправить сообщение");
        } 
    }


    abstract public boolean canSendMessage(); 

    abstract public void payForMessage();


    public void deposit(double amount) {
        this.setBalance(getBalance() + amount);
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    

 
}
