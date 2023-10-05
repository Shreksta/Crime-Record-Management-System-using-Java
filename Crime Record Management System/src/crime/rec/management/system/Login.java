package crime.rec.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField tfusername, tfpassword;
    JButton login, back;

    Login() {
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblusername.setBounds(200, 20, 100, 30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setFont(new Font("Tahoma", Font.PLAIN, 32));
        tfusername.setBounds(400, 20, 200, 30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblpassword.setBounds(200, 70, 100, 30);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(400, 70, 200, 30);
        add(tfpassword);

        login = new JButton("LOGIN");
        login.setBounds(300, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/img2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5, 5, 1120, 630);
        add(image);

        setSize(1000, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String username = tfusername.getText();
                String password = tfpassword.getText();

                Conn c = new Conn();
                String query = "select * from register where username = ? and password = ?";
                PreparedStatement pstmt = c.c.prepareStatement(query);
                pstmt.setString(1, username); 
                pstmt.setString(2, password); 

                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    setVisible(false);
                    new Home();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String args[]) {
        new Login();
    }
}
