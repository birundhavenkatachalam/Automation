package com.birundha.frames;

import java.awt.EventQueue;



import javax.swing.JFrame;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Home {

	private JFrame frame;
	private JTextField txtViewAllEmployees;
	private JTextField txtDeactivateEmployee;
	private JTextField txtActiveUsers;
	private JTextField txtViewEmployeeBy;
	private JTextField txtViewAll;
	private JTextField txtViewAllJob;
	private JTextField txtActivateJob;
	private JTextField txtDeactivateJob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame =  new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to HRA portal");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(26, 0, 179, 23);
		frame.getContentPane().add(lblNewLabel);
		
		txtViewAllEmployees = new JTextField();
		txtViewAllEmployees.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtViewAllEmployees.setHorizontalAlignment(SwingConstants.CENTER);
		txtViewAllEmployees.setText("View all Employees");
		txtViewAllEmployees.setBounds(82, 21, 270, 20);
		frame.getContentPane().add(txtViewAllEmployees);
		txtViewAllEmployees.setColumns(10);
		
		txtDeactivateEmployee = new JTextField();
		txtDeactivateEmployee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDeactivateEmployee.setText("Deactivate Employee");
		txtDeactivateEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		txtDeactivateEmployee.setBounds(82, 52, 270, 20);
		frame.getContentPane().add(txtDeactivateEmployee);
		txtDeactivateEmployee.setColumns(10);
		
		txtActiveUsers = new JTextField();
		txtActiveUsers.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtActiveUsers.setText("Active Users");
		txtActiveUsers.setHorizontalAlignment(SwingConstants.CENTER);
		txtActiveUsers.setBounds(82, 83, 270, 20);
		frame.getContentPane().add(txtActiveUsers);
		txtActiveUsers.setColumns(10);
		
		txtViewEmployeeBy = new JTextField();
		txtViewEmployeeBy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtViewEmployeeBy.setText("View Employee By Id");
		txtViewEmployeeBy.setHorizontalAlignment(SwingConstants.CENTER);
		txtViewEmployeeBy.setBounds(82, 114, 270, 20);
		frame.getContentPane().add(txtViewEmployeeBy);
		txtViewEmployeeBy.setColumns(10);
		
		txtViewAll = new JTextField();
		txtViewAll.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtViewAll.setText(" View all Skill");
		txtViewAll.setHorizontalAlignment(SwingConstants.CENTER);
		txtViewAll.setBounds(82, 145, 270, 20);
		frame.getContentPane().add(txtViewAll);
		txtViewAll.setColumns(10);
		
		txtViewAllJob = new JTextField();
		txtViewAllJob.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtViewAllJob.setText("View all Job");
		txtViewAllJob.setHorizontalAlignment(SwingConstants.CENTER);
		txtViewAllJob.setBounds(82, 176, 270, 20);
		frame.getContentPane().add(txtViewAllJob);
		txtViewAllJob.setColumns(10);
		
		txtActivateJob = new JTextField();
		txtActivateJob.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtActivateJob.setText("Activate Job");
		txtActivateJob.setHorizontalAlignment(SwingConstants.CENTER);
		txtActivateJob.setBounds(82, 207, 270, 20);
		frame.getContentPane().add(txtActivateJob);
		txtActivateJob.setColumns(10);
		
		txtDeactivateJob = new JTextField();
		txtDeactivateJob.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDeactivateJob.setText("Deactivate Job");
		txtDeactivateJob.setHorizontalAlignment(SwingConstants.CENTER);
		txtDeactivateJob.setBounds(82, 238, 270, 20);
		frame.getContentPane().add(txtDeactivateJob);
		txtDeactivateJob.setColumns(10);
	}

}
