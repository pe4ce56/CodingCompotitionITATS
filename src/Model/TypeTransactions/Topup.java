package Model.TypeTransactions;

import Model.TypeTransaction;

import java.util.*;

public class Topup extends TypeTransaction {

    public final static int INDOMART = 1;
    public final static int BCA = 2;
    public final static int BRI = 3;

    public int getType() {
        return type;
    }

    private int type;

    private long amount;

    public Topup(int type, long total){
        setAdminFee(500);
        this.type = type;
        this.amount = total;
    }

    private static Map<Integer,String> getTypes(){
        Map<Integer,String> types = new HashMap<>();

        types.put(INDOMART,"Indomart");
        types.put(BCA,"bca");
        types.put(BRI,"BRI");

        return types;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public long transactions() {
        return amount - getAdminFee();
    }
}
