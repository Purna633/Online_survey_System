package Auth;
import Sview.AdminDashboard;
import Sview.PersonalData;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login implements ActionListener {
    JFrame f;
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JPasswordField p1;
    JButton b2,b1,b3;
    Connection connection;
    Statement statement;
    public Login()
    {
        f=new JFrame("Login Page");
        f.getContentPane().setBackground(Color.WHITE);
        f.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK));

        l4=new JLabel(" Login Page");
        l4.setBounds(170,30,150,40);
        l4.setHorizontalAlignment(SwingConstants.CENTER);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        l4.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        l1=new JLabel("email");
        l1.setBounds(50,100,100,30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Arial",Font.BOLD,12));
        t1=new JTextField("");
        t1.setBounds(150,100,200,30);
        t1.setFont(new Font("Arial",Font.BOLD,12));
        t1.setForeground(Color.BLUE);

        l2=new JLabel("Password");
        l2.setBounds(50,150,100,30);
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Arial",Font.BOLD,12));
        p1=new JPasswordField("");
        p1.setBounds(150,150,200,30);
        p1.setFont(new Font("Arial",Font.BOLD,12));
        p1.setForeground(Color.BLUE);

        b1=new JButton("login");
        b1.setBounds(150,200,80,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial",Font.BOLD,12));

        b2=new JButton("forgot password");
        b2.setBounds(240,200,110,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial",Font.BOLD,12));

        l3=new JLabel("if you don't have a account please register??");
        l3.setBounds(120,250,300,30);
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("Arial",Font.BOLD,12));

        b3=new JButton("register");
        b3.setBounds(250,300,100,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial",Font.BOLD,12));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_survey","root", "@purnaale#1633");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        b1.addActionListener(this);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(t1);
        f.add(p1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.setSize(450,450);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String email = t1.getText();
            String password = new String(p1.getPassword());
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your email.");
                return;
            }

            // Email validation
            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
                return;
            }

            // Check if password is empty
            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your password.");
                return;
            }


            try {
                String query = "SELECT * FROM users WHERE email='" + email + "' AND password='" + password + "'";
                ResultSet rs = statement.executeQuery(query);
                if (rs.next()) {
                    int userType = rs.getInt("user_type");
                    if (userType == 0) {
                        JOptionPane.showMessageDialog(null, "Login Successful as Admin!");
                        new AdminDashboard();
                        f.dispose();
                    } else if (userType == 1) {
                        JOptionPane.showMessageDialog(null, "Login Successful as User!");
                        new PersonalData();
                        f.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }

                rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
    private boolean isValidEmail(String email) {
        // Simple email validation using regular expression
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    public static void main(String[] args)
    {

        Login l=new Login();
    }
}





