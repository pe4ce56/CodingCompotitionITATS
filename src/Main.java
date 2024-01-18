import View.ViewFactory;

public class Main {

    // Iki main e tak langsung nak view mergane nek nak controller sek nggaiso
    // Mergane controller ora nyeluk view
    // Anggep ae backend e wes di hosting disik i unu

    public static void main(String[] args) {
        new ViewFactory().createView("register");
    }
}