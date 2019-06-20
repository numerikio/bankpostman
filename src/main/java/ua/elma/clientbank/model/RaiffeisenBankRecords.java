package ua.elma.clientbank.model;


import javax.persistence.Entity;

@Entity
public class RaiffeisenBankRecords extends BankRecords {

    private String massege;

    public String getMassege() {
        return massege;
    }

    public void setMassege(String massege) {
        this.massege = massege;
    }
}
