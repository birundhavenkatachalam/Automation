package com.birundha.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.birundha.controller.EmployeeController;
import java.sql.SQLException;

public class Registration {

private JFrame frame=new JFrame("Registeration Form");
private JTextField tFirstName;
private JTextField tLastName;
private JTextField tGender;
private JTextField tCreatePassword;
private JTextField tConfirmPassword;
private JTextField tUserId;
private JTextField tRole;
private JButton bSubmit;


public static EmployeeController employee = null;


public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Registration window = new Registration();
window.frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the application.
*/
public Registration() throws ClassNotFoundException, SQLException {

frame=new JFrame();
initialize();
}

/**
* Initialize the contents of the frame.
* @throws SQLException
* @throws ClassNotFoundException
*/
private void initialize() throws ClassNotFoundException, SQLException {
frame = new JFrame();
frame.setBounds(100, 100, 496, 403);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

JPanel panel = new JPanel();
panel.setBounds(0, 0, 470, 364);
frame.getContentPane().add(panel);
panel.setLayout(null);

JLabel lblNewLabel_1 = new JLabel("");
lblNewLabel_1.setBounds(126, 21, 145, -22);
panel.add(lblNewLabel_1);

JLabel lblNewLabel = new JLabel("Registration Form");
lblNewLabel.setBounds(156, 10, 136, 14);
lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
panel.add(lblNewLabel);

JLabel lblNewLabel_2 = new JLabel("First Name");
lblNewLabel_2.setBounds(46, 52, 86, 14);
lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
panel.add(lblNewLabel_2);

JLabel lblNewLabel_3 = new JLabel("Last Name");
lblNewLabel_3.setBounds(257, 52, 86, 14);
lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
panel.add(lblNewLabel_3);

tFirstName = new JTextField();
tFirstName.setBounds(46, 66, 145, 20);
panel.add(tFirstName);
tFirstName.setColumns(10);

tLastName = new JTextField();
tLastName.setBounds(257, 66, 156, 20);
panel.add(tLastName);
tLastName.setColumns(10);

JLabel lblNewLabel_4 = new JLabel("User ID");
lblNewLabel_4.setBounds(46, 91, 56, 14);
lblNewLabel_4.setFont(new Font("Times New Roman", lblNewLabel_4.getFont().getStyle(), 14));
panel.add(lblNewLabel_4);

tUserId = new JTextField();
tUserId.setBounds(46, 110, 145, 20);
panel.add(tUserId);
tUserId.setColumns(10);

JLabel lblNewLabel_5 = new JLabel("Create Password");
lblNewLabel_5.setBounds(46, 128, 115, 26);
lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
panel.add(lblNewLabel_5);

JLabel lblNewLabel_6 = new JLabel("Confirm Password");
lblNewLabel_6.setBounds(257, 135, 112, 14);
lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
panel.add(lblNewLabel_6);

tCreatePassword = new JTextField();
tCreatePassword.setBounds(46, 154, 145, 20);
panel.add(tCreatePassword);
tCreatePassword.setColumns(10);

tConfirmPassword= new JTextField();
tConfirmPassword.setBounds(257, 154, 152, 20);
panel.add(tConfirmPassword);
tConfirmPassword.setColumns(10);

JLabel lblNewLabel_7 = new JLabel("Gender");
lblNewLabel_7.setBounds(46, 177, 65, 14);
lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
panel.add(lblNewLabel_7);

tGender = new JTextField();
tGender.setBounds(46, 198, 145, 20);
panel.add(tGender);
tGender.setColumns(10);



JLabel lblNewLabel_8 = new JLabel("Role");
lblNewLabel_8.setBounds(46, 229, 65, 14);
lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 14));
panel.add(lblNewLabel_8);

tRole = new JTextField();
tRole.setBounds(46, 254, 145, 20);
panel.add(tRole);
tRole.setColumns(10);

bSubmit = new JButton("Submit");
bSubmit.setFont(new Font("Times New Roman", Font.BOLD, 14));
bSubmit.setBounds(182, 319, 89, 23);
panel.add(bSubmit);



try {
	employee = new EmployeeController();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

bSubmit.addActionListener(new ActionListener() {
@Override
public  void actionPerformed(ActionEvent arg0) {
String UFN, ULN, UID, UP, UG,UR, UCP;
UFN=tFirstName.getText();
ULN=tLastName.getText();
UID=tUserId.getText();
UP=new String(tCreatePassword.getText());
UG=tGender.getText();
UR=tRole.getText();
UCP=new String(tConfirmPassword.getText());

if(UP.equals(UCP)) {

employee.addEmployee(UFN, ULN, UID, UP, UG, UR);
JOptionPane.showMessageDialog(frame, "Registered Successfully...");


}
else {
JOptionPane.showMessageDialog(frame, "Check your Password and Retry...");
}
}
});

}
}


