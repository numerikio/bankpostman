package ua.elma.clientbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.elma.clientbank.model.RaiffeisenBankRecords;
import ua.elma.clientbank.repository.BankRecordsRepository;

import java.util.List;

@Service
public class RaiffesenBankRecordsServiceImpl implements RaiffesenBankRecordsService {

    @Autowired
    BankRecordsRepository<RaiffeisenBankRecords, Long> recordsRepository;


    @Override
    public void saveBankRecords(RaiffeisenBankRecords bankRecords) {
if(recordsRepository.findAll().indexOf(bankRecords)==-1) {
    recordsRepository.save(bankRecords);
}
    }

    @Override
    public List<RaiffeisenBankRecords> findAllBR() {
        return recordsRepository.findAll();
    }
}
