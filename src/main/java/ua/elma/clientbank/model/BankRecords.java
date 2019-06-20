package ua.elma.clientbank.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BankRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String EDRPOU;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEDRPOU() {
        return EDRPOU;
    }

    public void setEDRPOU(String EDRPOU) {
        this.EDRPOU = EDRPOU;
    }



}
