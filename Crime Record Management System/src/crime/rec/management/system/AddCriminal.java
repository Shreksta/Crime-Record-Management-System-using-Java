package crime.rec.management.system;
import java.awt.*;
import java.util.Random;
import java.util.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
 
public class AddCriminal extends JFrame implements ActionListener {
	
	Random ran = new Random();
	int number = ran.nextInt(999999);
	
	JTextField tfname, tffname, tfaddress, tfphone, tfaadhar, tfjailterm, tfnoc, tfctype ; 
	JDateChooser dcdob;
	JComboBox cbgender;
	JLabel lblcaseid;
	JButton add,back;
	
    JButton uploadImage; // New button for image upload
    JLabel imageLabel;
    
	AddCriminal() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("ADD CRIMINAL DETAILS");
		heading.setBounds(260, 30, 500, 50);
		heading.setFont(new Font("calibri", Font.BOLD, 42));
		add(heading);
		
		JLabel labelname = new JLabel("Criminal Name");
		labelname.setBounds(50, 150, 150, 30);
		labelname.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelname);
		
		tfname = new JTextField();
		tfname.setBounds(200, 150, 150, 30);
		add(tfname);
		
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
		
		dcdob = new JDateChooser();
		dcdob.setBounds(200, 200, 150, 30);
		add(dcdob);
		
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
		
		
		String genders[] = {"FEMALE","MALE","Other"};
		cbgender = new JComboBox(genders);
		cbgender.setBackground(Color.WHITE);
		cbgender.setBounds(600, 300, 150, 30);
		add(cbgender);
		
		
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
		
		tfaadhar = new JTextField();
		tfaadhar.setBounds(600, 350, 150, 30);
		add(tfaadhar);
		//
		
		JLabel labelcaseid = new JLabel("Case ID");
		labelcaseid.setBounds(50, 400, 150, 30);
		labelcaseid.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelcaseid);
		
		lblcaseid = new JLabel("" + number);
		lblcaseid.setBounds(200, 400, 150, 30);
		lblcaseid.setFont(new Font("serif", Font.PLAIN, 20));
		add(lblcaseid);
		//
		
		add = new JButton("Save");
		add.setBounds(250, 550, 150, 40);
		add.addActionListener(this);
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add(add);
		
		back = new JButton("Go back");
		back.setBounds(450, 550, 150, 40);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		//
		
		uploadImage = new JButton("Upload Image");
        uploadImage.setBounds(450, 400, 150, 30);
        uploadImage.addActionListener(this);
        uploadImage.setBackground(Color.BLACK);
        uploadImage.setForeground(Color.WHITE);
        add(uploadImage);

        //
        imageLabel = new JLabel("");
        imageLabel.setPreferredSize(new Dimension(150, 150));
        imageLabel.setBounds(600, 400, 150, 150);
        imageLabel.setFont(new Font("serif", Font.PLAIN, 14));
        add(imageLabel);
		
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
			String name = tfname.getText();
			String fname = tffname.getText();
			String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
			String noofcrimes = tfnoc.getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String jailterm = tfjailterm.getText();
			String gender = (String) cbgender.getSelectedItem();
			String crimetype = tfctype.getText();
			String aadhar = tfaadhar.getText();
			String caseId = lblcaseid.getText();
			
			try {
				Conn conn = new Conn();
				String query = "insert into criminal values('"+name+"','"+fname+"','"+dob+"','"+noofcrimes+"','"+address+"','"+phone+"','"+jailterm+"','"+gender+"','"+crimetype+"','"+aadhar+"','"+caseId+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details added successfully");
				setVisible(false);
				new Home();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (ae.getSource() == uploadImage) {
            
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String imagePath = selectedFile.getAbsolutePath();
                ImageIcon imageIcon = new ImageIcon(imagePath);
                imageLabel.setIcon(imageIcon);
                imageLabel.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
  
                revalidate();
            } }
		else if(ae.getSource() == back) {
			setVisible(false);
			new Home();
		}}
	
	public static void main(String[] args) {
		new AddCriminal();
	}
}
