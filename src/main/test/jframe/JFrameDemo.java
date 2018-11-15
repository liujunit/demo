package jframe;

import javax.swing.*;

/**
 * Created by jiuyuan4 on 2018/8/9.
 */
public class JFrameDemo {

    public static void main(String[] args) {
//        JFrame jFrame = new JFrame("Hello");
////        JLabel jLabel = new JLabel("测试", JLabel.CENTER);
//        jFrame.add(new HelloComponent());
//        jFrame.setSize(300, 300);
//        jFrame.setVisible(true);
        System.out.println(getStr());
    }

    public static String getStr(){
        String str = "123";
        try{
            return str;
        }finally {
            str = "456";
        }
    }

}
