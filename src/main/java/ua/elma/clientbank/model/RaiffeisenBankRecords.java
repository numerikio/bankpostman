package ua.elma.clientbank.model;


import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class RaiffeisenBankRecords extends BankRecords {

    private Integer MFO;
    private Long account;
    private String currency;
    private LocalDateTime dateOfOperation;
    private String code;
    private Integer bankMFO;
    private String bankName;
    private String correspondentAccount;
    private Long correspondentLegalPersonID;
    private String correspondentName;
    private String document;
    private LocalDate documentDate;
    private Double debit;
    private Double credit;

    public RaiffeisenBankRecords() {
    }

    public Integer getMFO() {
        return MFO;
    }

    public void setMFO(Integer MFO) {
        this.MFO = MFO;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getDateOfOperation() {
        return dateOfOperation;
    }

    public void setDateOfOperation(LocalDateTime dateOfOperation) {
        this.dateOfOperation = dateOfOperation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getBankMFO() {
        return bankMFO;
    }

    public void setBankMFO(Integer bankMFO) {
        this.bankMFO = bankMFO;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCorrespondentAccount() {
        return correspondentAccount;
    }

    public void setCorrespondentAccount(String correspondentAccount) {
        this.correspondentAccount = correspondentAccount;
    }

    public Long getCorrespondentLegalPersonID() {
        return correspondentLegalPersonID;
    }

    public void setCorrespondentLegalPersonID(Long correspondentLegalPersonID) {
        this.correspondentLegalPersonID = correspondentLegalPersonID;
    }

    public String getCorrespondentName() {
        return correspondentName;
    }

    public void setCorrespondentName(String correspondentName) {
        this.correspondentName = correspondentName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RaiffeisenBankRecords that = (RaiffeisenBankRecords) o;
        return Objects.equals(MFO, that.MFO) &&
                Objects.equals(account, that.account) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(dateOfOperation, that.dateOfOperation) &&
                Objects.equals(code, that.code) &&
                Objects.equals(bankMFO, that.bankMFO) &&
                Objects.equals(bankName, that.bankName) &&
                Objects.equals(correspondentAccount, that.correspondentAccount) &&
                Objects.equals(correspondentLegalPersonID, that.correspondentLegalPersonID) &&
                Objects.equals(correspondentName, that.correspondentName) &&
                Objects.equals(document, that.document) &&
                Objects.equals(documentDate, that.documentDate) &&
                Objects.equals(debit, that.debit) &&
                Objects.equals(credit, that.credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), MFO, account, currency, dateOfOperation, code, bankMFO, bankName, correspondentAccount, correspondentLegalPersonID, correspondentName, document, documentDate, debit, credit);
    }
}
