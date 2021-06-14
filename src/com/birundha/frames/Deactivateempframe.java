package com.birundha.frames;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JTextField;

import com.birundha.controller.EmployeeController;

import javax.swing.JButton;

public class Deactivateempframe {

private JFrame frame;
private JLabel lblNewLabel;
private JLabel lEmployeeId;
private JTextField textField;
private JButton bDeactivate;
private static EmployeeController employee;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Deactivateempframe window = new Deactivateempframe();
window.frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});

}


private void DeactivateEmp() throws ClassNotFoundException, SQLException {
frame = new JFrame();
frame.setBounds(100, 100, 450, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

lblNewLabel = new JLabel("Deactivate Frame");
lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
lblNewLabel.setBounds(137, 27, 171, 14);
frame.getContentPane().add(lblNewLabel);

   lEmployeeId = new JLabel("ENTER EMPLOYEE ID");
lEmployeeId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
lEmployeeId.setBounds(41, 81, 158, 14);
frame.getContentPane().add(lEmployeeId);

textField = new JTextField();
textField.setBounds(248, 79, 158, 20);
frame.getContentPane().add(textField);
textField.setColumns(10);

bDeactivate = new JButton("DEACTIVATE");
bDeactivate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
bDeactivate.setBounds(155, 146, 153, 23);
frame.getContentPane().add(bDeactivate);
try {
	employee = new EmployeeController();
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
bDeactivate.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String UID;
UID = textField.getText();
employee.deactivateEmployee(UID);
JOptionPane.showMessageDialog(frame, "Deactivated Successfully");
frame.dispose();
}
});
}

public Deactivateempframe() throws ClassNotFoundException, SQLException {
DeactivateEmp();
}



}

