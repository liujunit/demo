package jframe;

import javax.swing.*;

/**
 * Created by jiuyuan4 on 2018/8/9.
 */
public class JFrameDemo2 {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Hello");
        jFrame.add(new HelloComponent2("@@@@@"));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 300);
        jFrame.setVisible(true);

    }

}
