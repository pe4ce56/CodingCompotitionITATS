import View.ViewFactory;

public class Main {

    // Eh iki sawangane isok di akses nak controller, index e tak kei instance ben frame e mek siji

    public static void main(String[] args) {
        new ViewFactory().createView("login");
    }
}