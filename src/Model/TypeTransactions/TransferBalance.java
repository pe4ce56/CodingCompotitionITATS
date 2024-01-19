package Model.TypeTransactions;

import Model.TypeTransaction;
import Model.User;

public class TransferBalance extends TypeTransaction {
    private long amount;
    private User recipient;

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    private User sender;
    public TransferBalance(User recipient, long amount){
        setAdminFee(0);
        setAmount(amount);
        setRecipient(recipient);
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public long transactions() {
        long total = -(amount + getAdminFee());
        recipient.addTransaction(this, amount);

        return total;

    }
}
