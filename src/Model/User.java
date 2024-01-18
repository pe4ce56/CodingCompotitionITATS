package Model;

import java.util.ArrayList;

public class User {

    private String nomor;
    private String username;
    private String email;
    private String password;
    private boolean status;
    private Information information;
    private long balance;
    private ArrayList<Transaction> transactions;

    public User(String nomor, String username, String email, String password) {
        this.nomor = nomor;
        this.username = username;
        this.email = email;
        this.password = password;
        this.setStatus(false);
        transactions = new ArrayList<>();
        //make balance to 10000 for testing
        this.setBalance(0);
    }
    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
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

        Transaction transaction = new Transaction(transactions.size()+1);
        transaction.setUser(this);
        transaction.setTotal(total);
        transactions.add(transaction);

        setBalance(balance+total);
    }
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
