package com.birundha.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PMEframe {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;



	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	public void run() {
	try {
	PMEframe window = new PMEframe();
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
	public PMEframe() {
		initialize();
		}

		/**
		* Initialize the contents of the frame.
		*/
		private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 24, 391, 226);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);


		lblNewLabel_1 = new JLabel(" PME HOME SCREEN");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(131, 0, 201, 31);
		frame.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Welcome to PME Portal");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(90, 5, 223, 14);
		panel_1.add(lblNewLabel_2);

		btnNewButton = new JButton("View Skill wise Employee");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
		});
		btnNewButton.setBounds(26, 30, 287, 23);
		panel_1.add(btnNewButton);

		btnNewButton_1 = new JButton("View All Skills");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {

		new Allskillframe();
		}


		});



		btnNewButton_2 = new JButton("Add an Job");
		btnNewButton_2.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {


		new AddJobFrame();

		}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2.setBounds(26, 76, 287, 23);
		panel_1.add(btnNewButton_2);

		btnNewButton_3 = new JButton("View All Jobs");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_3.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {

		new Alljobframe();


		}
		});

		btnNewButton_3.setBounds(26, 99, 287, 23);
		panel_1.add(btnNewButton_3);

		btnNewButton_4 = new JButton("View Skill wise Jobs");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_4.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {


		}
		});
		btnNewButton_4.setBounds(26, 122, 287, 23);
		panel_1.add(btnNewButton_4);

		btnNewButton_5 = new JButton("View Employees who have applied for Job");
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_5.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {

		new Appliedjobframe();

		}
		});
		btnNewButton_5.setBounds(26, 145, 287, 23);
		panel_1.add(btnNewButton_5);

		btnNewButton_6 = new JButton("Deactivate Job");
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_6.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {

		new Deactivatejobframe();

		}
		});
		btnNewButton_6.setBounds(26, 169, 287, 23);
		panel_1.add(btnNewButton_6);

		btnNewButton_7 = new JButton("Logout");
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_7.addActionListener(new ActionListener(){


		public void actionPerformed(ActionEvent e) {

		}
		});
		btnNewButton_7.setBounds(26, 192, 287, 23);
		panel_1.add(btnNewButton_7);


		}
		}


	
	
	



	


	
