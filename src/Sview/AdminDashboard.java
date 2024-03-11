package Sview;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import Auth.Login;
import SController.Controller;
import SUtil.Util;
import Sview.Survey;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.xdevapi.Table;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminDashboard {
    JFrame f,tableFrame;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    Util util;
    JTable table;
    //JScrollPane table;
    //private final Controller controller;
    public AdminDashboard()
    {
        Controller controller=new Controller();
        util =new Util();

        f=new JFrame("admin dashboard");
        f.getContentPane().setBackground(Color.WHITE);
        f.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK));

        l1=new JLabel();
        l1.setBounds(5,5,1195,50);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Arial",Font.BOLD,20));
        l1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        l2=new JLabel(" Admin Dashboard");
        l2.setBounds(400,5,300,30);
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Arial",Font.BOLD,20));

        l3=new JLabel();
        l3.setBounds(5,60,120,550);
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        b7=new JButton("User Details");
        b7.setBounds(8,100,90,30);
        b7.setHorizontalAlignment(SwingConstants.CENTER);
        b7.setForeground(Color.BLACK);
        b7.setFont(new Font("Arial",Font.BOLD,12));
        b7.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        b6=new JButton("Survey Details");
        b6.setBounds(8,200,90,30);
        b6.setHorizontalAlignment(SwingConstants.CENTER);
        b6.setForeground(Color.BLACK);
        b6.setFont(new Font("Arial",Font.BOLD,12));
        b6.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        b6.addActionListener(e->{
            new SurveyDetails();
            f.dispose();

        });
        b8=new JButton("LogOut");
        b8.setBounds(8,450,90,30);
        b8.setHorizontalAlignment(SwingConstants.CENTER);
        b8.setForeground(Color.BLACK);
        b8.setFont(new Font("Arial",Font.BOLD,12));
        b8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        b8.addActionListener(e->{
            new Login();

            f.dispose();


        });



        l6=new JLabel("Name:");
        l6.setBounds(150,90,80,30);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Arial",Font.BOLD,12));
        t1=new JTextField("");
        t1.setBounds(250,90,250,30);
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("Arial",Font.BOLD,12));

        l7=new JLabel("Email");
        l7.setBounds(150,140,80,30);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Arial",Font.BOLD,12));
        t2=new JTextField("");
        t2.setBounds(250,140,250,30);
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("Arial",Font.BOLD,12));

        l8=new JLabel("Phone:");
        l8.setBounds(150,190,80,30);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Arial",Font.BOLD,12));
        t3=new JTextField();
        t3.setBounds(250,190,250,30);
        t3.setForeground(Color.BLACK);
        t3.setFont(new Font("Arial",Font.BOLD,12));

        l9=new JLabel("Gender:");
        l9.setBounds(150,240,80,30);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Arial",Font.BOLD,12));
        r1=new JRadioButton("Male");
        r1.setForeground(Color.BLACK);
        r1.setFont(new Font("Arial",Font.BOLD,12));
        r1.setBounds(250,240,75,30);
        r2=new JRadioButton("Female");
        r2.setBounds(400,240,75,30);
        r2.setForeground(Color.BLACK);
        r2.setFont(new Font("Arial",Font.BOLD,12));

        ButtonGroup obj1=new ButtonGroup();
        obj1.add(r1);
        obj1.add(r2);

        l10=new JLabel("Address");
        l10.setBounds(150,290,80,30);
        l10.setForeground(Color.BLACK);
        t4=new JTextField();
        t4.setBounds(250,290,250,30);
        t4.setForeground(Color.BLACK);
        t4.setFont(new Font("Arial",Font.BOLD,12));

        l11=new JLabel("Father Name");
        l11.setBounds(150,340,80,30);
        l11.setForeground(Color.BLACK);
        l11.setFont(new Font("Arial",Font.BOLD,12));
        t5=new JTextField();
        t5.setBounds(250,340,250,30);
        t5.setForeground(Color.BLACK);
        t5.setFont(new Font("Arial",Font.BOLD,12));

        l12=new JLabel("Mother Name");
        l12.setBounds(150,390,80,30);
        l12.setForeground(Color.BLACK);
        l12.setFont(new Font("Arial",Font.BOLD,12));
        t6=new JTextField();
        t6.setBounds(250,390,250,30);
        t6.setFont(new Font("Arial",Font.BOLD,12));
        t6.setForeground(Color.BLACK);

        b1=new JButton("register");
        b1.setBounds(150,460,80,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial",Font.BOLD,12));


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
            }

        });
        b2=new JButton("update");
        b2.setBounds(250,460,80,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial",Font.BOLD,12));

        b2.addActionListener(e2->
        {
            String name = t1.getText();
            String email = t2.getText();
            String phone = t3.getText();
            String gender= r1.isSelected() ? "Male":"Female";
            String address=t4.getText();
            String fName=t5.getText();
            String mName=t6.getText();

            if (!isValidString(name)) {
                JOptionPane.showMessageDialog(b2, "Please enter a valid name");
            } else if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(b2, "Please enter a valid email address");
            } else if (!isValidPhoneNumber(phone)) {
                JOptionPane.showMessageDialog(b2, "Please enter a valid phone number starting with '98' and consisting of exactly 10 digits");
            } else if (!isValidString(address)) {
                JOptionPane.showMessageDialog(b2, "Please enter a valid address");
            } else if (!isValidString(fName)) {
                JOptionPane.showMessageDialog(b2, "Please enter a valid father's name");
            } else if (!isValidString(mName)) {
                JOptionPane.showMessageDialog(b2, "Please enter a valid mother's name");
            } else {
                // All fields are valid, proceed with form submission
                controller.update(name, email, phone, gender, address, fName, mName);
                JOptionPane.showMessageDialog(b2, "updated successfully");
            }

        });

        b3=new JButton("delete");
        b3.setBounds(350,460,80,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial",Font.BOLD,12));

        b3.addActionListener(e3->{
            String email = t2.getText();
            controller.delete(email);
            JOptionPane.showMessageDialog(b3,"deleted successfully");
        });

        b4=new JButton("clear");
        b4.setBounds(450,460,80,30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("Arial",Font.BOLD,12));

        b4.addActionListener(e -> {
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
        b5=new JButton("Print");
        b5.setBounds(865,460,80,30);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("Arial",Font.BOLD,12));

        b5.addActionListener(e -> {
            // Clear all input fields when the button is clicked
            /*MessageFormat msg=new MessageFormat("ABC company");
            MessageFormat f=new MessageFormat("user details");*/

            try {
                //table.print(JTable.PrintMode.NORMAL,msg,f);
                printTableToPDF(table);
            } catch (Exception ex) {
                //System.out.println(ex.toString());
                ex.printStackTrace();
            }
        });
        l13=new JLabel("Personal Details:");
        l13.setBounds(650,70,180,30);
        l13.setForeground(Color.BLACK);
        l13.setFont(new Font("Arial",Font.BOLD,20));
        l13.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        DefaultTableModel model = new DefaultTableModel(new String[]{"Name", "Email", "Phone", "Gender", "Address", "fName", "mName"}, 0);
        JTable table1 = new JTable(model);
        JScrollPane table = new JScrollPane(table1);
        table.setBounds(550,120,400,300);
        table.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        // Set background color for JScrollPane
        table.setBackground(Color.LIGHT_GRAY);

        // Set foreground color for JTable (table header)
        table1.getTableHeader().setForeground(Color.RED);

        // Set foreground color for JTable (table cells)
        table1.setForeground(Color.BLACK);
        ResultSet rs = util.display();
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String gender = rs.getString("gender");
                String address = rs.getString("address");
                String fName = rs.getString("fName");
                String mName = rs.getString("mName");
                model.addRow(new Object[]{name, email, phone, gender, address, fName, mName});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Add a ListSelectionListener to the table
        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table1.getSelectedRow();
                    if (selectedRow != -1) { // If a row is selected
                        // Get data from the selected row
                        String name = (String) model.getValueAt(selectedRow, 0);
                        String email = (String) model.getValueAt(selectedRow, 1);
                        String phone = (String) model.getValueAt(selectedRow, 2);
                        String gender = (String) model.getValueAt(selectedRow, 3);
                        String address = (String) model.getValueAt(selectedRow, 4);
                        String fName = (String) model.getValueAt(selectedRow, 5);
                        String mName = (String) model.getValueAt(selectedRow, 6);

                        // Set the retrieved data into the input fields
                        t1.setText(name);
                        t2.setText(email);
                        t3.setText(phone);
                        if (gender.equals("Male")) {
                            r1.setSelected(true);
                        } else {
                            r2.setSelected(true);
                        }
                        t4.setText(address);
                        t5.setText(fName);
                        t6.setText(mName);
                    }
                }
            }
        });


        f.add(l1);
        l1.add(l2);
        f.add(l3);
        l3.add(b7);
        l3.add(b6);
        l3.add(b8);
        f.add(l6);
        f.add(l7);
        f.add(l8);
        f.add(l9);
        f.add(l10);
        f.add(l11);
        f.add(l12);
        f.add(l13);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);
        f.add(t6);

        f.add(r1);
        f.add(r2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(table);
        f.setSize(1000,600);
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
    private void printTableToPDF(JTable table) {
        String dest = "output.pdf";

        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(dest));
            doc.open();

            // Create a table to hold the JTable data
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

            // Add table headers
            for (int i = 0; i < table.getColumnCount(); i++) {
                pdfTable.addCell(new PdfPCell(new Phrase(table.getColumnName(i))));
            }

            // Add table data
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    pdfTable.addCell(table.getValueAt(i, j).toString());
                }
            }

            // Add the table to the document
            doc.add(pdfTable);

        } catch (DocumentException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DocumentException: " + e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "FileNotFoundException: " + e.getMessage());
        } finally {
            // Close the document
            if (doc != null) {
                doc.close();
            }
        }
    }


    public static void main(String[] args)
    {

        AdminDashboard obj=new AdminDashboard();
    }
}




