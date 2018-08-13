package jframe;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jiuyuan4 on 2018/8/9.
 */
public class HelloComponent extends JComponent {

    @Override
    public void paintComponent(Graphics graphics){
        graphics.drawString("Hello Java", 50, 200);
    }
}
