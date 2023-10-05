package crime.rec.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteCriminal extends JFrame implements ActionListener {
    
    Choice cCaseId;
    JButton delete, back;
    JTextField lblname, lblphone, lbljailterm;
    
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    DeleteCriminal() {
    	setLayout(null);

      
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icons/img5.jpg"));
        Image backgroundImage = backgroundIcon.getImage();
        
        
        setContentPane(new BackgroundPanel(backgroundImage));
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Font labelFont = new Font("Arial", Font.BOLD, 18); // Increase font size for labels
        Font textFieldFont = new Font("Arial", Font.PLAIN, 18); // Increase font size for text fields
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        
        JLabel labelcaseId = new JLabel("Case Id");
        labelcaseId.setBounds(50, 50, 150, 30);
        labelcaseId.setFont(labelFont);
        add(labelcaseId);
        
        cCaseId = new Choice();
        cCaseId.setBounds(200, 50, 200, 30);
        add(cCaseId);
        
        try {
            Conn c = new Conn();
            String query = "select * from criminal";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
            	cCaseId.add(rs.getString("caseId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 200, 30);
        lblname.setFont(textFieldFont);
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 150, 200, 30);
        lblphone.setFont(textFieldFont);
        add(lblphone);
        
        JLabel labeljailterm = new JLabel("JailTerm");
        labeljailterm.setBounds(50, 200, 100, 30);
        add(labeljailterm);
        
        JLabel lbljailterm = new JLabel();
        lbljailterm.setBounds(200, 200, 200, 30);
        lbljailterm.setFont(textFieldFont);
        add(lbljailterm);
        
        try {
            Conn c = new Conn();
            String query = "select * from criminal where caseId = '"+cCaseId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lbljailterm.setText(rs.getString("jailterm"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cCaseId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from criminal where caseId = '"+cCaseId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lbljailterm.setText(rs.getString("jailterm"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete Record");
        delete.setBounds(50, 300, 200, 40);
        delete.setFont(buttonFont);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(280, 300, 200, 40);
        back.setFont(buttonFont);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/del.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 320, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image); 
        
        setSize(900, 700);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from criminal where caseId = '"+cCaseId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Criminal Record Deleted Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new DeleteCriminal();
    }
}
