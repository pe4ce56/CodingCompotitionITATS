import Config.Instance;
import Controller.TransactionController;
import Controller.UserController;
import Model.TypeTransactions.Pulsa;
import Model.TypeTransactions.Topup;
import Model.TypeTransactions.TransferBalance;
import Model.User;
import Service.UserService;
import View.ViewFactory;

public class App {

    public static void main(String[] args) {
        Instance app = Instance.getInstance();

        app.instanceController();
        app.instanceView();

        try {
            UserController userController = (UserController) app.getController("UserController");
            /*
                Testing fitur
             */
            userController.register(new User("+6285211119377", "damai", "damai@gmail.com", "damai"));
            userController.register(new User("+6285211119377", "deo", "deo@gmail.com", "deo"));

            userController.login();
            userController.login("damai", "damai");

            TransactionController transactionController = (TransactionController) app.getController("TransactionController");

            transactionController.transaction(new Topup(Topup.INDOMART, 50000));
            transactionController.transaction(new TransferBalance(UserService.getInstance().getUsers().get(1), 10000));
            transactionController.transaction(new TransferBalance(UserService.getInstance().getUsers().get(1), 10000));
            transactionController.transaction(new Pulsa("085211119377", 10000));

            /*
               END Testing fitur
             */

            new ViewFactory().createView("login");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
