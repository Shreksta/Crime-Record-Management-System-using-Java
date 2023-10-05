package crime.rec.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewCriminal extends JFrame implements ActionListener{

    JTable table;
    Choice ccaseId;
    JButton search, print, update, back;
    
    ViewCriminal() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        table = new JTable();
        
        JLabel searchlbl = new JLabel("Search by Case Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        ccaseId = new Choice();
        ccaseId.setBounds(180, 20, 150, 20);
        add(ccaseId);
        
        //
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from criminal");         
            while(rs.next()) {
            	ccaseId.add(rs.getString("caseId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
       
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from criminal");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/img4.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(5, 5, 1120, 630);
		add(image);
        
        
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
           String query = "select * from criminal where caseId = '"+ccaseId.getSelectedItem()+"'";
           try {
        	  Conn c = new Conn();
        	  ResultSet rs = c.s.executeQuery(query);
        	  table.setModel(DbUtils.resultSetToTableModel(rs));
           }catch (Exception e) {
        	   e.printStackTrace();
           }
        } else if (ae.getSource() == print) {
        	try {
        		table.print();
             }catch (Exception e) {
          	   e.printStackTrace();
             }
        } else if (ae.getSource() == update) {
        	setVisible(false);
        	new UpdateCriminal(ccaseId.getSelectedItem());
           
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewCriminal();
    }
}
