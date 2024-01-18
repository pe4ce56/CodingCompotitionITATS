package View;

import View.publc.Index;
import View.resource.pages.*;

import javax.swing.*;

public class ViewFactory {
    private Index index;

    public ViewFactory() {
        index = Index.getInstance();
    }

    public void createView(String page){

        // Index = container / frame

        if( page.equals("register") ) index.setComponent( new Register().getComponent() );
        else if( page.equals("dashboard") ) index.setComponent( new Dashboard().getComponent() );
    }
}