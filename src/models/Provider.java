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
