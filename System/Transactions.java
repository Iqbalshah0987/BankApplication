package System;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// import java.sql.*;
import java.lang.System;

public class Transactions extends JFrame implements ActionListener {
    
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinno;

    Transactions(String pinno)
    {
        this.pinno=pinno;

        //for set title
        // setTitle("TRANSACTIONS");

         //for set Image Icon.....
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));   //get the image from System....
         Image i2=i1.getImage().getScaledInstance(750,750,Image.SCALE_DEFAULT);  //for set image height and width....
         ImageIcon i3=new ImageIcon(i2); //for change Image object to ImageIcon....
         l2=new JLabel(i3);
         l2.setBounds(0,0,750,750);
         add(l2);

        //for set labels, and buttons.....
        l1=new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        
        b1=new JButton(" Deposit ");
        /*b1.setFont(new Font("Raleway",Font.BOLD,20));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);*/
        b2=new JButton(" Withdrawl ");
        /*b2.setFont(new Font("Raleway",Font.BOLD,20));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);*/
        b3=new JButton(" Fast Cash ");
        /*b3.setFont(new Font("Raleway",Font.BOLD,20));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);*/
        b4=new JButton(" Mini Statement ");
        /*b4.setFont(new Font("Raleway",Font.BOLD,20));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);*/
        b5=new JButton(" Pin Change ");
        /*b5.setFont(new Font("Raleway",Font.BOLD,20));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);*/
        b6=new JButton(" Balance Enquiry ");
       /* b6.setFont(new Font("Raleway",Font.BOLD,20));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);*/
        b7=new JButton("EXIT");
        /*b7.setFont(new Font("Raleway",Font.BOLD,20));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);*/

        //for set layout....
        setLayout(null);
        l1.setBounds(150,250,250,40);
        add(l1);
        l2.add(l1);
        //add buttons on the image.....
        b1.setBounds(128,340,140,30);
        l2.add(b1);
        b2.setBounds(292,340,140,30);
        l2.add(b2);
        b3.setBounds(128,370,140,30);
        l2.add(b3);
        b4.setBounds(292,370,140,30);
        l2.add(b4);
        b5.setBounds(128,400,140,30);
        l2.add(b5);
        b6.setBounds(292,400,140,30);
        l2.add(b6);
        b7.setBounds(292,430,140,30);
        l2.add(b7);

        //for action performed on buttons....
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        //for set Background color of container....
        // getContentPane().setBackground(Color.WHITE);

        //for set container size and location....
        setSize(750,750);
        setLocation(330,0);
        setUndecorated(true);   //for un-decorate the minimize, maximize, close buttons and logo....
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            dispose();
            new Deposite(pinno).setVisible(true);
        }
        else if(ae.getSource()==b2)
        {
            dispose();
            new Withdrawl(pinno).setVisible(true);

        }
        else if(ae.getSource()==b3)
        {
            dispose();
            new FastCash(pinno).setVisible(true);
        }
        else if(ae.getSource()==b4)
        {
            new MiniStatement(pinno).setVisible(true);
        }
        else if(ae.getSource()==b5)
        {
            dispose();
            new PinChange(pinno).setVisible(true);
        }
        else if(ae.getSource()==b6)
        {
            dispose();
            new BalanceEnquiry(pinno).setVisible(true);
            // String pinno=JOptionPane.showInputDialog("Enter Your Pin");

            /*Conn cn=new Conn();

            try
            {
                String q1="Select Balance from bank order by PinNO='"+pinno+"' DESC LIMIT 1";
                //for retrieve data from database.....
                ResultSet rs=cn.s.executeQuery(q1);
                if(rs.next())
                {

                    String balance=rs.getString("Balance");
                    JOptionPane.showMessageDialog(null,"Your Account Balance is "+balance);

                }

            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                System.out.println(ex);
            }*/
        }
        else if(ae.getSource()==b7)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}
