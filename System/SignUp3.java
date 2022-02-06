package System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.lang.Math;
import java.lang.System;
import java.util.Date;

public class SignUp3 extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField t1;
    JButton b1,b2;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;

    SignUp3(String formno)
    {
        this.formno=formno;
        //set title....
        setTitle("NEW ACCOUNT APPLICATION FORM : PAGE 3");

        //for set Image Icon.....
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));   //get the image from System....
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);  //for set image height and width....
        ImageIcon i3=new ImageIcon(i2); //for change Image object to ImageIcon....
        l13=new JLabel(i3);
        l13.setBounds(10,0,100,100);
        add(l13);

        //for set labels, textfields, radiobuttons, checkbox and buttons....
        l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,28));

        l2=new JLabel("Form No :");
        l2.setFont(new Font("Raleway",Font.BOLD,16));
        l12=new JLabel(formno);
        l12.setFont(new Font("Raleway",Font.BOLD,16));
        /*t1=new JTextField();
        t1.setFont(new Font("Raleway",Font.ITALIC,14));*/

        l3=new JLabel("Account Type :");
        l3.setFont(new Font("Raleway",Font.BOLD,20));
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        //for select one radio button....
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        l4=new JLabel("Card Number :");
        l4.setFont(new Font("Raleway",Font.BOLD,20));
        l5=new JLabel("XXXX-XXXX-XXXX-2455");
        l5.setFont(new Font("Raleway",Font.BOLD,18));
        l6=new JLabel("your 16-digit Card Number :-");
        l6.setFont(new Font("Raleway",Font.BOLD,20));
        l7=new JLabel("It would apear on ATM \nCard/Cheque Book and Statements");
        l7.setFont(new Font("Raleway",Font.BOLD,20));

        l8=new JLabel("PIN :");
        l8.setFont(new Font("Raleway",Font.BOLD,20));
        l9=new JLabel("XXXX");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l10=new JLabel("(4-digit password)");
        l10.setFont(new Font("Raleway",Font.BOLD,20));

        l11=new JLabel("Services Required :");
        l11.setFont(new Font("Raleway",Font.BOLD,20));
        c1=new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(Color.WHITE);
        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(Color.WHITE);
        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBackground(Color.WHITE);
        c4=new JCheckBox("E-Mail Alert");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBackground(Color.WHITE);
        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBackground(Color.WHITE);
        c6=new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBackground(Color.WHITE);

        c7=new JCheckBox("I hereby declared that the above entered details correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway",Font.BOLD,14));
        c7.setBackground(Color.WHITE);

        b1=new JButton("Submit");
        b1.setFont(new Font("Raleway",Font.BOLD,16));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2=new JButton("Cancel");
        b2.setFont(new Font("Raleway",Font.BOLD,16));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        //set layout....
        setLayout(null);
        l1.setBounds(110,40,400,45);
        add(l1);

        l2.setBounds(550,20,80,20);
        add(l2);
        l12.setBounds(630,20,80,25);
        add(l12);

        l3.setBounds(90,100,200,30);
        add(l3);
        r1.setBounds(300,100,200,30);
        add(r1);
        r2.setBounds(500,100,200,30);
        add(r2);
        r3.setBounds(300,150,200,30);
        add(r3);
        r4.setBounds(500,150,280,30);
        add(r4);

        l4.setBounds(90,200,200,30);
        add(l4);
        l5.setBounds(300,200,300,30);
        add(l5);
        l6.setBounds(90,230,300,30);
        add(l6);
        l7.setBounds(130,260,600,30);
        add(l7);

        l8.setBounds(90,330,200,30);
        add(l8);
        l9.setBounds(300,320,300,30);
        add(l9);
        l10.setBounds(90,350,300,30);
        add(l10);

        l11.setBounds(90,400,200,30);
        add(l11);
        c1.setBounds(300,400,200,30);
        add(c1);
        c2.setBounds(500,400,200,30);
        add(c2);
        c3.setBounds(300,450,200,30);
        add(c3);
        c4.setBounds(500,450,200,30);
        add(c4);
        c5.setBounds(300,500,200,30);
        add(c5);
        c6.setBounds(500,500,200,30);
        add(c6);

        c7.setBounds(90,550,700,30);
        add(c7);

        b1.setBounds(250,600,110,30);
        add(b1);
        b2.setBounds(400,600,110,30);
        add(b2);
        

        //action performed on buttons....
        b1.addActionListener(this);
        b2.addActionListener(this);

        //set back ground color of the container....
        getContentPane().setBackground(Color.WHITE);

        //set container size and location.....
        setSize(800,700);
        setLocation(330,10);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae)
    {
        // String a=t1.getText();

        String accounttype=null;
        if(r1.isSelected())
            accounttype="Saving Account";
        else if(r2.isSelected())
            accounttype="Fixed Deposit Account";
        else if(r3.isSelected())
            accounttype="Current Account";
        else if(r4.isSelected())
            accounttype="Recurring Deposit Account";
            
        //for generate card number.....
        double ran1=Math.random()*(9999999999999999l-1000000000000000l+1)+1000000000000000l;
        double first16=Math.abs(ran1);
        long firstc=(long)first16;
        String cardno=String.valueOf(firstc);

        //for generate pin number.....
        double ran2=Math.random()*(9999-1000+1)+1000;
        double first4=Math.abs(ran2);
        long firstp=(long)first4;
        String pinno=String.valueOf(firstp);

        String services="";
        if(c1.isSelected())
            services=services+"ATM Card, ";
        if(c2.isSelected())
            services=services+"Internet Banking, ";
        if(c3.isSelected())
            services=services+"Mobil Banking, ";
        if(c4.isSelected())
            services=services+"E-Mail Alert, ";
        if(c5.isSelected())
            services=services+"Cheque Book, ";
        if(c6.isSelected())
            services=services+"E-Statement ";

        try
        {
            if(ae.getSource()==b1)
            {
                if(!(c7.isSelected()))
                {
                    JOptionPane.showMessageDialog(null,"Please Check the required fields");
                }
                else
                {
                    Conn cn=new Conn();
                    Date date=new Date();

                    //this is DBMS query......
                    String q1="insert into signup3 values('"+formno+"','"+accounttype+"','"+cardno+"','"+pinno+"','"+services+"')";
                    String q2="insert into login values('"+cardno+"','"+pinno+"')";
                    String q3="insert into bank values('"+pinno+"','"+date+"','Deposit Rs.0',0)";
                    //insert data into DBMS.....
                    cn.s.executeUpdate(q1);
                    cn.s.executeUpdate(q2);
                    cn.s.executeUpdate(q3);

                    JOptionPane.showMessageDialog(null,"Your Account is created."+"Card No: "+cardno+"\nPin No: "+pinno+"\nRemember these details.");

                    dispose();
                    new Deposite(pinno).setVisible(true);


                }
            }
            else if(ae.getSource()==b2)
            {
                System.exit(0);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println(ex);
        }

    }

    public static void main(String[] args) {
        new SignUp3("").setVisible(true);
    }
}
