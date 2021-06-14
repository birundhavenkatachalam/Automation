package com.birundha.controller;
import java.io.*;
import java.sql.*;
import java.util.*;

//import com.birundha.dao.IJobDao;
import com.birundha.daoimplementation.JobDao;
import com.birundha.model.Job;

public class JobController {
		static com.birundha.daoimplementation.JobDao JobDao=null;
		public JobController() throws ClassNotFoundException, SQLException{
			JobDao=new JobDao();
		}
		public static void addJob(String JBT, String JD, String CN,String LC, String KS, String JS ) {
			Job job=new Job();
				
				job.setJobTitle(JBT);
				job.setJobDescription(JD);
				job.setCompanyName(CN);
				job.setLocation(LC);
				job.setKeySkill(KS);
				job.setSalary(JS);
				if(JBT.equals("HR")) {
					 job.setActive("Activated");
				}
				else {
					job.setActive("Deactivated");
				}
				//Calling dao method for insert record
				JobDao.addJob(job);
			}
			
			public void getAllJobs() {
				
				List<Job> allJobList=JobDao.getAllJobs();
				for(Job job:allJobList) {
					System.out.println(job);
				}
			}
			public void getJobById() {
				try {
					BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
					int id;
					System.out.println("Enter EmployeeId whose record you want to access: ");
					id=Integer.parseInt(reader.readLine());
					Job job=JobDao.getJobById(id);
					System.out.println(job);
					}
				catch(IOException ex) {
					System.out.println(ex.getMessage());
					}
				}
			public void updateJob() {
				try {
					BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
					int id;
					String location, confirmlocation;
					System.out.println("Enter JobId whose record you want to update:");
					id=Integer.parseInt(reader.readLine());
					Job job=JobDao.getJobById(id);
					System.out.println("Enter your new location:");
					location=reader.readLine();
					System.out.println("re-enter same Location to confirm:");
					confirmlocation=reader.readLine();
					if(location.contentEquals(confirmlocation)) {
						job.setLocation(location);
						JobDao.updateJob(job);
					}
					else {
						System.out.println("Sorry! you have entered different location");
					}
					System.out.println(job);
				}
				catch(IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
			public void deactivateJob(int s) {
				try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				Integer.parseInt(reader.readLine());
				Job job=JobDao.getJobById(s);
				JobDao.deactivateJob(job);
			}
				catch(IOException ex){
					System.out.println(ex.getMessage());
				}
					
				}
			public void activateJob(String hR) {
				try {
					BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));	
				Integer.parseInt(reader.readLine());
				Job job=JobDao.getJobById(hR);
				JobDao.activateJob(job);
					
				}
				  catch(IOException ex) {
					  System.out.println(ex.getMessage());
				  }
			}
			public void DeleteJob() {
				try {
					BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
					int id;
					System.out.println("Enter JobId whose record you want to delete: ");
					id=Integer.parseInt(reader.readLine());
					JobDao.deleteJob(id);
				}
				catch(IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
			public void deactivateJob(String hR) {
				
				
			}
}

