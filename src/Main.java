import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    private ArrayList<String> menuList;
    private PropertyChangeSupport propertyChangeSupport;
    private int currentIndex = 0;
    private ArrayList<RoundedPanel> sidebarButtons;

    private JPanel sidebarPanel;
    private JPanel bodyPanel;

    public static void main(String[] args) {
        Main main1 = new Main();
        main1.addPropertyChangeListener(evt -> {
//            System.out.println("Property changed: " + evt.getPropertyName());
//            System.out.println("Old value: " + evt.getOldValue());
//            System.out.println("New value: " + evt.getNewValue());
        });

        main1.createAndShowGUI();
    }

    public Main(){
        menuList = new ArrayList<String>();
        menuList.add("Menu 1");
        menuList.add("Menu 2");
        menuList.add("Menu 3");
        menuList.add("Menu 4");
        menuList.add("Menu 5");
        menuList.add("Menu 6");
        menuList.add("Menu 7");
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    private void sidebarMenu(JPanel container){
        for(int i = 0;i<menuList.size();i++){
            final int index = i;
            RoundedPanel menu1 = new RoundedPanel(null,20);
            menu1.setColor(new Color(0, 157, 247));

            container.add(menu1);
            ((FlexBoxLayoutManager) container.getLayout()).setFillWidth(menu1, true);
            ((FlexBoxLayoutManager) container.getLayout()).setItemHeight(menu1, 30);
            menu1.setOnClick(()-> {
                setCurrentIndex(index);
                body(bodyPanel);
            });

            menu1.setOnHover((e)->{
                if(e == Callback.MOUSEENTER)
                    menu1.setColor(Color.BLUE);
                else
                    if(currentIndex != index)
                        menu1.setColor(new Color(0, 157, 247));

            });
            this.addPropertyChangeListener(evt -> {
                if(evt.getPropertyName().equals("currentIndex") && Integer.parseInt(evt.getNewValue().toString()) == index){
                    menu1.setColor(Color.BLUE);
                }else{
                    menu1.setColor(new Color(0, 157, 247));
                }
            });
        }
    }

    private void body(JPanel container){
        if(container.getComponents().length>0)
            container.remove(container.getComponents().length-1);
        JLabel label = new JLabel(menuList.get(currentIndex));
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        container.add(label);
        ((FlexBoxLayoutManager) container.getLayout()).setFillWidth(label, true);
        ((FlexBoxLayoutManager) container.getLayout()).setFillHeight(label, true);

        container.revalidate();
        container.repaint();
        System.out.println(label.getText());
    }


    private void createAndShowGUI() {
        JFrame frame = new JFrame("ColumnLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new FlexBoxLayoutManager(FlexBoxLayoutManager.HORIZONTAL));

        JPanel sidePanel = new JPanel(new FlexBoxLayoutManager(FlexBoxLayoutManager.VERTICAL));
        sidePanel.setBackground(new Color(3, 173, 252));
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        createPanel(mainPanel,sidePanel,200,true);
        ((FlexBoxLayoutManager) sidePanel.getLayout()).setGap(10);
        ((FlexBoxLayoutManager) sidePanel.getLayout()).setPadding(new Insets(10, 10, 10, 10));
        sidebarMenu(sidePanel);


        bodyPanel = new JPanel(new FlexBoxLayoutManager(FlexBoxLayoutManager.VERTICAL));
        bodyPanel.setBackground(new Color(187, 230, 250));
        bodyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        createPanel(mainPanel,bodyPanel,true,true);
        body(bodyPanel);

        mainPanel.setSize(frame.getSize());
        frame.getContentPane().add(mainPanel);

        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



    private void createPanel(JPanel container,JPanel panel,int width, int height) {
        container.add(panel);
        ((FlexBoxLayoutManager) container.getLayout()).setItemWidth(container.getComponent(container.getComponents().length-1), width);
        ((FlexBoxLayoutManager) container.getLayout()).setItemHeight(container.getComponent(container.getComponents().length-1), height);
    }
    private void createPanel(JPanel container,JPanel panel,boolean fillWidth, int height) {
        container.add(panel);
        ((FlexBoxLayoutManager) container.getLayout()).setFillWidth(container.getComponent(container.getComponents().length-1), fillWidth);
        ((FlexBoxLayoutManager) container.getLayout()).setItemHeight(container.getComponent(container.getComponents().length-1), height);
    }
    private void createPanel(JPanel container,JPanel panel, int width, boolean fillHeight) {
        container.add(panel);
        ((FlexBoxLayoutManager) container.getLayout()).setItemWidth(panel, width);
        ((FlexBoxLayoutManager) container.getLayout()).setFillHeight(panel, fillHeight);
    }
    private void createPanel(JPanel container,JPanel panel, boolean fillWidth, boolean fillHeight) {
        container.add(panel);
        ((FlexBoxLayoutManager) container.getLayout()).setFillWidth(panel, fillWidth);
        ((FlexBoxLayoutManager) container.getLayout()).setFillHeight(panel, fillHeight);
    }
    private RoundedPanel createLabel(String text) {
        RoundedPanel label = new RoundedPanel(null,20);
//        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setColor(new Color(0, 157, 247));
        return label;
    }
    // Method to add a property change listener
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    // Method to remove a property change listener
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        int oldCurrentIndex = this.currentIndex;
        this.currentIndex = currentIndex;
        propertyChangeSupport.firePropertyChange("currentIndex", oldCurrentIndex, currentIndex);

    }
}