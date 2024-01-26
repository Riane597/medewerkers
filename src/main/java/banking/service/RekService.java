package banking.service;

import java.util.List;

import banking.configuration.JPAConfig;
import banking.entity.Rekening;
import banking.repository.RekRepo;

public class RekService {
    private RekRepo rekeningRepo;

    public RekService() {
        this.rekeningRepo = new RekRepo(JPAConfig.getEntityManager());
    }

    public List<Rekening> getRekeningen() {
        return rekeningRepo.listRekeningen();
    }

    public Rekening createRekening(Rekening rekening) {
        return rekeningRepo.createRekening(rekening);
    }

    public Rekening selectRekeningById(int rekeningId) {
        return rekeningRepo.selectRekeningById(rekeningId);
    }

    public void updateRekening(Rekening rekening) {
        rekeningRepo.updateRekening(rekening);
    }

    public void deleteRekening(Rekening rekening) {
        rekeningRepo.deleteRekening(rekening);
    }

    public List<Object[]> getRekeningUpdateCounts() {
        return rekeningRepo.getRekeningUpdateCounts();
    }
    
}
