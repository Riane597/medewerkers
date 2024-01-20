package banking.Factory;

import banking.Transaction;
import banking.Factory.AbstractFactory.BankingFactory;

public class TransactionFactory implements BankingFactory {
    @Override
    public void manageEntities() {
        Transaction.manageTransaction();
    }
}
