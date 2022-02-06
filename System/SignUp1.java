package System;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;

import com.toedter.calendar.JDateChooser;
// import java.sql.*;

public class SignUp1 extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton r1,r2,r3,r4,r5;
    JButton b;
    // JComboBox<String> c1,c2,c3;
    JDateChooser datechooser;

    //for generate random number...
    double ran=Math.random()*(9999-1000+1)+1000;
    double first=Math.abs(ran);
    long first4=(long)first;

    //Constructor of SignUp1 Class....
    SignUp1()
    {
        //Set the title....
        setTitle("NEW ACCOUNT APPLICATION FORM");

        //for set Image Icon.....
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));   //get the image from System....
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);  //for set image height and width....
        ImageIcon i3=new ImageIcon(i2); //for change Image object to ImageIcon....
        l17=new JLabel(i3);
        l17.setBounds(10,0,100,100);
        add(l17);

        //set the Labels, TextFields, Buttons, radioButtons and ComboBox....
        l1=new JLabel("Application Form No :"+first4);
        l1.setFont(new Font("Raleway",Font.BOLD,38));

        l2=new JLabel("Page 1: Personal Details");
        l2.setFont(new Font("Raleway",Font.BOLD,28));

        l3=new JLabel("Name :");
        l3.setFont(new Font("Raleway",Font.BOLD,20));
        t1=new JTextField();
        t1.setFont(new Font("Raleway",Font.BOLD,16));

        l4=new JLabel("Father's Name :");
        l4.setFont(new Font("Raleway",Font.BOLD,20));
        t2=new JTextField();
        t2.setFont(new Font("Raleway",Font.BOLD,16));

        l5=new JLabel("Date of Birth :");
        l5.setFont(new Font("Raleway",Font.BOLD,20));
        datechooser=new JDateChooser();
        datechooser.setBackground(Color.WHITE);
        datechooser.setForeground(Color.cyan);

        /*l6=new JLabel("Date :");
        l6.setFont(new Font("Raleway",Font.BOLD,16));
        String date[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        c1=new JComboBox<String>(date);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(Color.WHITE);

        l7=new JLabel("Month :");
        l7.setFont(new Font("Raleway",Font.BOLD,16));
        String month[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        c2=new JComboBox<String>(month);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(Color.WHITE);

        l8=new JLabel("Year :");
        l8.setFont(new Font("Raleway",Font.BOLD,16));
        String year[]={"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021"};
        c3=new JComboBox<String>(year);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBackground(Color.WHITE);*/

        l9=new JLabel("Gender :");
        l9.setFont(new Font("Raleway",Font.BOLD,20));
        r1=new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r2=new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r3=new JRadioButton("Others");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        //for select only one radio button.....
        ButtonGroup groupgender=new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);

        l10=new JLabel("Email Address :");
        l10.setFont(new Font("Raleway",Font.BOLD,20));
        t3=new JTextField();
        t3.setFont(new Font("Raleway",Font.BOLD,16));

        l11=new JLabel("Marital Status :");
        l11.setFont(new Font("Raleway",Font.BOLD,20));
        r4=new JRadioButton("Married");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r5=new JRadioButton("Unmarried");
        r5.setFont(new Font("Raleway",Font.BOLD,16));
        r5.setBackground(Color.WHITE);
        //for select only one radion button.....
        ButtonGroup groupmarital=new ButtonGroup();
        groupmarital.add(r4);
        groupmarital.add(r5);

        l12=new JLabel("Address :");
        l12.setFont(new Font("Raleway",Font.BOLD,20));
        t4=new JTextField();
        t4.setFont(new Font("Raleway",Font.BOLD,16));

        l13=new JLabel("City :");
        l13.setFont(new Font("Raleway",Font.BOLD,20));
        t5=new JTextField();
        t5.setFont(new Font("Raleway",Font.BOLD,16));

        l14=new JLabel("Pin Code :");
        l14.setFont(new Font("Raleway",Font.BOLD,20));
        t6=new JTextField();
        t6.setFont(new Font("Raleway",Font.BOLD,16));

        l15=new JLabel("State :");
        l15.setFont(new Font("Raleway",Font.BOLD,20));
        t7=new JTextField();
        t7.setFont(new Font("Raleway",Font.BOLD,16));

        l16=new JLabel("NOTE : Please Remember the Form Number.");
        l16.setFont(new Font("Arial",Font.BOLD,14));

        b=new JButton("Next");
        b.setFont(new Font("Raleway",Font.BOLD,16));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        //for set Layout....
        setLayout(null);
        l1.setBounds(110,22,600,55);
        add(l1);
        l2.setBounds(90,90,400,40);
        add(l2);
        l3.setBounds(90,150,200,20);
        add(l3);
        t1.setBounds(300,150,230,30);
        add(t1);
        l4.setBounds(90,190,200,20);
        add(l4);
        t2.setBounds(300,190,230,30);
        add(t2);

        l5.setBounds(90,230,200,20);
        add(l5);
        datechooser.setBounds(300,230,230,30);
        add(datechooser);

        /*l6.setBounds(260,230,80,20);
        add(l6);
        c1.setBounds(310,230,60,20);
        add(c1);
        l7.setBounds(390,230,80,20);
        add(l7);
        c2.setBounds(450,230,60,20);
        add(c2);
        l8.setBounds(530,230,80,20);
        add(l8);
        c3.setBounds(580,230,80,20);
        add(c3);*/

        l9.setBounds(90,270,200,20);
        add(l9);
        r1.setBounds(300,270,80,20);
        add(r1);
        r2.setBounds(380,270,80,20);
        add(r2);
        r3.setBounds(475,270,80,20);
        add(r3);

        l10.setBounds(90,310,200,20);
        add(l10);
        t3.setBounds(300,310,230,30);
        add(t3);

        l11.setBounds(90,350,200,20);
        add(l11);
        r4.setBounds(300,350,110,20);
        add(r4);
        r5.setBounds(430,350,130,20);
        add(r5);

        l12.setBounds(90,390,200,20);
        add(l12);
        t4.setBounds(300,390,230,30);
        add(t4);
        l13.setBounds(90,430,200,20);
        add(l13);
        t5.setBounds(300,430,230,30);
        add(t5);
        l14.setBounds(90,470,200,20);
        add(l14);
        t6.setBounds(300,470,230,30);
        add(t6);
        l15.setBounds(90,510,200,20);
        add(l15);
        t7.setBounds(300,510,230,30);
        add(t7);

        l16.setBounds(90,560,400,30);
        add(l16);

        b.setBounds(560,600,110,30);
        add(b);


        //for action performed on buttons....
        b.addActionListener(this);

        //for set background color of container....
        getContentPane().setBackground(Color.WHITE);

        //for set container size and Location...
        setSize(750,700);
        setLocation(330,10);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae)
    {
         String formno=String.valueOf(first4),
                name=t1.getText(),
                fathername=t2.getText(),
                dob=((JTextField) datechooser.getDateEditor().getUiComponent()).getText();

       /* String ac=(String)c1.getSelectedItem(),
               bc=(String)c2.getSelectedItem(),
               cc=(String)c3.getSelectedItem();*/

        String gender=null;
        if(r1.isSelected())
            gender="Male";
        else if(r2.isSelected())
            gender="Female";
        else if(r3.isSelected())
            gender="Others";
        
        String email=t3.getText();

        String maritalstatus=null;
        if(r4.isSelected())
            maritalstatus="Married";
        else if(r5.isSelected())
            maritalstatus="Unmarried";

        String address=t4.getText(),
               city=t5.getText(),
               pincode=t6.getText(),
               state=t7.getText();

        try
        {

            Conn c=new Conn();
            //DBMS query.....
            String q1="insert into signup1 values('"+formno+"','"+name+"','"+fathername+"','"+dob+"','"+gender+"','"+email+"','"+maritalstatus+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
            //Insert data in DBMS....
            c.s.executeUpdate(q1);

            dispose();
            new SignUp2(formno).setVisible(true);

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new SignUp1().setVisible(true);
    }
}
