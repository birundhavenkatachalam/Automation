package com.birundha. controller;
import java.io.*;
import java.sql.*;
import java.util.*;
//import com.birundha.dao.ISkillDao;
//import com.birundha. model.Employee;
import com.birundha.model.Skill;
import com.birundha. daoimplementation.SkillDao;
//import com.birundha. model.Empskill;

public class SkillController {

	SkillDao skDao=null;
	public SkillController() throws ClassNotFoundException,SQLException
	{
		skDao=new SkillDao();
	}
	
	public void addSkill(String SN, String SD)  throws IOException {
		Skill skil=new Skill();
		skil.setSkillName(SN);	
		skil.setSkillDescription(SD);
		if(SN.equals("Leadership")) {
			skil.setActive("Active");
		}
		else {
			skil.setActive("Deactive");
		}
		//Calling dao method for insert record
		skDao.addSkill(skil);
	}
	
	public void getAllSkills() {
		List<Skill> allSkillList=skDao.getAllSkills();
		for (Skill skil:allSkillList) {
			System.out.println(skil);
		}
	}
	
	public void getSkillById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;	
			id=Integer.parseInt(reader.readLine());
			Skill skil=skDao.getSkillById(id);
			}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
			}
	}
	public void updateSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String skill, skilldescription;
			System.out.println("Enter SkillId of the record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Skill ski=skDao.getSkillById(id);
			System.out.println("Add your new Skill:");
			skill=reader.readLine();
			System.out.println("Enter your new Skill description:");
			skilldescription=reader.readLine();
			ski.setSkillName(skill);
			ski.setSkillDescription(skilldescription);
			skDao.updateSkill(ski);
			System.out.println(ski);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactivateSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			id=Integer.parseInt(reader.readLine());
			Skill sk=skDao.getSkillById(id);
			skDao.deactivateSkill(sk);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void DeleteSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			//System.out.println("Enter SkillId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			skDao.deleteSkill(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void activateSkill(int s) {
		Skill sk=skDao.getSkillById(s);
		skDao.activateSkill(sk);
		
	}
	
}



	
