package ua.elma.clientbank.model;

public abstract class BankRecords {

    private long id;

    private String EDRPOU;

    public String getEDRPOU() {
        return EDRPOU;
    }

    public void setCodeEDRPU(String EDRPOU) {
        this.EDRPOU = EDRPOU;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    private String x;

}
