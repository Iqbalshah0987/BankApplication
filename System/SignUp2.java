package System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUp2 extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    JTextField t1,t2,t3;
    JButton b;
    JRadioButton r1,r2,r3,r4;
    JComboBox<String> c1,c2,c3,c4,c5;
    String formno;

    SignUp2(String formno)
    {
        this.formno=formno;

        //for set title....
        setTitle("NEW ACCOUNT APPLICATION FORM - Page 2");

        //for set Image Icon.....
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));   //get the image from System....
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);  //for set image height and width....
        ImageIcon i3=new ImageIcon(i2); //for change Image object to ImageIcon....
        l13=new JLabel(i3);
        l13.setBounds(10,0,100,100);
        add(l13);

        //for set labels,textfields,buttons, radiobuttons and combobox....
        l1=new JLabel("Page 2: Additional Details");
        l1.setFont(new Font("Ralewya",Font.BOLD,28));

        l2=new JLabel("Form No :");
        l2.setFont(new Font("Ralewya",Font.BOLD,16));
        l14=new JLabel(formno);
        l14.setFont(new Font("Ralewya",Font.BOLD,16));
        /*t1=new JTextField();
        t1.setFont(new Font("Raleway",Font.ITALIC,14));*/

        l3=new JLabel("Religion :");
        l3.setFont(new Font("Ralewya",Font.BOLD,20));
        String religion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        c1=new JComboBox<String>(religion);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(Color.WHITE);

        l4=new JLabel("Category :");
        l4.setFont(new Font("Ralewya",Font.BOLD,20));
        String category[]={"General","OBC","SC","ST","Other"};
        c2=new JComboBox<String>(category);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(Color.WHITE);

        l5=new JLabel("Income :");
        l5.setFont(new Font("Ralewya",Font.BOLD,20));
        String income[]={"0","< 25,000","< 50,000","< 75,000","Above 1,00,000"};
        c3=new JComboBox<String>(income);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBackground(Color.WHITE);

        l6=new JLabel("Educational");
        l6.setFont(new Font("Ralewya",Font.BOLD,20));
        l7=new JLabel("Qualification :");
        l7.setFont(new Font("Ralewya",Font.BOLD,20));
        String education[]={"Illiterate","10th","12th","Non-Graduate","Graduate","Other"};
        c4=new JComboBox<String>(education);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBackground(Color.WHITE);

        l8=new JLabel("Occupation :");
        l8.setFont(new Font("Ralewya",Font.BOLD,20));
        String occupation[]={"Student","Salaried","Selt-Employeed","Business","Retired"};
        c5=new JComboBox<String>(occupation);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBackground(Color.WHITE);

        l9=new JLabel("PAN Number :");
        l9.setFont(new Font("Ralewya",Font.BOLD,20));
        t2=new JTextField();
        t2.setFont(new Font("Raleway",Font.BOLD,16));

        l10=new JLabel("Aadhaar Number :");
        l10.setFont(new Font("Ralewya",Font.BOLD,20));
        t3=new JTextField();
        t3.setFont(new Font("Raleway",Font.BOLD,16));

        l11=new JLabel("Senior Citizen :");
        l11.setFont(new Font("Ralewya",Font.BOLD,20));
        r1=new JRadioButton("Yes");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r2=new JRadioButton("No");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        //for select only one radion button.....
        ButtonGroup groupsenior=new ButtonGroup();
        groupsenior.add(r1);
        groupsenior.add(r2);

        l12=new JLabel("Existing Account :");
        l12.setFont(new Font("Ralewya",Font.BOLD,20));
        r3=new JRadioButton("Yes");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r4=new JRadioButton("No");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        //for select only one radion button.....
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r3);
        groupaccount.add(r4);

        b=new JButton("Next");
        b.setFont(new Font("Raleway",Font.BOLD,16));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        //for set Layout....
        setLayout(null);
        l1.setBounds(110,40,400,45);
        add(l1);

        l2.setBounds(550,20,80,20);
        add(l2);
        l14.setBounds(630,20,80,25);
        add(l14);

        l3.setBounds(90,100,200,30);
        add(l3);
        c1.setBounds(300,100,200,30);
        add(c1);

        l4.setBounds(90,145,200,30);
        add(l4);
        c2.setBounds(300,145,200,30);
        add(c2);

        l5.setBounds(90,190,200,30);
        add(l5);
        c3.setBounds(300,190,200,30);
        add(c3);

        l6.setBounds(90,235,200,30);
        add(l6);
        l7.setBounds(100,255,190,30);
        add(l7);
        c4.setBounds(300,255,200,30);
        add(c4);

        l8.setBounds(90,300,200,30);
        add(l8);
        c5.setBounds(300,300,200,30);
        add(c5);

        l9.setBounds(90,345,200,30);
        add(l9);
        t2.setBounds(300,345,250,30);
        add(t2);

        l10.setBounds(90,390,200,30);
        add(l10);
        t3.setBounds(300,390,250,30);
        add(t3);

        l11.setBounds(90,435,200,30);
        add(l11);
        r1.setBounds(300,435,100,30);
        add(r1);
        r2.setBounds(400,435,100,30);
        add(r2);

        l12.setBounds(90,480,200,30);
        add(l12);
        r3.setBounds(300,480,100,30);
        add(r3);
        r4.setBounds(400,480,100,30);
        add(r4);

        b.setBounds(560,575,110,30);
        add(b);

        //for action performed on buttons....
        b.addActionListener(this);

        //for set the Background Color of Container....
        getContentPane().setBackground(Color.WHITE);

        //for set Container size and Location.....
        setSize(750,700);
        setLocation(330,10);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae)
    {
        // String a=t1.getText();

        String religion=(String)c1.getSelectedItem(),
               category=(String)c2.getSelectedItem(),
               income=(String)c3.getSelectedItem(),
               qualification=(String)c4.getSelectedItem(),
               occupation=(String)c5.getSelectedItem();

        String panno=t2.getText(),
               aadhaarno=t3.getText();
        
        String seniorcitizen=null;
        if(r1.isSelected())
            seniorcitizen="Yes";
        else if(r2.isSelected())
            seniorcitizen="No";

        String existingaccount=null;
        if(r3.isSelected())
            existingaccount="Yes";
        else if(r4.isSelected())
            existingaccount="No";

        try
        {
            Conn cn=new Conn();
            //this is DBMS query.....
            String q1="insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+qualification+"','"+occupation+"','"+panno+"','"+aadhaarno+"','"+seniorcitizen+"','"+existingaccount+"')";
            //Insert data into DBMS....
            cn.s.executeUpdate(q1);

            dispose();
            new SignUp3(formno).setVisible(true);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println(ex);
        }

    }

    public static void main(String[] args) {
        new SignUp2("").setVisible(true);
    }
}
