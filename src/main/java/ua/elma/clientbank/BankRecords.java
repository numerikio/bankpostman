package ua.elma.clientbank;

public abstract class BankRecords {

    private long id;
    private String codeEDRPU;

    public String getCodeEDRPU() {
        return codeEDRPU;
    }

    public void setCodeEDRPU(String codeEDRPU) {
        this.codeEDRPU = codeEDRPU;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    private String x;

}
