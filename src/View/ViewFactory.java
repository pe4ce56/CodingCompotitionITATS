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
        if( page.equals("register") ) frame.setContainer( new Register().getContainer() );
        else if( page.equals("dashboard") ) frame.setContainer( new Dashboard().getContainer() );
    }
}