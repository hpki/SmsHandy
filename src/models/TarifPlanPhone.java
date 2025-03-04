package models;

public class TarifPlanPhone extends Phone {
    private int costForSms = 1;

    public TarifPlanPhone(String name, String number, Provider provider) {
        super(name, number, provider);
    }

    @Override
    public boolean canSendMessage() {
        if (this.getBalance() - costForSms >= 0) {
            return true;
        }else return false;
    }

    @Override
    public void payForMessage() {
        this.setBalance(getBalance() - costForSms);
    }

}
