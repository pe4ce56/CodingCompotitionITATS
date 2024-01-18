package Model;

import java.util.ArrayList;

public class User {
    private String username;
    private String email;
    private String password;
    private boolean status;
    private Information information;
    private long balance;
    private ArrayList<Transaction> transactions;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.setStatus(false);
        transactions = new ArrayList<>();
        //make balance to 10000 for testing
        this.setBalance(100000);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(TypeTransaction typeTransaction,long total) {
        Transaction transaction = new Transaction();
        transaction.setId(System.currentTimeMillis());
        transaction.setUser(this);
        transaction.setTotal(total);
        transactions.add(transaction);

        setBalance(balance+total);
    }
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
