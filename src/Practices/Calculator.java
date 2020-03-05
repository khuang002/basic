package Practices;

import javax.swing.*;
import java.util.Arrays;
import java.util.Vector;

/*
* A simple arithmetic calculator (uncompleted)
* */
public class Calculator {
    String operand1 = "0";
    String operand2 = "0";
    String operation = "+";
    String result = "0";

    // toggle1 is used to choose input
    int toggle1 = 1;
    // toggle2 record the number of operations
    int toggle2 = 1;
    // toggle3 is used to indicate if string1 can be cleared,
    //      if toggle3 == 1, can; if toggle3 != 1, cannot
    int toggle3 = 1;
    // toggle4 is used to indicate if string2 can be cleared,
    //      if toggle4 == 1, can; if toggle4 != 1, cannot
    int toggle4 = 1;
    // toggle5 is used to indicate if decimal numbers are allowed,
    //      if toggle5 == 1, allowed; if toggle5 != 1, not allowed
    int toggle5 = 1;
    // store is used to indicate consecutive operations
    JButton store;

    @SuppressWarnings("rawtypes")
    Vector vt = new Vector(20, 10);

    // declare and initialize UI components
    JFrame frame = new JFrame("Calculator");
    JTextField result_TextField = new JTextField(result, 20);
    JButton clear_button = new JButton("clear");
    JButton buttonDecimal = new JButton(".");
    JButton buttonAdd = new JButton("+");
    JButton buttonSubtract = new JButton("-");
    JButton buttonMultiply = new JButton("*");
    JButton buttonDivide = new JButton("/");
    JButton buttonEqual = new JButton("=");
    final int buttonNumber = 10;
    JButton[] buttons = new JButton[buttonNumber];

    public Calculator(){
        // assign value of the number buttons
        for(int i=0; i<buttonNumber; i++){
            buttons[i] = new JButton(String.valueOf(i));
        }
    }

    private void cal(){

    }
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e){
            e.printStackTrace();
        }
        Calculator cal = new Calculator();
    }
}
