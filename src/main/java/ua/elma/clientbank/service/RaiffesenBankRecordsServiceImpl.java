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
        recordsRepository.save(bankRecords);
    }

    @Override
    public RaiffeisenBankRecords getOne(String legalPersonID, String purposeOfPayment, Double sum) {
        return recordsRepository.findByLegalPersonIDAndPurposeOfPaymentAndSum(legalPersonID, purposeOfPayment, sum);
    }

    @Override
    public List<RaiffeisenBankRecords> findAllBR() {
        return recordsRepository.findAll();
    }
}
