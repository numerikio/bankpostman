package ua.elma.clientbank.service;

import ua.elma.clientbank.model.RaiffeisenBankRecords;

import java.util.List;

public interface BankRecordsProvider {
    List<RaiffeisenBankRecords> getBRlist();
}
