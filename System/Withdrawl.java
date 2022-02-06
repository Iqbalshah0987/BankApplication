package System;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JPasswordField pf1;
    JButton b1,b2,b3;
    String pinno;

    Withdrawl(String pinno)
    {
        this.pinno=pinno;

        //for set Title......
        // setTitle("Withdrawl");

        //for set Image Icon.....
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));   //get the image from System....
        Image i2=i1.getImage().getScaledInstance(750,750,Image.SCALE_DEFAULT);  //for set image height and width....
        ImageIcon i3=new ImageIcon(i2); //for change Image object to ImageIcon....
        l4=new JLabel(i3);
        l4.setBounds(0,0,750,750);
        add(l4);

        //for set labels, textfields and buttons....
        l1=new JLabel("Enter Amount you want to Withdrawl :");
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        l1.setForeground(Color.WHITE);
        // l2=new JLabel("want to Withdrawl :");
        // l2.setFont(new Font("Raleway",Font.BOLD,28));
        t1=new JTextField();
        t1.setFont(new Font("Raleway",Font.BOLD,18));

        /*l3=new JLabel("Enter Pin :");
        l3.setFont(new Font("Raleway",Font.BOLD,28));
        pf1=new JPasswordField();
        pf1.setFont(new Font("Raleway",Font.BOLD,20));*/

        b1=new JButton("Withdrawl");
        /*b1.setFont(new Font("Raleway",Font.BOLD,16));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);*/
        b2=new JButton("BACK");
        /*b2.setFont(new Font("Raleway",Font.BOLD,16));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);*/
        b3=new JButton("EXIT");
        /*b3.setFont(new Font("Raleway",Font.BOLD,16));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);*/

        //for set layout.....
        setLayout(null);
        l1.setBounds(135,250,300,30);
        l4.add(l1);
        /*l2.setBounds(120,140,300,40);
        l4.add(l2);*/
        t1.setBounds(180,290,180,30);
        l4.add(t1);
        /*l3.setBounds(100,250,300,40);
        add(l3);
        pf1.setBounds(400,250,300,40);
        add (pf1);*/
        b1.setBounds(292,345,140,30);
        l4.add(b1);
        b2.setBounds(292,375,140,30);
        l4.add(b2);
        b3.setBounds(292,405,140,30);
        l4.add(b3);

        
        //for action performed on buttons....
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        //for set background color of container......
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
        try 
        {  
            if(ae.getSource()==b1)
            {
                /*char arr[]=pf1.getPassword();   //convert char array to String.....
                String b= String.valueOf(arr);*/
                String withdrawlAmount=t1.getText();

                if(withdrawlAmount.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please Enter the Amount you want to Withdrawl.");
                }
                else
                {
                    double d=Double.parseDouble(withdrawlAmount); //this is convert String Object to Pimitive data type "Double"....

                    Conn cn=new Conn();

                    String q1="Select * from bank where PinNo='"+pinno+"' ";
                    ResultSet rs=cn.s.executeQuery(q1);

                    Date date=new Date();
                    double balance=0;

                    while(rs.next())
                    {
                        balance=Double.parseDouble(rs.getString("Balance"));
                    }
                    if(balance>d)
                    {
                        balance=balance-d;

                        String q2="Insert into bank values('"+pinno+"','"+date+"','Withdrawl Rs."+withdrawlAmount+"','"+balance+"')";
                        cn.s.executeUpdate(q2);

                        JOptionPane.showMessageDialog(null,"Rs."+withdrawlAmount+" Withdrawl Successfully");

                        dispose();
                        new Transactions(pinno).setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Insufficient Balance.");
                        new Transactions(pinno).setVisible(true);
                    }
                }
            }
            else if(ae.getSource()==b2)
            {
                dispose();
                new Transactions(pinno).setVisible(true);

            }
            else if(ae.getSource()==b3)
            {
                System.exit(0);
            }
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        new Withdrawl("").setVisible(true);
    }
}
