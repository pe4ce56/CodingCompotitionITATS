package Controller;

import Model.Transaction;
import Model.TypeTransaction;
import Model.TypeTransactions.Pulsa;
import Model.TypeTransactions.Topup;
import Model.TypeTransactions.TransferBalance;
import Model.User;
import Service.TransactionService;
import Service.UserService;

public class TransactionController {

    TransactionService transactionService;
    UserService userService;
    public TransactionController(){
        transactionService = TransactionService.getInstance();
        userService = UserService.getInstance();
    }

    public boolean transaction(TypeTransaction typeTransaction){
        if (typeTransaction instanceof TransferBalance transfer) {
            if(userService.getUserActive() == null || transfer.getRecipient() == null) return false;
            if(userService.getUserActive().getBalance() < transfer.getAmount()) return false;
            transfer.setSender(userService.getUserActive());

            userService.getUserActive().addTransaction(typeTransaction,transfer.transactions());
        }else if(typeTransaction instanceof Topup topup){
            if(userService.getUserActive() == null) return false;
            userService.getUserActive().addTransaction(typeTransaction,topup.transactions());
        }else if(typeTransaction instanceof Pulsa pulsa){
            if(userService.getUserActive() == null) return false;
            if(pulsa.getNomor().equals("") )return false;

            userService.getUserActive().addTransaction(typeTransaction,pulsa.transactions());
        }

        for(User user : userService.getUsers()){
            System.out.println("username " + user.getUsername());
            System.out.println("balance " + user.getBalance());
            for(Transaction transaction : user.getTransactions()){
                System.out.println(transaction.getId() + " " + transaction.getTotal());
            }
            System.out.println();
        }
        return true;
    }

    public void TopupSalod(){

    }




}
