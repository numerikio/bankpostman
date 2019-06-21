package ua.elma.clientbank.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class BankRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String legalPersonID;  //<---- EDRPOU
    private String purposeOfPayment;
    private Double sum;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLegalPersonID() {
        return legalPersonID;
    }

    public void setLegalPersonID(String legalPersonID) {
        this.legalPersonID = legalPersonID;
    }

    public String getPurposeOfPayment() {
        return purposeOfPayment;
    }

    public void setPurposeOfPayment(String purposeOfPayment) {
        this.purposeOfPayment = purposeOfPayment;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankRecords that = (BankRecords) o;
        return Objects.equals(legalPersonID, that.legalPersonID) &&
                Objects.equals(purposeOfPayment, that.purposeOfPayment) &&
                Objects.equals(sum, that.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(legalPersonID, purposeOfPayment, sum);
    }
}
