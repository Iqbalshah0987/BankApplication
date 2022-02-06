package System;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import java.awt.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5;
    JPasswordField pf1,pf2,pf3;
    JButton b1,b2;
    String pinno;

    PinChange(String pinno)
    {
        this.pinno=pinno;

        //set title....
        // setTitle("PIN CHANGE");

         //for set Image Icon.....
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));   //get the image from System....
         Image i2=i1.getImage().getScaledInstance(750,750,Image.SCALE_DEFAULT);  //for set image height and width....
         ImageIcon i3=new ImageIcon(i2); //for change Image object to ImageIcon....
         l5=new JLabel(i3);
         l5.setBounds(0,0,750,750);
         add(l5);

        //set labels,password fields and buttons.....
        l1=new JLabel("Change Your Pin");
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        l1.setForeground(Color.WHITE);

        /*l2=new JLabel("Current Pin :");
        l2.setFont(new Font("Raleway",Font.BOLD,24));
        l2.setForeground(Color.WHITE);
        pf1=new JPasswordField();
        pf1.setFont(new Font("Raleway",Font.BOLD,20));*/

        l3=new JLabel("New Pin :");
        l3.setFont(new Font("Raleway",Font.BOLD,16));
        l3.setForeground(Color.WHITE);
        pf2=new JPasswordField();
        pf2.setFont(new Font("Raleway",Font.BOLD,18));

        l4=new JLabel("Re-Enter Pin :");
        l4.setFont(new Font("Raleway",Font.BOLD,16));
        l4.setForeground(Color.WHITE);
        pf3=new JPasswordField();
        pf3.setFont(new Font("Raleway",Font.BOLD,18));

        b1=new JButton("CHANGE");
        /*b1.setFont(new Font("Raleway",Font.BOLD,18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);*/
        b2=new JButton("BACK");
        /*b2.setFont(new Font("Raleway",Font.BOLD,18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);*/

        //for set Layout....
        setLayout(null);
        l1.setBounds(200,230,200,40);
        l5.add(l1);

        /*l2.setBounds(90,180,250,50);
        l5.add(l2);
        pf1.setBounds(350,190,300,40);
        add(pf1);*/

        l3.setBounds(130,280,120,40);
        l5.add(l3);
        pf2.setBounds(250,285,170,30);
        add(pf2);

        l4.setBounds(130,340,120,40);
        l5.add(l4);
        pf3.setBounds(250,345,170,30);
        add(pf3);

        b1.setBounds(128,430,140,30);
        l5.add(b1);
        b2.setBounds(292,430,140,30);
        l5.add(b2);


        //for action performed on buttons....
        b1.addActionListener(this);
        b2.addActionListener(this);

        //for set color of the container....
        getContentPane().setBackground(Color.WHITE);

        //for set container size and location....
        setSize(750,750);
        setLocation(330,0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae)
    {
        try 
        {
            /*char arr1[]=pf1.getPassword();
            String a=String.valueOf(arr1);  //convert char[] array to String....*/
            char arr2[]=pf2.getPassword();
            String newpin=String.valueOf(arr2);  //conver char[] array to String.....
            char arr3[]=pf3.getPassword();
            String renewpin=String.valueOf(arr3);  //convert char[] array to String....

            if(ae.getSource()==b1)
            {
                if(newpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please Enter New Pin");
                }
                else if(renewpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please Re-Enter New Pin");
                }
                else if(newpin.equals(renewpin))
                {
                    Conn cn=new Conn();

                    String q1="Update login set PinNo='"+newpin+"' where PinNo='"+pinno+"' ";
                    String q2="Update signup3 set PinNO='"+newpin+"' where PinNo='"+pinno+"' ";
                    String q3="Update bank set PinNO='"+newpin+"' where PinNO='"+pinno+"' ";

                    cn.s.executeUpdate(q1);
                    cn.s.executeUpdate(q2);
                    cn.s.executeUpdate(q3);

                    JOptionPane.showMessageDialog(null,"Pin Changed Successfully");

                    new Transactions(newpin).setVisible(true);
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Pin doesn't match!");
                }
            }
            else if(ae.getSource()==b2)
            {
                new Transactions(pinno).setVisible(true);
                dispose();
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
