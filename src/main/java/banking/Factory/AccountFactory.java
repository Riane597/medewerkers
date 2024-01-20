package banking.Factory;

import banking.Account;
import banking.Factory.AbstractFactory.BankingFactory;

    public class AccountFactory implements BankingFactory {
    @Override
    public void manageEntities() {
        Account.manageRekeningen();
    }
}
