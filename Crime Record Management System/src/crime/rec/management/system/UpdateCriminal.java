package crime.rec.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;


 
public class UpdateCriminal extends JFrame implements ActionListener {
	
	
	JTextField tfgender, tffname, tfaddress, tfphone, tfaadhar, tfjailterm, tfnoc, tfctype ; 
	JLabel lblcaseid;
	JButton add,back;
	String caseId;
	
	UpdateCriminal(String caseId) {
		this.caseId= caseId;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Update Criminal Details");
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font("calibri", Font.BOLD, 25));
		add(heading);
		
		JLabel labelname = new JLabel("Criminal Name");
		labelname.setBounds(50, 150, 150, 30);
		labelname.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelname);
		
		JLabel lblname = new JLabel();
		lblname.setBounds(200, 150, 150, 30);
		add(lblname);
		
		//
		JLabel labelfname = new JLabel("Father's Name");
		labelfname.setBounds(450, 150, 150, 30);
		labelfname.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelfname);
		
		tffname = new JTextField();
		tffname.setBounds(600, 150, 150, 30);
		add(tffname);
		
		//
		
		JLabel labeldob = new JLabel("DOB");
		labeldob.setBounds(50, 200, 150, 30);
		labeldob.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeldob);
		
		JLabel lbldob = new JLabel();
		lbldob.setBounds(200, 200, 150, 30);
		add(lbldob);
		
		//
		JLabel labelnoofcrimes = new JLabel("No of crimes cmtd");
		labelnoofcrimes.setBounds(450, 200, 150, 30);
		labelnoofcrimes.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelnoofcrimes);
		
		tfnoc = new JTextField();
		tfnoc.setBounds(600, 200, 150, 30);
		add(tfnoc);
		
		//
		JLabel labeladdress = new JLabel("Address");
		labeladdress.setBounds(50, 250, 150, 30);
		labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeladdress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(200, 250, 150, 30);
		add(tfaddress);
		
		//
		JLabel labelphone = new JLabel("Phone");
		labelphone.setBounds(450, 250, 150, 30);
		labelphone.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(600, 250, 150, 30);
		add(tfphone);
		//
		
		JLabel labeljailterm = new JLabel("Jail Term");
		labeljailterm.setBounds(50, 300, 150, 30);
		labeljailterm.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeljailterm);
		
		tfjailterm = new JTextField();
		tfjailterm.setBounds(200, 300, 150, 30);
		add(tfjailterm);
		
		//
		
		JLabel labelgender = new JLabel("Gender");
		labelgender.setBounds(450, 300, 150, 30);
		labelgender.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelgender);
		
		

		tfgender = new JTextField();
		tfgender.setBackground(Color.WHITE);
		tfgender.setBounds(600, 300, 150, 30);
		add(tfgender);
		
		
		//
		JLabel labelctype = new JLabel("Criminal offence type");
		labelctype.setBounds(50, 350, 150, 30);
		labelctype.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelctype);
		
		tfctype = new JTextField();
		tfctype.setBounds(200, 350, 150, 30);
		add(tfctype);
		
		//
		JLabel labelaadhar = new JLabel("Aadhar no");
		labelaadhar.setBounds(450, 350, 150, 30);
		labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelaadhar);
		
		JLabel lblaadhar = new JLabel();
		lblaadhar.setBounds(600, 350, 150, 30);
		add(lblaadhar);
		//
		
		JLabel labelcaseid = new JLabel("Case ID");
		labelcaseid.setBounds(50, 400, 150, 30);
		labelcaseid.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelcaseid);
		
		lblcaseid = new JLabel();
		lblcaseid.setBounds(200, 400, 150, 30);
		lblcaseid.setFont(new Font("serif", Font.PLAIN, 20));
		add(lblcaseid);
		
		try {
			Conn c = new Conn();
			String query = "select * from criminal where caseId = '"+caseId+"'";
			ResultSet rs =  c.s.executeQuery(query);
			while(rs.next()) {
				lblname.setText(rs.getString("name"));
				tffname.setText(rs.getString("fname"));
				tfaddress.setText(rs.getString("address"));
				tfnoc.setText(rs.getString("noofcrimes"));
				tfphone.setText(rs.getString("phone"));
				tfjailterm.setText(rs.getString("jailterm"));
				tfgender.setText(rs.getString("gender"));
				lblaadhar.setText(rs.getString("aadhar"));
				lblcaseid.setText(rs.getString("caseId"));
				tfctype.setText(rs.getString("crimetype"));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		//
		
		add = new JButton("Update Criminal Details");
		add.setBounds(250, 550, 150, 40);
		add.addActionListener(this);
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add(add);
		
		back = new JButton("Go back");
		back.setBounds(450, 550, 150, 40);
		back.addActionListener(this);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/img4.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(5, 5, 1120, 630);
		add(image);
				

		
		
		setSize(900, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == add) {
			
			String fname = tffname.getText();
			String noofcrimes = tfnoc.getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String jailterm = tfjailterm.getText();
			String gender = tfgender.getText();
			String crimetype = tfctype.getText();
			
			try {
				Conn conn = new Conn();
				String query = "update criminal set fname = '"+fname+"', noofcrimes = '"+noofcrimes+"', address = '"+address+"', phone = '"+phone+"', jailterm = '"+jailterm+"', gender = '"+gender+"', crimetype = '"+crimetype+"' where caseId = '"+caseId+"'";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details Updated Successfully");
				setVisible(false);
				new Home();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
			new Home();
		}
	}
	public static void main(String[] args) {
		new UpdateCriminal("");
	}
}
