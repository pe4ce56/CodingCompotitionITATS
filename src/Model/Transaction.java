package Model;

public class Transaction {
    private long id;
    private TypeTransaction typeTransaction;
    private long total;
    private User user;

    public Transaction(int index){
        String result = "" + System.currentTimeMillis() + index;

        this.id = Long.parseLong(result);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
