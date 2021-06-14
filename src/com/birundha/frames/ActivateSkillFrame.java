package com.birundha.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.lang.ModuleLayer.Controller;
import java.sql.SQLException;

import javax.swing.JTextField;

//import com.birundha.controller.JobController;
import com.birundha.controller.SkillController;

import javax.swing.JButton;

public class ActivateSkillFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivateSkillFrame window = new ActivateSkillFrame();
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
	public ActivateSkillFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Skill");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(100, 106, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(181, 136, 100, -28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(209, 86, 161, 54);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Activate");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(149, 204, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		try {
			new SkillController();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			btnNewButton.addActionListener(new ActionListener() {
		

				@Override
				public void actionPerformed(ActionEvent e) {
					//Object controller
					//Controller.Skillcontroller(s);
					JOptionPane.showMessageDialog(frame, "Activated Succesfully");
					frame.dispose();

				}



				
				}
		);
		}
	//	public ActivateSkillFrame()throws ClassNotFoundException,SQLException{
		//	ActivateSkill();
		}
	}

