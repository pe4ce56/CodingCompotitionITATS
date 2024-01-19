package View;

import View.publc.Index;
import View.resource.pages.*;


public class ViewFactory {
    private Index frame;

    public ViewFactory() {
        frame = Index.getInstance();
    }

    public void createView(String page){

        // Index = container / frame
        if( page.equals("login") ) frame.setContainer( new Login().getContainer() );
        else if( page.equals("register") ) frame.setContainer( new Register().getContainer() );
        else if( page.equals("dashboard") ) frame.setContainer( new Dashboard().getContainer() );
        else if( page.equals("beliPulsa") ) frame.setContainer( new BeliPulsa().getContainer() );
        else if( page.equals("history") ) frame.setContainer( new History().getContainer() );
        else if( page.equals("topUpSaldo") ) frame.setContainer( new TopUpSaldo().getContainer() );
        else if( page.equals("transfer") ) frame.setContainer( new Transfer().getContainer() );
    }
}