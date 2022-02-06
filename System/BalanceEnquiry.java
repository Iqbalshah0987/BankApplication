package System;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.System;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3;
    JButton b1,b2;
    String pinno;

    BalanceEnquiry(String pinno)
    {
        this.pinno=pinno;

        //for set Image Icon.....
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));   //get the image from System....
        Image i2=i1.getImage().getScaledInstance(750,750,Image.SCALE_DEFAULT);  //for set image height and width....
        ImageIcon i3=new ImageIcon(i2); //for change Image object to ImageIcon....
        l3=new JLabel(i3);
        l3.setBounds(0,0,750,750);
        add(l3);

        l1=new JLabel("Your Current Account Balance is");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,16));
        l2=new JLabel();
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,16));

        double balance=0;
        try 
        {
            Conn cn=new Conn();
            String q1="Select * from bank where PinNo='"+pinno+"' ";
            ResultSet rs=cn.s.executeQuery(q1); 
            
            while(rs.next())
            {
                if(rs.getString("Mode").substring(0,7).equals("Deposit"))
                {
                    balance=Double.parseDouble(rs.getString("Balance"));
                }
                else 
                {
                    balance=Double.parseDouble(rs.getString("Balance"));
                }
            }
            l2.setText("Rs. "+balance);


            // String q1="Select * from bank where PinNo='"+pinno+"' order by PinNo='"+pinno+"' DESC LIMIT 1";
            // //for retrieve data from database.....
            // ResultSet rs=cn.s.executeQuery(q1);
            // if(rs.next())
            // {
            //     balance=rs.getDouble("Balance");
            //     l2.setText("Rs. "+balance);
            // }
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
            System.out.println(ex);
        }

        b1=new JButton("BACK");
        b2=new JButton("EXIT");

        //set layout.....
        setLayout(null);
        l1.setBounds(128,250,300,40);
        l3.add(l1);
        l2.setBounds(180,280,300,40);
        l3.add(l2);

        b1.setBounds(128,430,140,30);
        l3.add(b1);
        b2.setBounds(292,430,140,30);
        l3.add(b2);

        //for action performed on button.....
        b1.addActionListener(this);
        b2.addActionListener(this);

        //for set size and location.....
        setSize(750,750);
        setLocation(330,0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            dispose();
            new Transactions(pinno).setVisible(true);
        }
        else if(ae.getSource()==b2)
        {
            System.exit(0);
        }
        
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }

}
