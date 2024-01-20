package banking.service;

import java.util.List;

import banking.configuration.JPAConfig;
import banking.entity.Transactie;
import banking.repository.TransRepo;

public class TransService {
    private TransRepo transactieRepo;

    public TransService() {
        this.transactieRepo = new TransRepo(JPAConfig.getEntityManager());
    }

    public List<Transactie> getTransacties() {
        return transactieRepo.listTransacties();
    }

    public Transactie createTransactie(Transactie transactie) {
        return transactieRepo.createTransactie(transactie);
    }

    public Transactie selectTransactieById(int transactieId) {
        return transactieRepo.selectTransactieById(transactieId);
    }

    public void updateTransactie(Transactie transactie) {
        transactieRepo.updateTransactie(transactie);
    }

    public void deleteTransactie(Transactie transactie) {
        transactieRepo.deleteTransactie(transactie);
    }
}
