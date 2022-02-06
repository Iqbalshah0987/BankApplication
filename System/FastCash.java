package System;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import java.sql.ResultSet;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;

public class FastCash extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3;
    JPasswordField pf1;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    String pinno;

    FastCash(String pinno)
    {
        this.pinno=pinno;
        //for set title......
        // setTitle("FAST CASH");

        //for set Image Icon.....
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));   //get the image from System....
        Image i2=i1.getImage().getScaledInstance(750,750,Image.SCALE_DEFAULT);  //for set image height and width....
        ImageIcon i3=new ImageIcon(i2); //for change Image object to ImageIcon....
        l3=new JLabel(i3);
        l3.setBounds(0,0,750,750);
        add(l3);

        //for set labels and buttons......
        l1=new JLabel("Select Withdrawl Amount :");
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        l1.setForeground(Color.WHITE);

        /*l2=new JLabel("Enter Pin :");
        l2.setFont(new Font("Raleway",Font.BOLD,16));
        pf1=new JPasswordField();
        pf1.setFont(new Font("Raleway",Font.BOLD,14));*/

        b1=new JButton("Rs. 100");
        /*b1.setFont(new Font("Raleway",Font.BOLD,20));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);*/
        b2=new JButton("Rs. 200");
        /*b2.setFont(new Font("Raleway",Font.BOLD,20));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);*/
        b3=new JButton("Rs. 500");
        /*b3.setFont(new Font("Raleway",Font.BOLD,20));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);*/
        b4=new JButton("Rs. 1000");
        /*b4.setFont(new Font("Raleway",Font.BOLD,20));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);*/
        b5=new JButton("Rs. 2000");
        /*b5.setFont(new Font("Raleway",Font.BOLD,20));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);*/
        b6=new JButton("Rs. 5000");
        /*b6.setFont(new Font("Raleway",Font.BOLD,20));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);*/
        b7=new JButton("Back");
        /*b7.setFont(new Font("Raleway",Font.BOLD,20));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);*/
        b8=new JButton("Exit");
        /*b8.setFont(new Font("Raleway",Font.BOLD,20));
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);*/

        //for set layout.....
        setLayout(null);
        /*l2.setBounds(500,20,100,30);
        add(l2);
        pf1.setBounds(600,20,100,30);
        add(pf1);*/

        l1.setBounds(150,250,250,40);
        add(l1);
        l3.add(l1);
        //add buttons on the image.....
        b1.setBounds(128,340,140,30);
        l3.add(b1);
        b2.setBounds(292,340,140,30);
        l3.add(b2);
        b3.setBounds(128,370,140,30);
        l3.add(b3);
        b4.setBounds(292,370,140,30);
        l3.add(b4);
        b5.setBounds(128,400,140,30);
        l3.add(b5);
        b6.setBounds(292,400,140,30);
        l3.add(b6);
        b7.setBounds(128,430,140,30);
        l3.add(b7);
        b8.setBounds(292,430,140,30);
        l3.add(b8);

        //for action performed on buttons......
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);

        //for set background color of container......
        getContentPane().setBackground(Color.WHITE);

        //for set container size and location......
        setSize(750,750);
        setLocation(330,0);
        setUndecorated(true);   //for un-decorate the minimize, maximize, close buttons and logo....
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae)
    {
        try 
        {
            /*char arr[]=pf1.getPassword();
            String a=String.valueOf(arr);   //convert char[] array to string.....*/

            if(ae.getSource()==b7)
            {
                dispose();
                new Transactions(pinno).setVisible(true);
            }
            else if(ae.getSource()==b8)
            {
                System.exit(0);
            }
            else 
            {
                String amt=((JButton)ae.getSource()).getText().substring(4);
                int amount=Integer.parseInt(amt);  //convert String to Double....

                Date date=new Date();
                double balance=0;

                Conn cn=new Conn();

                String q1="Select * from bank where PinNO='"+pinno+"' ";
                ResultSet rs=cn.s.executeQuery(q1);

                while(rs.next())
                {
                    balance=Double.parseDouble(rs.getString("Balance"));
                }
                if(balance>amount)
                {
                        balance=balance-amount;

                        String q2="Insert into bank values('"+pinno+"','"+date+"','Withdrawl Rs."+amount+"','"+balance+"')";
                        cn.s.executeUpdate(q2);


                        JOptionPane.showMessageDialog(null,"Rs."+amount+" Withdrawl Successfully");

                        dispose();
                        new Transactions(pinno).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance.");
                    new Transactions(pinno).setVisible(true);;
                }
            }
            /*if(ae.getSource()==b1)
            {
                Conn cn=new Conn();

                String q1="Select * from bank where PinNO='"+pinno+"' order by PinNO='"+pinno+"' DESC LIMIT 1 ";
                ResultSet rs=cn.s.executeQuery(q1);

                if(rs.next())
                {
                    String pin=rs.getString("PinNO");
                    balance=rs.getDouble("Balance");
                    if(balance>100)
                        {
                            balance=balance-100;

                            String q2="Insert into bank values('"+pin+"','"+date+"','Withdrawl Rs.100','"+balance+"')";
                            cn.s.executeUpdate(q2);


                            JOptionPane.showMessageDialog(null,"Rs.100 Withdrawl Successfully");

                            dispose();
                            new Transactions(pinno).setVisible(true);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Insufficient Balance.");
                            return;
                        }
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Pin Entered is wrong.");
                }
               
            }
            else if(ae.getSource()==b2)
            {
                Conn cn=new Conn();

                String q1="Select * from bank where PinNO='"+pinno+"' order by PinNO='"+pinno+"' DESC LIMIT 1";
                ResultSet rs=cn.s.executeQuery(q1);

                if(rs.next())
                {
                    String pin=rs.getString("PinNo");
                    balance=rs.getDouble("Balance");
                    if(balance>200)
                    {
                        balance=balance-200;

                        String q2="Insert into bank values('"+pin+"','"+date+"','Withdrawl Rs.200','"+balance+"')";
                        cn.s.executeUpdate(q2);


                        JOptionPane.showMessageDialog(null,"Rs.200 Withdrawl Successfully");

                        dispose();
                        new Transactions(pinno).setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Insufficient Balance.");
                        return;
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Pin Entered is wrong.");
                }
                
            }
            else if(ae.getSource()==b3)
            {
                Conn cn=new Conn();

                String q1="Select * from bank where PinNO='"+pinno+"' order by PinNO='"+pinno+"' DESC LIMIT 1";
                ResultSet rs=cn.s.executeQuery(q1);

                if(rs.next())
                {
                    String pin=rs.getString("PinNO");
                    balance=rs.getDouble("Balance");
                    if(balance>500)
                    {
                        balance=balance-500;

                        String q2="Insert into bank values('"+pin+"','"+date+"','Withdrawl Rs.500','"+balance+"')";
                        cn.s.executeUpdate(q2);


                        JOptionPane.showMessageDialog(null,"Rs.500 Withdrawl Successfully");

                        dispose();
                        new Transactions(pinno).setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Insufficient Balance.");
                        return;
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Pin Entered is wrong.");
                }
                
            }
            else if(ae.getSource()==b4)
            {
                Conn cn=new Conn();

                String q1="Select * from bank where PinNO='"+pinno+"' order by PinNO='"+pinno+"' DESC LIMIT 1";
                ResultSet rs=cn.s.executeQuery(q1);

                if(rs.next())
                {
                    String pin=rs.getString("PinNo");
                    balance=rs.getDouble("Balance");
                    if(balance>1000)
                    {
                        balance=balance-1000;

                        String q2="Insert into bank values('"+pin+"','"+date+"','Withdrawl Rs.1000','"+balance+"')";
                        cn.s.executeUpdate(q2);


                        JOptionPane.showMessageDialog(null,"Rs.1000 Withdrawl Successfully");

                        dispose();
                        new Transactions(pinno).setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Insufficient Balance.");
                        return;
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Pin Entered is wrong.");
                }
                
            }
            else if(ae.getSource()==b5)
            {
                Conn cn=new Conn();

                String q1="Select * from bank where PinNO='"+pinno+"' order by PinNo='"+pinno+"' DESC LIMIT 1";
                ResultSet rs=cn.s.executeQuery(q1);

                if(rs.next())
                {
                    String pin=rs.getString("PinNo");
                    balance=rs.getDouble("Balance");
                    if(balance>2000)
                    {
                        balance=balance-2000;

                        String q2="Insert into bank values('"+pin+"','"+date+"','Withdrawl Rs.2000','"+balance+"')";
                        cn.s.executeUpdate(q2);


                        JOptionPane.showMessageDialog(null,"Rs.2000 Withdrawl Successfully");

                        dispose();
                        new Transactions(pinno).setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Insufficient Balance.");
                        return;
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Pin Entered is wrong.");
                }
                
            }
            else if(ae.getSource()==b6)
            {
                Conn cn=new Conn();

                String q1="Select * from bank where PinNo='"+pinno+"' order by PinNo='"+pinno+"' DESC LIMIT 1";
                ResultSet rs=cn.s.executeQuery(q1);

                if(rs.next())
                {
                    String pin=rs.getString("PinNO");
                    balance=rs.getDouble("Balance");
                    if(balance>5000)
                    {
                        balance=balance-5000;

                        String q2="Insert into bank values('"+pin+"','"+date+"','Withdrawl Rs.5000','"+balance+"')";
                        cn.s.executeUpdate(q2);


                        JOptionPane.showMessageDialog(null,"Rs.5000 Withdrawl Successfully");

                        dispose();
                        new Transactions(pinno).setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Insufficient Balance.");
                        return;
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Pin Entered is wrong.");
                }
                
            }*/   
        } 
        catch(Exception ex) 
        {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
