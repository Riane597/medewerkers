package banking.Factory;

import banking.Loan;
import banking.Factory.AbstractFactory.BankingFactory;

public class LoanFactory implements BankingFactory {
    @Override
    public void manageEntities() {
        Loan.manageProducts();
    }
}