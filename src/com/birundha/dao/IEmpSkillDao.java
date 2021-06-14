package com.birundha.dao;
import java.util.List;
import com.birundha.model.Empskill;

public interface IEmpSkillDao {
	
	List<Empskill> getAllEmpskills();
	void addEmpskill(Empskill esk);
	Empskill getEmpskillById(int id);
	void updateEmpskill(Empskill esk);
	void deleteEmpskill(int id);

}