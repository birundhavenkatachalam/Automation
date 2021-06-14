package com.birundha.dao;
import java.util.*;
import com.birundha. model.Skill;

public abstract class ISkillDao {

		abstract List<Skill> getAllSkills();
		abstract void addSkill(Skill skill);
		abstract Skill getSkillById(int id);
		abstract void updateSkill(Skill skill);
		abstract void activateSkill(Skill skill);
		abstract void deactivateSkill(Skill skill); 
	   abstract void deleteSkill(int id) ;


}
