package models;

import java.util.List;
import java.util.Map;

public class Provider {
private String name;
private Map<String, Phone> abonentsList;
private static List<Provider> providersList;

public Provider(String name) {
    this.name = name;
}

//метод для поиска провайдера в списке провайдеров
public Provider findProviderFor (String number) {
    for (Provider provider : providersList) {
        if (provider.getAbonentsList().containsKey(number)) {
            return provider;
        }
    }
    return null;
}

public boolean sendMessage(Message message) {
    Provider toProvider = this.findProviderFor(message.getTo());
    if (toProvider != null) {
        Phone toPhone = toProvider.getAbonentsList().get(message.getTo());
        toPhone.getReceivedMessageList().add(message);
        Phone fromPhone = this.getAbonentsList().get(message.getFrom());
        fromPhone.getSendMessageList().add(message);
        fromPhone.payForMessage();
        return true;
    } else {
        return false;
    }
}

public void register(Phone phone) {
    abonentsList.put(phone.getNumber(), phone);
}

public void register(Provider provider) {
    providersList.add(provider);
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Map<String, Phone> getAbonentsList() {
    return abonentsList;
}

public static List<Provider> getProvidersList() {
    return providersList;
}

}
