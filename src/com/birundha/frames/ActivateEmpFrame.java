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



public class ActivateEmpFrame {

private JFrame frame;
private JLabel lblNewLabel_1;
private JLabel lblNewLabel_2;
private JTextField textField_1;
private JButton btnNewButton;
private static EmployeeController employee;



public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
  ActivateEmpFrame window = new ActivateEmpFrame();
  window.frame.setVisible(true);
}
   catch (Exception e) {
   e.printStackTrace();
}
}
});
}

private void ActivateEmp() throws ClassNotFoundException,SQLException {


frame = new JFrame();
frame.setBounds(100, 100, 450, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);



lblNewLabel_1 = new JLabel(" Activate Employee");
lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
lblNewLabel_1.setBounds(164, 26, 167, 25);
frame.getContentPane().add(lblNewLabel_1);

lblNewLabel_2 = new JLabel("ENTER EMPLOYEE ID");
lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
lblNewLabel_2.setBounds(62, 93, 138, 14);
frame.getContentPane().add(lblNewLabel_2);

textField_1 = new JTextField();
textField_1.setBounds(245, 90, 154, 20);
frame.getContentPane().add(textField_1);
textField_1.setColumns(10);

btnNewButton = new JButton("ACTIVATE");
btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
btnNewButton.setBounds(157, 165, 154, 23);
frame.getContentPane().add(btnNewButton);
try {
	employee = new EmployeeController();
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String UID;
//JFrame j = new JFrame();
UID = textField_1.getText();
employee.activateEmployee(UID);
JOptionPane.showMessageDialog(frame, "Activated Succesfully");
frame.dispose();
}
});
}
public ActivateEmpFrame() throws ClassNotFoundException, SQLException {
ActivateEmp();

}

}

