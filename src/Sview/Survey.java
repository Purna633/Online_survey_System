package Sview;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import SController.Controller;
import SController.SControll;
import SUtil.SUtil;
import SUtil.Util;
import java.util.Properties;


public class Survey {
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l20;
    JRadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14;
    JButton b1,b2,b3;
    JTextArea t1;
    JSlider ratingSlider; // New rating slider component
    int rating;
    //public String email;
    //private final SController scontroll;
    public Survey()
    {
       SControll Scontroll=new SControll();
       SUtil ut=new SUtil();
       //PersonalData p1=new PersonalData();


        f=new JFrame("welcome to Survey page");
        f.getContentPane().setBackground(Color.WHITE);
        f.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK));

        l1=new JLabel("Product Satisfaction Survey:");
        l1.setBounds(280,30,300,50);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Arial",Font.BOLD,20));
        l1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        l20=new JLabel("");
        l20.setBounds(50,50,150,15);
        l20.setForeground(Color.BLACK);
        l20.setFont(new Font("Arial",Font.BOLD,12));
        l20.setBorder(new LineBorder(Color.BLACK));


        l2=new JLabel("1. have you ever purchased a product or service from our website??");
        l2.setBounds(50,100,400,30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Arial",Font.BOLD,12));
        r1=new JRadioButton("Yes");
        r1.setForeground(Color.BLACK);
        r1.setFont(new Font("Arial",Font.BOLD,12));
        r1.setBounds(50,150,75,30);
        r2=new JRadioButton("No");
        r2.setBounds(200,150,75,30);
        r2.setForeground(Color.BLACK);
        r2.setFont(new Font("Arial",Font.BOLD,12));

        ButtonGroup obj1=new ButtonGroup();
        obj1.add(r1);
        obj1.add(r2);

        l3=new JLabel("2. how did you hear about our website??");
        l3.setBounds(50,200,300,30);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Arial",Font.BOLD,12));
        r3=new JRadioButton("Website");
        r3.setForeground(Color.BLACK);
        r3.setFont(new Font("Arial",Font.BOLD,12));
        r3.setBounds(50,250,120,30);
        r4=new JRadioButton("Facebook");
        r4.setBounds(200,250,120,30);
        r4.setForeground(Color.BLACK);
        r4.setFont(new Font("Arial",Font.BOLD,12));
        r5=new JRadioButton("Instagram");
        r5.setForeground(Color.BLACK);
        r5.setFont(new Font("Arial",Font.BOLD,12));
        r5.setBounds(350,250,120,30);
        r6=new JRadioButton("Other");
        r6.setBounds(500,250,120,30);
        r6.setForeground(Color.BLACK);
        r6.setFont(new Font("Arial",Font.BOLD,12));

        ButtonGroup obj2=new ButtonGroup();
        obj2.add(r3);
        obj2.add(r4);
        obj2.add(r5);
        obj2.add(r6);


        l4=new JLabel("3. Now please think about the features and benefits of the [PRODUCT] itself.How satisfied are you with the [PRODUCT]: ");
        l4.setBounds(50,300,700,30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Arial",Font.BOLD,12));
        r7=new JRadioButton("Superior");
        r7.setForeground(Color.BLACK);
        r7.setFont(new Font("Arial",Font.BOLD,12));
        r7.setBounds(50,350,150,30);
        r8=new JRadioButton("Very Satisfactory");
        r8.setBounds(200,350,150,30);
        r8.setForeground(Color.BLACK);
        r8.setFont(new Font("Arial",Font.BOLD,12));
        r9=new JRadioButton("About Average");
        r9.setForeground(Color.BLACK);
        r9.setFont(new Font("Arial",Font.BOLD,12));
        r9.setBounds(350,350,150,30);
        r10=new JRadioButton("Very Poor");
        r10.setBounds(500,350,150,30);
        r10.setForeground(Color.BLACK);
        r10.setFont(new Font("Arial",Font.BOLD,12));

        ButtonGroup obj3=new ButtonGroup();
        obj3.add(r7);
        obj3.add(r8);
        obj3.add(r9);
        obj3.add(r10);


        l5=new JLabel("4. Now please think about the features and benefits of the [PRODUCT] itself. How satisfied are you with the [PRODUCT]:");
        l5.setBounds(50,400,700,30);
        l5.setForeground(Color.BLACK);
        r11=new JRadioButton("Very Unsatisfactory");
        r11.setForeground(Color.BLACK);
        r11.setFont(new Font("Arial",Font.BOLD,12));
        r11.setBounds(50,450,150,30);
        r12=new JRadioButton("About Average");
        r12.setBounds(200,450,150,30);
        r12.setForeground(Color.BLACK);
        r12.setFont(new Font("Arial",Font.BOLD,12));
        r13=new JRadioButton("Somewhat Satisfactory");
        r13.setForeground(Color.BLACK);
        r13.setFont(new Font("Arial",Font.BOLD,12));
        r13.setBounds(350,450,150,30);
        r14=new JRadioButton("Very Satisfactory");
        r14.setBounds(500,450,150,30);
        r14.setForeground(Color.BLACK);
        r14.setFont(new Font("Arial",Font.BOLD,12));

        ButtonGroup obj4=new ButtonGroup();
        obj4.add(r11);
        obj4.add(r12);
        obj4.add(r13);
        obj4.add(r14);

        l6=new JLabel("5. Rating");
        l6.setBounds(50,500,80,30);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Arial",Font.BOLD,12));

        ratingSlider = new JSlider(JSlider.HORIZONTAL, 0, 5, 0); // Create rating slider
        ratingSlider.setMajorTickSpacing(1);
        ratingSlider.setPaintTicks(true);
        ratingSlider.setPaintLabels(true);
        ratingSlider.setBounds(200, 500, 250, 50);
        ratingSlider.addChangeListener(e -> rating = ratingSlider.getValue());

        l7=new JLabel("6. If you are not satisfied with the product, will you please describe why.");
        l7.setBounds(50,550,700,30);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Arial",Font.BOLD,12));
        t1=new JTextArea("");
        t1.setBounds(50,580,500,50);
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("Arial",Font.BOLD,12));
        t1.setBorder(new LineBorder(Color.BLACK));

        b1=new JButton("submit");
        b1.setBounds(450,650,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial",Font.BOLD,12));

        b1.addActionListener(e -> {

            String q1= r1.isSelected() ? "Yes":"No";
            String q2="";
            if (r3.isSelected()) {
                q2 = "Website";
            } else if (r4.isSelected()) {
                q2 = "Facebook";
            } else if (r5.isSelected()) {
                q2 = "Instagram";
            } else if (r6.isSelected()) {
                q2 = "Other";
            }
            String q3="";
            if (r7.isSelected()) {
                q3 = "Superior";
            } else if (r8.isSelected()) {
                q3 = "Very Satisfactory";
            } else if (r9.isSelected()) {
                q3 = "About Average";
            } else if (r10.isSelected()) {
                q3 = "Very Poor";
            }
            String q4="";
            if (r11.isSelected()) {
                q4 = "Very Unsatisfactory";
            } else if (r12.isSelected()) {
                q4 = "About Average";
            } else if (r13.isSelected()) {
                q4 = "Somewhat Satisfactory";
            } else if (r14.isSelected()) {
                q4 = "Very Satisfactory";
            }
            int rating1=ratingSlider.getValue();
            String rating=String.valueOf(rating1);

            String des=t1.getText();
            String email=l20.getText();

            if (isValidString(q1) && isValidString(q2) && isValidString(q3) && isValidString(q4) &&
                    isValidString(rating) && isValidDescription(des)&& isValidString(email)) {
                Scontroll.addSurvey(q1, q2, q3, q4, rating, des, email);
                JOptionPane.showMessageDialog(b1, "Survey submitted successfully");
            } else {
                // Check which section is missing and provide a specific validation message
                if (!isValidString(q1)) {
                    JOptionPane.showMessageDialog(b1, "Please select an option for question 1");
                } else if (!isValidString(q2)) {
                    JOptionPane.showMessageDialog(b1, "Please select an option for question 2");
                } else if (!isValidString(q3)) {
                    JOptionPane.showMessageDialog(b1, "Please select an option for question 3");
                } else if (!isValidString(q4)) {
                    JOptionPane.showMessageDialog(b1, "Please select an option for question 4");
                } else if (!isValidString(rating)) {
                    JOptionPane.showMessageDialog(b1, "Please rate the product");
                } else if (!isValidDescription(des)) {
                    JOptionPane.showMessageDialog(b1, "Please enter a description for question 6");
                }
                else if (!isValidString(email)) {
                    JOptionPane.showMessageDialog(b1, "Please enter a email 6");
                }
            }
        });
        b2=new JButton("back");
        b2.setBounds(50,650,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial",Font.BOLD,12));
        b2.addActionListener(e->{
            new PersonalData();
            f.dispose();
        });
        b3=new JButton("clear");
        b3.setBounds(250,650,100,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial",Font.BOLD,12));
        b3.addActionListener(e->{
            obj1.clearSelection();
            obj2.clearSelection();
            obj3.clearSelection();
            obj4.clearSelection();
            // Reset rating slider to default value
            ratingSlider.setValue(0);
            // Clear text area
            t1.setText("");
        });

        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(r1);
        f.add(r2);
        f.add(l5);
        f.add(l6);
        f.add(l7);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(r3);
        f.add(r4);
        f.add(r5);
        f.add(r6);
        f.add(r7);
        f.add(r8);
        f.add(r9);
        f.add(r10);
        f.add(r11);
        f.add(r12);
        f.add(r13);
        f.add(r14);
        f.add(l20);

        f.add(ratingSlider);
        f.setSize(850,730);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private boolean isValidString(String str) {
        return str != null && !str.isEmpty();
    }
    private boolean isValidDescription(String description) {
        return description.matches("[a-zA-Z ]+");
    }

    public static void main(String[] args)
    {

        Survey obj=new Survey();
    }
}

