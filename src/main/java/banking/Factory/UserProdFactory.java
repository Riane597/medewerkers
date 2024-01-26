package banking.Factory;

import banking.Reports;
import banking.Factory.AbstractFactory.BankingFactory;

public class UserProdFactory implements BankingFactory{
    @Override
    public void manageEntities() {
        Reports.manageReports();
    }
}