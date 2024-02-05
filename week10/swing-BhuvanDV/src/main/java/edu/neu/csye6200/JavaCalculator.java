package edu.neu.csye6200;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaCalculator {
    private JPanel JavaCalculator;
    private JTextField textDisplay;
    private JButton btnMultiply;
    private JButton btnSeven;
    private JButton btnEight;
    private JButton btnFour;
    private JButton btnOne;
    private JButton btnZero;
    private JButton btnNine;
    private JButton btnFive;
    private JButton btnTwo;
    private JButton btnPoint;
    private JButton btnPlus;
    private JButton btnSix;
    private JButton btnThree;
    private JButton btnClear;
    private JButton btnMinus;
    private JButton btnDivide;
    private JButton btnEqual;
    private JButton btnDel;
    private double total=0.0;
    private double totalOutput=0.0;
    private char math_operator;

    public JavaCalculator() {

        btnOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnOneText=textDisplay.getText()+btnOne.getText();
                textDisplay.setText(btnOneText);
            }
        });
        btnTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnTwoText= textDisplay.getText()+btnTwo.getText();
                textDisplay.setText(btnTwoText);
            }
        });
        btnThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnThreeText= textDisplay.getText()+btnThree.getText();
                textDisplay.setText(btnThreeText);
            }
        });
        btnFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnFourText= textDisplay.getText()+btnFour.getText();
                textDisplay.setText(btnFourText);
            }
        });
        btnFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnFiveText= textDisplay.getText()+btnFive.getText();
                textDisplay.setText(btnFiveText);
            }
        });
        btnSix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnSixText= textDisplay.getText()+btnSix.getText();
                textDisplay.setText(btnSixText);
            }
        });
        btnSeven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnSevenText= textDisplay.getText()+btnSeven.getText();
                textDisplay.setText(btnSevenText);
            }
        });
        btnEight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnEightText= textDisplay.getText()+btnEight.getText();
                textDisplay.setText(btnEightText);
            }
        });
        btnNine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnNineText= textDisplay.getText()+btnNine.getText();
                textDisplay.setText(btnNineText);
            }
        });
        btnZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnZeroText= textDisplay.getText()+btnZero.getText();
                textDisplay.setText(btnZeroText);
            }
        });
        btnPlus.addActionListener(e -> {
//            total=total+Double.parseDouble(textDisplay.getText());
//            textDisplay.setText("");
            String button_text=btnPlus.getText();
            getOperator(button_text);
        });
        btnMinus.addActionListener(e->{
            String button_text=btnMinus.getText();
            getOperator(button_text);
        });
        btnMultiply.addActionListener(e->{
            String button_text=btnMultiply.getText();
            getOperator(button_text);
        });
        btnDivide.addActionListener(e->{
            String button_text=btnDivide.getText();
            getOperator(button_text);
        });
        btnEqual.addActionListener(e->{
            switch(math_operator){
                case'+':
                    totalOutput=total+Double.parseDouble(textDisplay.getText());
                    break;
                case'-':
                    totalOutput=total-Double.parseDouble(textDisplay.getText());
                    break;
                case'*':
                    totalOutput=total*Double.parseDouble(textDisplay.getText());
                    break;
                case'/':
                    totalOutput=total/Double.parseDouble(textDisplay.getText());
                    break;
            }
            textDisplay.setText(Double.toString(totalOutput));
            total=0.0;
        });
        btnClear.addActionListener(e->{
            totalOutput=0;
            textDisplay.setText("");
        });
        btnPoint.addActionListener(e->{
            if(textDisplay.getText().equals("")){
                textDisplay.setText("0.");
            }else if(textDisplay.getText().contains(".")){
                btnPoint.setEnabled(false);
            }else{
                String btnPointText=textDisplay.getText()+btnPoint.getText();
                textDisplay.setText(btnPointText);
            }
            btnPoint.setEnabled(true);
        });
        btnDel.addActionListener(e->{
            int length=textDisplay.getText().length();
            int number=textDisplay.getText().length()-1;
            String store;
            if(length>0){
                StringBuilder back =new StringBuilder(textDisplay.getText());
                back.deleteCharAt(number);
                store=back.toString();
                textDisplay.setText(store);
            }
        });
    }

    private void getOperator(String btnText){
        math_operator=btnText.charAt(0);
        total=total+Double.parseDouble(textDisplay.getText());
        textDisplay.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JavaCalculator");
        frame.setContentPane(new JavaCalculator().JavaCalculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
