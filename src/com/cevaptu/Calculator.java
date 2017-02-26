package com.cevaptu;

/**
 * @author Mert CACINA
 * 114200068
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class Calculator implements ActionListener{


    // Defining global variables

    JFrame frame;
    JTextField text;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,div,mult,sub,add,dec,equal,delete,clear,exit;


    static String b;
    static Object result;
    static int operator=0;

    Calculator() {

        // Creating the objects

        frame=new JFrame("Calculator");


        text=new JTextField();
        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6");
        b7=new JButton("7");
        b8=new JButton("8");
        b9=new JButton("9");
        b0=new JButton("0");
        div=new JButton("/");
        mult=new JButton("*");
        sub=new JButton("-");
        add=new JButton("+");
        dec=new JButton(".");
        equal=new JButton("=");
        delete=new JButton("Delete");
        clear=new JButton("Clear");
        exit = new JButton("Exit");


        // Making the object look better by changing
        // their fonts and size

        text.setFont(new Font("Arial", Font.BOLD, 40));
        b1.setFont(new Font("Arial", Font.BOLD, 40));
        b2.setFont(new Font("Arial", Font.BOLD, 40));
        b3.setFont(new Font("Arial", Font.BOLD, 40));
        b4.setFont(new Font("Arial", Font.BOLD, 40));
        b5.setFont(new Font("Arial", Font.BOLD, 40));
        b6.setFont(new Font("Arial", Font.BOLD, 40));
        b7.setFont(new Font("Arial", Font.BOLD, 40));
        b8.setFont(new Font("Arial", Font.BOLD, 40));
        b9.setFont(new Font("Arial", Font.BOLD, 40));
        b0.setFont(new Font("Arial", Font.BOLD, 40));
        div.setFont(new Font("Arial", Font.BOLD, 40));
        mult.setFont(new Font("Arial", Font.BOLD, 40));
        sub.setFont(new Font("Arial", Font.BOLD, 40));
        add.setFont(new Font("Arial", Font.BOLD, 40));
        dec.setFont(new Font("Arial", Font.BOLD, 40));
        equal.setFont(new Font("Arial", Font.BOLD, 40));
        delete.setFont(new Font("Arial", Font.BOLD, 40));
        clear.setFont(new Font("Arial", Font.BOLD, 40));
        exit.setFont(new Font("Arial", Font.BOLD, 40));

        text.setBackground(Color.black);
        text.setForeground(Color.green);

        frame.setBackground(Color.green);

        // Setting the layout of the frame to Grid Layout

        frame.setLayout(new GridLayout(5,4));



        frame.add(text);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);
        frame.add(div);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(mult);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(sub);
        frame.add(dec);
        frame.add(b0);
        frame.add(equal);
        frame.add(add);
        frame.add(delete);
        frame.add(clear);
        frame.add(exit);


        frame.setVisible(true);
        frame.setSize(900,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        // Giving action listeners to the buttons we are going to use.

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        add.addActionListener(this);
        div.addActionListener(this);
        mult.addActionListener(this);
        sub.addActionListener(this);
        dec.addActionListener(this);
        equal.addActionListener(this);
        delete.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==b0)
            if(! text.getText().equals("0")){ // So that When the display is 0 and the user enters 0, the display will not change.
                //However, if the display is nonzero and the user enters 0, the 0 is appended to
                //the number currently displayed.
                text.setText(text.getText().concat("0"));
            }

        if(e.getSource()==b1)
            text.setText(text.getText().concat("1"));

        if(e.getSource()==b2)
            text.setText(text.getText().concat("2"));

        if(e.getSource()==b3)
            text.setText(text.getText().concat("3"));

        if(e.getSource()==b4)
            text.setText(text.getText().concat("4"));

        if(e.getSource()==b5)
            text.setText(text.getText().concat("5"));

        if(e.getSource()==b6)
            text.setText(text.getText().concat("6"));

        if(e.getSource()==b7)
            text.setText(text.getText().concat("7"));

        if(e.getSource()==b8)
            text.setText(text.getText().concat("8"));

        if(e.getSource()==b9)
            text.setText(text.getText().concat("9"));

        if(e.getSource()==dec)
            text.setText(text.getText().concat("."));

        if(e.getSource()==add)
        {
            text.setText(text.getText().concat("+"));


        }

        if(e.getSource()==sub)
        {
            text.setText(text.getText().concat("-"));
        }

        if(e.getSource()==mult)
        {
            text.setText(text.getText().concat("*"));

        }

        if(e.getSource()==div)
        {
            text.setText(text.getText().concat("/"));
        }

        if(e.getSource()==exit){
            frame.dispose();
        }

        /*
         * When the equal button is pressed it gets the string in the area and gives it to
         * the calculate formula which is defined at the bottom.
         * Then it attaches the result to the result string and sets the text area to result.
         */

        if(e.getSource()==equal)
        {
            b = text.getText();
            try {
                result=calculate(b);
            } catch (Exception e1) {

                e1.printStackTrace();
            }

            String s = ""+ result;
            text.setText("");
            for(int i=0;i<8 && i< s.length();i++){
                text.setText(text.getText()+ s.charAt(i));
            }
        }

        if(e.getSource()==clear)
            text.setText("");

        if(e.getSource()==delete)
        {
            String s=text.getText();
            text.setText("");
            for(int i=0;i<s.length()-1;i++)
                text.setText(text.getText()+s.charAt(i));
        }
    }

    /**
     *
     * @param s The given string value
     * @return Returns the calculated value from the given string expression according to the OPERATOR PRECEDENCE.
     * @throws Exception Throws exception if any error occurs.
     */

    Object calculate (String s) throws Exception{
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        return engine.eval(s);

    }
    // Main class
    public static void main(String[] args) throws Exception{

        new Calculator();


    } // End of main

} // End of class. End of Assignment 7.