package Service;

public class TransactionService {

    private static TransactionService service;
    public static TransactionService getInstance() {
        if(service==null){
            service = new TransactionService();
        }
        return service;
    }

}
