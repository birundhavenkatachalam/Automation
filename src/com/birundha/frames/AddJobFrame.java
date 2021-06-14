package com.birundha.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;

import com.birundha.controller.JobController;
//import com.birundha.controller.Jobcontroller;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddJobFrame {

	private JFrame frmAddjob;
	private JTextField tJobtitle ;
	private JTextField tJobdescrip;
	private JTextField tCompanyname ;
	private JTextField tLocation ;
	private JTextField tKeyskill;
	private JTextField tSalary;
	private JobController Jobcontroller=null;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddJobFrame window = new AddJobFrame();
					window.frmAddjob.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @return 
	 */
	public void Addjob() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddjob = new JFrame();
		frmAddjob.setTitle("Add Job");
		frmAddjob.setBounds(100, 100, 550, 500);
		frmAddjob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddjob.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 534, 54);
		frmAddjob.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD YOUR PREVIOUS JOB DETAILS:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(0, 11, 225, 32);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 55, 534, 406);
		frmAddjob.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("JOB DESCRIPTION");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_1.setBounds(88, 72, 129, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("COMPANY NAME");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(88, 113, 128, 30);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("LOCATION");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(88, 154, 129, 30);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("KEYSKILL");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(88, 195, 129, 30);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("SALARY");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(88, 239, 129, 30);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("JOB TITLE");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_1_4.setBounds(88, 29, 129, 30);
		panel_1.add(lblNewLabel_1_4);
		
		tJobtitle = new JTextField();
		tJobtitle.setBounds(227, 34, 216, 20);
		panel_1.add(tJobtitle);
		tJobtitle.setColumns(10);
		
		tJobdescrip = new JTextField();
		tJobtitle.setColumns(10);
		tJobtitle.setBounds(227, 77, 216, 20);
		panel_1.add(tJobtitle);
		
		tCompanyname = new JTextField();
		tCompanyname.setColumns(10);
		tCompanyname.setBounds(226, 118, 216, 20);
		panel_1.add(tCompanyname);
		
		tLocation = new JTextField();
		tLocation.setColumns(10);
		tLocation.setBounds(227, 159, 216, 20);
		panel_1.add(tLocation);
		
		tKeyskill = new JTextField();
		tKeyskill.setColumns(10);
		tKeyskill.setBounds(227, 200, 216, 20);
		panel_1.add(tKeyskill);
		
		tSalary = new JTextField();
		tSalary.setColumns(10);
		tSalary.setBounds(227, 244, 216, 20);
		panel_1.add(tSalary);
		
		JButton btnNewButton = new JButton("SUBMIT");
		try {
			setJobcontroller(new JobController());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String s1,s2,s3,s4,s5,s6;
					s1=tJobtitle.getText();
					s2=tJobdescrip.getText();
					s3=tCompanyname.getText();
					s4=tLocation.getText();
					s5=tKeyskill.getText();
					s6=tSalary.getText();
					JobController.addJob(s1,s2,s3,s4,s5,s6);
					 frmAddjob=new JFrame();
					 frmAddjob.dispose();
					JOptionPane.showMessageDialog( frmAddjob,"Job Added");
				}
				
			});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(266, 306, 128, 39);
		panel_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(227, 34, 216, 20);
		panel_1.add(textField);
	}

	public JobController getJobcontroller() {
		return Jobcontroller;
	}

	public void setJobcontroller(JobController jobcontroller) {
		Jobcontroller = jobcontroller;
	}
}
