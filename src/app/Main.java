package app;

import models.Message;
import models.Phone;
import models.PrepaidPhone;
import models.Provider;

public class Main {
    public static void main(String[] args) {
        Provider provider = new Provider("Мегафон");
        Phone phone = new PrepaidPhone("Max", "055555555", provider); 
        Provider provider1 = new Provider("Биллайн>");
        Phone phone1 = new PrepaidPhone("Nina", "077777777", provider1);
        for (Provider provider2 : provider.getProvidersList()){
            System.out.println(provider2.getName());
            for (Phone phone2 : provider2.getAbonentsList().values()){
                System.out.println("\t" + phone2.getName() + " " + phone2.getNumber() + " " + phone2.getBalance());
            }
        }
        System.out.println();
        
        phone.setBalance(50);
        System.out.println("У " + phone.getName() + " " + phone.getBalance() + " руб.");
        phone.sendMessage("055555555", "Привет, Макс");
        System.out.println("У " + phone.getName() + " " + phone.getBalance() + " руб.");
    }
}
