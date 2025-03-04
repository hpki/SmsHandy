package models;

public class PrepaidPhone extends Phone {
     private double costForSms = 5;

     @Override
     public boolean canSendMessage() {
          if(this.getBalance() - costForSms >= 0) {

          }
     }
}
