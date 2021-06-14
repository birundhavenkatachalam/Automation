package com.birundha.daoimplementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import com.birundha.config.jdbcconnection;
//import com.birundha. dao.IEmpJobDao;
import com.birundha.model.Empjob;

public class EmpjobDao {

	Connection conn=null;
	public EmpjobDao() throws ClassNotFoundException, SQLException {
		conn=com.birundha.config.jdbcconnection.getDBConnection();
	}
	public List<Empjob> getAllEmpJobs(){
		List<Empjob> allEmpJobList=new ArrayList<Empjob>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("Select * from EmpJob");
			if(rst!=null) {
				Empjob empj=null;
				while(rst.next()) {
					empj=new Empjob();
					empj.setEJId(rst.getInt(1));
					empj.setEmpId(rst.getInt(2));
					empj.setJobId(rst.getInt(3));
					empj.setRecruited(rst.getString(4));
					allEmpJobList.add(empj);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allEmpJobList;
	}
	public void addEmpJob(Empjob empj) {
		try {
			PreparedStatement pst=conn.prepareStatement("Insert into EmpJob(EmployeeId,JobId,Recruited) values(?,?,?)");
			pst.setInt(3,empj.getEmpId());
			pst.setInt(3,empj.getJobId());
			pst.setString(3,empj.getRecruited());
		
			int i=pst.executeUpdate();
			JFrame j=new JFrame();
			
			if(i==1)
			{
				//System.out.println("1 record inserted");
				JOptionPane.showMessageDialog(j,"We Have Received Your Application...");
			}
			else
			{
				//System.out.println("Insertion failed...");
				JOptionPane.showMessageDialog(j,"Something went Wrong...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}

	public Empjob getEmpJobById(int id) {
		Empjob empj=new Empjob();
		try
		{
			PreparedStatement pst=conn.prepareStatement("Select * from EmployeeJob where EJId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null)
			{
				if(rst.next())
				{
					empj.setEJId(rst.getInt(1));
					empj.setEmpId(rst.getInt(2));
					empj.setJobId(rst.getInt(3));
					empj.setRecruited(rst.getString(4));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}	
		return empj;
	}

	public void updateEmpJob(Empjob ej) {
		try {
			PreparedStatement pst=conn.prepareStatement("update EmpJob set Recruited=? where EJId=? ");
			pst.setString(1, ej.getRecruited());
			pst.setInt(2, ej.getEJId());
			int i=pst.executeUpdate();
			JFrame j=new JFrame();
			if(i==1){
				
				//System.out.println("1 record updated...");
				JOptionPane.showConfirmDialog(j, "The List has been Updated....");
			}
			else {
				//System.out.println("update failed...");
				JOptionPane.showConfirmDialog(j, "updation Failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	public void deleteEmpJob(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("delete from EmpJob where EJId=? ");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			JFrame j=new JFrame();
			if(i==1){
				
				JOptionPane.showConfirmDialog(j, "The Record has been Deleted...");
			}
			else {
				
				JOptionPane.showConfirmDialog(j, "Record deletion Failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}

