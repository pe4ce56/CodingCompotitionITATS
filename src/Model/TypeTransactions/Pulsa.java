package Model.TypeTransactions;

import Model.TypeTransaction;

public class Pulsa extends TypeTransaction {


    private String nomor;
    private long amount;
    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Pulsa(String nomor, long amount){
        setAdminFee(2500);

        this.nomor = nomor;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public long transactions() {
        return -(amount + getAdminFee());
    }
}
