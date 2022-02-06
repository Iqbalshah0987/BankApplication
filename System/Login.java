package System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4;
    JTextField tf1;
    JPasswordField pf1;
    JButton b1,b2,b3;

    //Constructor of Login class....
    public Login()
    {
        // super("AUTOMATED TELLER MACHINE");   //this is set the title....
        setTitle("AUTOMATED TELLER MACHINE");   //this is set the title....

        //for set Image Icon.....
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));   //get the image from System....
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);  //for set image height and width....
        ImageIcon i3=new ImageIcon(i2); //for change Image object to ImageIcon....
        l4=new JLabel(i3);
        l4.setBounds(20,15,100,100);
        add(l4);
        
        //set Labels, TextFields and Buttons....
        l1=new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward",Font.BOLD,40));

        l2=new JLabel("Card Number :");
        l2.setFont(new Font("Raleway",Font.BOLD,24));
        tf1=new JTextField(15);
        tf1.setFont(new Font("Arial",Font.ITALIC, 16));

        l3=new JLabel("Pin Number :");
        l3.setFont(new Font("Raleway",Font.BOLD,24));
        pf1=new JPasswordField(15);
        pf1.setFont(new Font("Arial",Font.ITALIC,16));

        b1=new JButton("SIGN IN");
        b1.setFont(new Font("Arial",Font.BOLD,16));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2=new JButton("CLEAR");
        b2.setFont(new Font("Arial",Font.BOLD,16));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b3=new JButton("SIGN UP"); 
        b3.setFont(new Font("Arial",Font.BOLD,16));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);

        //set Layout of Labels, TextFields and Buttons....
        setLayout(null);
        l1.setBounds(150,50,425,50);
        add(l1);
        l2.setBounds(120,170,200,50);
        add(l2);
        tf1.setBounds(320,180,200,30);
        add(tf1);
        l3.setBounds(120,230,200,50);
        add(l3);
        pf1.setBounds(320,240,200,30);
        add(pf1);
        b1.setBounds(120,350,150,30);
        add(b1);
        b2.setBounds(370,350,150,30);
        add(b2);
        b3.setBounds(250,400,150,30);
        add(b3);

        //for Action Performed on Buttons....
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        //for set Background color of container....
        getContentPane().setBackground(Color.WHITE);

        //for set container size and Location....
        setSize(750,600);
        setLocation(330,30);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae)
    {
        try 
        {
            Conn c=new Conn();
            
            String cardno=tf1.getText();
            char arr[]=pf1.getPassword();
            String pinno=String.valueOf(arr);   //this is convert char[] array to String Object.....
            
            //DBMS query....
            String q="Select * from login where CardNo='"+cardno+"' and PinNO='"+pinno+"' ";
            //for retrieve values from DBMS....
            ResultSet rs=c.s.executeQuery(q);

            if(ae.getSource()==b1)
            {
                if(rs.next())
                {
                    dispose();
                    new Transactions(pinno).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number and Password");
                }
            }
            else if(ae.getSource()==b2)
            {
                tf1.setText("");
                pf1.setText("");
            }
            else if(ae.getSource()==b3)
            {
                new SignUp1().setVisible(true);
                dispose();
            }
            
        }
        catch (Exception ex) 
        {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
        
        
    }
}
