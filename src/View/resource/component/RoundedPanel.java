package View.resource.component;

import View.resource.component.Callback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {

    private int cornerRadius;
    private Color color;

    private Runnable onClick;

    public Callback getOnHover() {
        return onHover;
    }

    public void setOnHover(Callback onHover) {
        this.onHover = onHover;
    }

    private Callback onHover;

    public RoundedPanel(LayoutManager layout, int cornerRadius) {
        this.cornerRadius = cornerRadius;
        this.color = new Color(255,255,255);
        setLayout(layout);
        setBorder(null);
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle the click event here
                onClick.run();
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                onHover.onHover(Callback.MOUSEENTER);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                onHover.onHover(Callback.MOUSEEXITED);
            }
        });

        System.out.println("CONSTRUCT");
    }

    public void reload(){
        setOpaque(false);
        revalidate();
        repaint();
    }

    public void setColor(Color color){
        this.color = color;
        reload();
    }
    public void setOnClick(Runnable r){
        this.onClick = r;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width, height, cornerRadius, cornerRadius);
        g2d.setColor(color);
        g2d.fill(roundedRectangle);

        g2d.dispose();
        System.out.println("render");
    }
}