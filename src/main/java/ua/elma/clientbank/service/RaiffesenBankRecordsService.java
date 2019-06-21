package ua.elma.clientbank.service;

import ua.elma.clientbank.model.RaiffeisenBankRecords;

import java.util.List;

public interface RaiffesenBankRecordsService {
    void saveBankRecords(RaiffeisenBankRecords bankRecords);
    List<RaiffeisenBankRecords> findAllBR();
}
