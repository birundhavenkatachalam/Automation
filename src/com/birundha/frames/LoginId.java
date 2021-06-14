package com.birundha.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.birundha.controller.EmployeeController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.birundha.model.Employee;
import javax.swing.*;
import java.sql.*;

import java.awt.Font;


public class LoginId {

	private JFrame frame;
	private JLabel lUserLabel;
	private JLabel lPassword;
	private JTextField tUserID;
	private JTextField Passwordield;
	    private JButton bLogin;
	    private JButton bRegister;

	    private static EmployeeController employee;
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	public void run() {
	try {
	LoginId window = new LoginId ();
	window.frame.setVisible(true);
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	});
	}


	public LoginId() throws Exception{
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JPanel panel = new JPanel();
	panel.setBounds(0, 0, 434, 261);
	frame.getContentPane().add(panel);
	panel.setLayout(null);


	JLabel lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.setBounds(126, 21, 145, -22);
	panel.add(lblNewLabel_1);


	JLabel lblNewLabel_2 = new JLabel("AC UserLogin");
	lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
	lblNewLabel_2.setBounds(137, 10, 173, 35);
	panel.add(lblNewLabel_2);

	lUserLabel = new JLabel("UserId");
	lUserLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	lUserLabel.setBounds(84, 71, 82, 23);
	panel.add(lUserLabel);

	lPassword = new JLabel("Password");
	lPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	lPassword.setBounds(84, 105, 68, 20);
	panel.add(lPassword);

	tUserID = new JTextField();
	tUserID.setBounds(247, 73, 129, 20);
	panel.add(tUserID);
	tUserID.setColumns(10);

	Passwordield = new JTextField();
	Passwordield.setBounds(247, 106, 129, 20);
	panel.add(Passwordield);
	Passwordield.setColumns(10);

	bLogin  = new JButton("Login");
	bLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
	bLogin.setBounds(84, 188, 89, 23);
	panel.add(bLogin);
	employee = new EmployeeController();
	bLogin.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
	String UID, UP;
	Employee emp=new Employee();
	UID=tUserID.getText();
	UP=new String(Passwordield.getText());
	System.out.println(emp.getUserId());
	System.out.println(emp.getPassword());
	emp = employee.checkLogin(UID, UP);
	if(emp.getUserId()==null&& emp.getPassword()==null) {
	JFrame frame=new JFrame();
	JOptionPane.showMessageDialog(frame,"You are not authorized user! Retry or Register!");
	}

	else {
	if(emp.getActive().equals("Yes")) {
	if(emp.getRole().equals("HRA")) {
	new Home();
	}


	else if(emp.getRole().equals("PME")) {

	new PMEframe();
	}
	else {
	new Employee();
	}
	}
	else {
	JFrame f=new JFrame();
	JOptionPane.showMessageDialog(f,"User not activated !...");
	}
	}
	}
	});


	   bRegister = new JButton("Register");
	bRegister.setFont(new Font("Times New Roman", Font.BOLD, 14));
	bRegister.setBounds(283, 188, 89, 23);
	panel.add(bRegister);
	bRegister.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	try {
	new Registration();
	} catch (ClassNotFoundException | SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	}
	}
	});
	}
	}

