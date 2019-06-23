package ua.elma.clientbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ua.elma.clientbank.model.BankRecords;

import java.io.Serializable;

@NoRepositoryBean
public interface BankRecordsRepository<T extends BankRecords, ID extends Serializable> extends JpaRepository<T, ID> {
    T findByLegalPersonIDAndPurposeOfPaymentAndSum(String legalPersonID, String purposeOfPayment, Double sum);
}
