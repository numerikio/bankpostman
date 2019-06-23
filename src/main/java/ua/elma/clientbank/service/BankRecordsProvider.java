package ua.elma.clientbank.service;

import ua.elma.clientbank.model.BankRecords;

import java.util.List;

public interface BankRecordsProvider {
    List<? extends BankRecords> getBRlist();
}
