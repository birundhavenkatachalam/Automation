package com.birundha.dao;

import java.util.List;
import com.birundha.model.Empjob;

public interface IEmpJobDao {
	List<Empjob> getAllEmpJobs();
	void addEmpJob(Empjob empj);
	Empjob getEmpJobById(int id);
	void updateEmpJob(Empjob empj);
	void deleteEmpJob(int id);
	
}
