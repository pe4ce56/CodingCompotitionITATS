package Model;

public abstract class TypeTransaction {
    public long getAdminFee() {
        return adminFee;
    }

    public void setAdminFee(long adminFee) {
        this.adminFee = adminFee;
    }

    private long adminFee;

    abstract public String toString();

    abstract public long transactions();
}
