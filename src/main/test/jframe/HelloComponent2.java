package jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by jiuyuan4 on 2018/8/9.
 */
public class HelloComponent2 extends JComponent implements MouseMotionListener {

    private String message;
    private int messageX = 95, messageY = 200;

    public HelloComponent2(String message){
        this.message = message;
        addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g){
        g.drawString(message, messageX, messageY);
    }


    @Override
    public void mouseDragged(MouseEvent e) {
//        messageX = e.getX();
//        messageY = e.getY();
//        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        messageX = e.getX();
        messageY = e.getY();
        repaint();
    }
}
