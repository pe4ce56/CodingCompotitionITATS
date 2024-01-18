package Model;

import java.util.ArrayList;

public class User {
    private String username;
    private String email;
    private String password;
    private String token;
    private boolean status;
    private Information information;
    private long balance;
    private ArrayList<Transaction> transactions;
}
