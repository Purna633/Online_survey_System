package Sview;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import SController.Controller;
import SUtil.Util;
import javax.swing.border.LineBorder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalData {
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JButton b1,b2;
    //private final Controller controller;
    public PersonalData()
    {
        Controller controller=new Controller();
        Util ut=new Util();

        f=new JFrame("personal data");
        f.getContentPane().setBackground(Color.WHITE);
        f.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK));

        l8=new JLabel(" Fill up your personal details");
        l8.setBounds(100,30,300,50);
        l8.setHorizontalAlignment(SwingConstants.CENTER);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Arial",Font.BOLD,20));
        l8.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        l1=new JLabel("Name:");
        l1.setBounds(50,100,80,30);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Arial",Font.BOLD,12));
        t1=new JTextField("");
        t1.setBounds(160,100,250,30);
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("Arial",Font.BOLD,12));

        l2=new JLabel("Email");
        l2.setBounds(50,150,80,30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Arial",Font.BOLD,12));
        t2=new JTextField("");
        t2.setBounds(160,150,250,30);
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("Arial",Font.BOLD,12));

        l3=new JLabel("Phone:");
        l3.setBounds(50,200,80,30);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Arial",Font.BOLD,12));
        t3=new JTextField();
        t3.setBounds(160,200,250,30);
        t3.setForeground(Color.BLACK);
        t3.setFont(new Font("Arial",Font.BOLD,12));

        l4=new JLabel("Gender:");
        l4.setBounds(50,250,80,30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Arial",Font.BOLD,12));
        r1=new JRadioButton("Male");
        r1.setForeground(Color.BLACK);
        r1.setFont(new Font("Arial",Font.BOLD,12));
        r1.setBounds(160,250,75,30);
        r2=new JRadioButton("Female");
        r2.setBounds(320,250,75,30);
        r2.setForeground(Color.BLACK);
        r2.setFont(new Font("Arial",Font.BOLD,12));

        ButtonGroup obj1=new ButtonGroup();
        obj1.add(r1);
        obj1.add(r2);

        l5=new JLabel("Address");
        l5.setBounds(50,300,80,30);
        l5.setForeground(Color.BLACK);
        t4=new JTextField();
        t4.setBounds(160,300,250,30);
        t4.setForeground(Color.BLACK);
        t4.setFont(new Font("Arial",Font.BOLD,12));

        l6=new JLabel("Father Name");
        l6.setBounds(50,350,80,30);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Arial",Font.BOLD,12));
        t5=new JTextField();
        t5.setBounds(160,350,250,30);
        t5.setForeground(Color.BLACK);
        t5.setFont(new Font("Arial",Font.BOLD,12));

        l7=new JLabel("Mother Name");
        l7.setBounds(50,400,80,30);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Arial",Font.BOLD,12));
        t6=new JTextField();
        t6.setBounds(160,400,250,30);
        t6.setFont(new Font("Arial",Font.BOLD,12));
        t6.setForeground(Color.BLACK);

        b2=new JButton("clear");
        b2.setBounds(160,450,80,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial",Font.BOLD,12));

        b1=new JButton("Next");
        b1.setBounds(330,450,80,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial",Font.BOLD,12));
        b2.addActionListener(e -> {
            // Clear all input fields when the button is clicked
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            // Clear radio button selection
            obj1.clearSelection();
        });

        b1.addActionListener(e -> {
            String name = t1.getText();
            String email = t2.getText();
            String phone = t3.getText();
            String gender= r1.isSelected() ? "Male":"Female";
            String address=t4.getText();
            String fName=t5.getText();
            String mName=t6.getText();

            if (!isValidString(name)) {
                JOptionPane.showMessageDialog(b1, "Please enter a valid name");
            } else if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(b1, "Please enter a valid email address");
            } else if (!isValidPhoneNumber(phone)) {
                JOptionPane.showMessageDialog(b1, "Please enter a valid phone number starting with '98' and consisting of exactly 10 digits");
            } else if (!isValidString(address)) {
                JOptionPane.showMessageDialog(b1, "Please enter a valid address");
            } else if (!isValidString(fName)) {
                JOptionPane.showMessageDialog(b1, "Please enter a valid father's name");
            } else if (!isValidString(mName)) {
                JOptionPane.showMessageDialog(b1, "Please enter a valid mother's name");
            } else {
                // All fields are valid, proceed with form submission
                controller.addUser(name, email, phone, gender, address, fName, mName);
                JOptionPane.showMessageDialog(b1, "Added successfully");
                Survey s=new Survey();
                s.l20.setText(t2.getText());
                f.dispose();
            }

        });


        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(l3);
        f.add(t3);
        f.add(l4);
        f.add(r1);
        f.add(r2);
        f.add(l5);
        f.add(l6);
        f.add(l7);
        f.add(b1);
        f.add(b2);
        f.add(t4);
        f.add(t5);
        f.add(t6);
        f.add(l8);
        f.setSize(550,550);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private boolean isValidField(String field) {
        return !field.trim().isEmpty();
    }
    private boolean isValidString(String str) {
        return str.matches("[a-zA-Z]+");
    }
    private boolean isValidEmail(String email) {
        // Regular expression for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    // Method to validate phone number to start with "98" and consist of exactly 10 digits
    private boolean isValidPhoneNumber(String phone) {
        return phone.matches("^98\\d{8}$");
    }

    public static void main(String[] args)
    {

        PersonalData obj=new PersonalData();
    }
}



