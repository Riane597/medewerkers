package banking.Factory;

import banking.User;
import banking.Factory.AbstractFactory.BankingFactory;

public class UserFactory implements BankingFactory {
    @Override
    public void manageEntities() {
        User.readUsers();
    }
}
