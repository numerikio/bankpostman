package ua.elma.clientbank;

import java.util.List;

public interface BankRecordsProvider {
    List<? extends BankRecords> getBRlist();
}
