package Practices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloSwing extends JFrame {
    private JLabel myLabel;
    private JTextField myTextField;
    private JButton myButton;

    public HelloSwing(){
        super();
        this.setSize(400, 300);
        this.getContentPane().setLayout(null);
        this.setTitle("My first Swing window.");

        this.add(getJLabel(), null);
        this.add(getJTextField(), null);
        this.add(getJButton(), null);
    }

    public static void main(String[] args){
        HelloSwing helloSwing = new HelloSwing();
        helloSwing.setVisible(true);
    }

    private JLabel getJLabel(){
        if (myLabel == null){
            myLabel = new JLabel();
            myLabel.setBounds(5, 10, 250, 30);
            myLabel.setText("Hello World!");
        }
        return myLabel;
    }

    private JTextField getJTextField(){
        if (myTextField == null){
            myTextField = new JTextField();
            myTextField.setBounds(5, 45, 200, 30);
            myTextField.setText("Welcome!");
        }
        return myTextField;
    }

    private JButton getJButton(){
        if (myButton == null){
            myButton = new JButton();
            myButton.setBounds(5, 80, 100, 40);
            myButton.setText("Click me!");

            myButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    myLabel.setForeground(Color.RED);
                    myTextField.setBackground(Color.BLUE);
                }
            });
        }
        return myButton;
    }
}
