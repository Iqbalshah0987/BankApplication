package System;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ListIterator;
import java.awt.*;
import java.awt.event.*;

public class MiniStatement extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3;
    JButton b1;

    String pinno;

    MiniStatement(String pinno)
    {
        super("Mini Statement");
        this.pinno=pinno;

        l1=new JLabel("Indian Bank");
        l1.setFont(new Font("System",Font.BOLD,20));
        l2=new JLabel();
        l2.setFont(new Font("System",Font.BOLD,18));
        l3=new JLabel();
        b1=new JButton("BACK");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("System",Font.BOLD,20));

        //for card number.....
        
        try 
        {
            Conn cn=new Conn();
            String q1="Select * from login where PinNo='"+pinno+"' ";
            ResultSet rs=cn.s.executeQuery(q1);

            while(rs.next())
            {
                l2.setText("Card Number : "+rs.getString("CardNo").substring(0,4)+"XXXXXXXX"+rs.getString("CardNo").substring(12));
            }
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        

        //for statements.....
        try 
        {
            Conn cn=new Conn();
            String q1="Select * from bank where PinNo='"+pinno+"' ";
            ResultSet rs=cn.s.executeQuery(q1);

            ArrayList<String> arrlist=new ArrayList<String>();
            while(rs.next())
            {
                arrlist.add("<html>"+rs.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Mode")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Balance")+"<br><br><html>");

                // l3.setText(l3.getText()+"<html>"+rs.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Mode")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Balance")+"<br><html>");
            }
            int sizeofarrlist=arrlist.size();
            ListIterator<String> lit=arrlist.listIterator(sizeofarrlist);
            while(lit.hasPrevious())
            {
                if(sizeofarrlist<=arrlist.size()-15)
                {
                    break;
                }
                l3.setText(l3.getText()+lit.previous());
                sizeofarrlist--;
            }
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }

        //set Layout....
        setLayout(null);
        l1.setBounds(200,20,200,30);
        add(l1);
        l2.setBounds(20,60,400,30);
        add(l2);
        l3.setBounds(20,100,400,500);
        add(l3);
 
        b1.setBounds(600,630,110,30);
        add(b1);
       

        //for action performed on buttons.....
        b1.addActionListener(this);

        //for set container background color....
        getContentPane().setBackground(Color.WHITE);

        //for set size and location....
        setSize(750,700);
        setLocation(330,10);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        dispose();
    }
    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
