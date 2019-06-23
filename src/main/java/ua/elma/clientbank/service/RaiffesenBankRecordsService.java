package ua.elma.clientbank.service;

import ua.elma.clientbank.model.RaiffeisenBankRecords;

import java.util.List;

public interface RaiffesenBankRecordsService {
    void saveBankRecords(RaiffeisenBankRecords bankRecords);

    RaiffeisenBankRecords getOne(String legalPersonID, String purposeOfPayment, Double sum);

    List<RaiffeisenBankRecords> findAllBR();
}
