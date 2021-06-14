package com.birundha.daoimplementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.birundha.config.jdbcconnection;
import com.birundha.dao.IJobDao;
import com.birundha.model.Job;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class JobDao implements IJobDao{
	
	Connection conn=null;
	public JobDao() throws ClassNotFoundException, SQLException{
    conn=jdbcconnection.getDBConnection();
	}
	@Override
	public List<Job> getAllJobs() {
		List<Job> allJobList=new ArrayList<Job>();
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Job");
			if(rst!=null) {
				Job job=null;
				while(rst.next()) {
					job=new Job();
					job.setJobId(rst.getInt(1));
					job.setJobTitle(rst.getString(2));
					job.setJobDescription(rst.getString(3));
					job.setCompanyName(rst.getString(4));
					job.setLocation(rst.getString(5));
					job.setKeySkill(rst.getString(6));
					job.setSalary(rst.getString(7));
					job.setActive(rst.getString(8));
					allJobList.add(job);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allJobList;
	}
	@Override
	public void addJob(Job job){
		try {
			
			PreparedStatement pst=conn.prepareStatement("insert into Job(JobTitle, JobDescription,CompanyName,Location,KeySkill,Salary,Activate) values(?,?,?,?,?,?,?)");
			pst.setString(1, job.getJobTitle());
			pst.setString(2, job.getJobDescription());
			pst.setString(3, job.getCompanyName());
			pst.setString(4, job.getLocation());
			pst.setString(5, job.getKeySkill());
			pst.setString(6, job.getSalary());
			pst.setString(7, job.getActive());
			int i=pst.executeUpdate();
			
			JFrame g=new JFrame();
			if(i==1){
				//System.out.println("1 record inserted...");
				JOptionPane.showMessageDialog(g,"Successfully added a Job");
			}
			else {
				//System.out.println("Insertion failed...");
				JOptionPane.showMessageDialog(g,"Oh noooo!!! Unable to add a Job");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public Job getJobById(int id) {
		Job job=new Job();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from Job where JobId=?");
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					job=new Job();
					job.setJobId(rst.getInt(1));
					job.setJobTitle(rst.getString(2));
					job.setJobDescription(rst.getString(3));
					job.setCompanyName(rst.getString(4));
					job.setLocation(rst.getString(5));
					job.setKeySkill(rst.getString(6));
					job.setSalary(rst.getString(7));
					job.setActive(rst.getString(8));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return job;
	}
	@Override
	public void updateJob(Job job) {
		try {
			
			PreparedStatement pst=conn.prepareStatement("update Job set Location=? where JobId=? ");
			pst.setString(1, job.getLocation());
			pst.setInt(2, job.getJobId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record updated...");
			}
			else {
				System.out.println("update failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public void deactivateJob(Job j) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Employee set Activate=? where JobId=? ");
			pst.setString(1, "Deactive");
			pst.setInt(2, j.getJobId());
			int i=pst.executeUpdate();
			JFrame g=new JFrame();
			if(i==1){
				System.out.println("Job deactivated...");
				JOptionPane.showConfirmDialog(g, "Sry to congratulating for this....Job Deactivated successfully...");
				
			}
			else {
				System.out.println("Deactivation failed...");
				JOptionPane.showConfirmDialog(g, "Deactivation failed mate...");
				
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

@Override
public  void deleteJob(int id) {
	try {
		//creating PreparedStatement object by passing query string
		PreparedStatement pst=conn.prepareStatement("delete from Job where JobId=? ");
		pst.setInt(1, id);
		int i=pst.executeUpdate();
		JFrame g=new JFrame();
		if(i==1){
			//System.out.println("1 record deleted...");
			JOptionPane.showConfirmDialog(g, "HOOOOHuuuuu...You have successfully deleted a Job....");
		}
		else {
			//System.out.println("deletion failed...");
			JOptionPane.showConfirmDialog(g, "Oh My God... Deletion Failed...");
		}
	}
	catch(SQLException ex) {
		System.out.println(ex.getMessage());
	}
	
}
	@Override
	public void activateJob(Job j) {
		try {
			
			PreparedStatement pst=conn.prepareStatement("update Employee set Activate=? where JobId=? ");
			pst.setString(1, "Active");
			pst.setInt(2, j.getJobId());
			int i=pst.executeUpdate();
			JFrame g=new JFrame();
			if(i==1){
				//System.out.println("Job activated...");
				JOptionPane.showConfirmDialog(g, "Tadaaaa....Job activated Succesfully...");
				
			}
			else {
				System.out.println("Activation failed...");
				JOptionPane.showConfirmDialog(g, "Oh my God!!! Activation Failed...");

			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public Job getJobById(String hR) {
		
		return null;
	}
}
		
	