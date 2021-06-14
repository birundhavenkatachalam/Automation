package com.birundha.daoimplementation;
import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.birundha.config.jdbcconnection;
import com.birundha. dao.IEmpSkillDao;
//import com.birundha.dao.ISkillDao;
//import com.birundha.model.Empjob;
import com.birundha.model.Empskill;
//import com.birundha.model.Skill;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EmpskillDao implements IEmpSkillDao {
	
	Connection conn=null;
	private Component j;
	public EmpskillDao() throws ClassNotFoundException, SQLException{
		conn=jdbcconnection.getDBConnection();
	}
	@Override
	public List<Empskill> getAllEmpskills(){
		List<Empskill> allEmpskillList=new ArrayList<Empskill>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from EmpSkill");
			if(rst!=null) {
				Empskill esk=null;
				while(rst.next()) {
					esk=new Empskill();
					esk.setEsId(rst.getInt(1));
					esk.setEmpId(rst.getInt(2));
					esk.setSkillId(rst.getInt(3));
					esk.setExpYear(rst.getInt(4));
					allEmpskillList.add(esk);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allEmpskillList;
	}
	@Override
	public void addEmpskill(Empskill esk){
		try {
			PreparedStatement pst=conn.prepareStatement("insert into EmpSkill(EmployeeId,SkillId,ExpYear) values(?,?,?)");
			pst.setInt(1,esk.getEmpId());
			pst.setInt(2,esk.getSkillId());
			pst.setInt(3, esk.getExpYear());
			int i=pst.executeUpdate();
			JFrame j =new JFrame();
			if(i==1){
				//System.out.println("1 record inserted...");
				JOptionPane.showConfirmDialog(j,"1 record inserted");
			}
			else {
				//System.out.println("insertion failed...");
				JOptionPane.showConfirmDialog(j, "insertion failed");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	public Empskill getEmpskillById(int id) {
		Empskill esk=new Empskill();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from EmpSkill where ESId=?");
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					esk=new Empskill();
					esk.setEsId(rst.getInt(1));
					esk.setEmpId(rst.getInt(2));
					esk.setSkillId(rst.getInt(3));
					esk.setExpYear(rst.getInt(4));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return esk;
	}

	@Override
	public void updateEmpskill(Empskill esk) {
		try {
			PreparedStatement pst=conn.prepareStatement("update EmpSkill set ExpYear=? where ESId=? ");
			pst.setInt(1, esk.getExpYear());
			pst.setInt(2, esk.getEsId());
			int i=pst.executeUpdate();
			if(i==1){
			//	System.out.println("1 record updated...");
				JOptionPane.showInputDialog(j,"1 record updated");
			}
			else {
				//System.out.println("update failed...");
				JOptionPane.showConfirmDialog(j, "update failed");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	public void deleteEmpskill(int id) {
		try {	
			PreparedStatement pst=conn.prepareStatement("delete from EmpSkill where ESId=? ");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				//System.out.println("1 record deleted...");
				JOptionPane.showConfirmDialog(j,"1 record deleted");
			}
			else {
				//System.out.println("deletion failed...");
				JOptionPane.showConfirmDialog(j,"deletion failed");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}

