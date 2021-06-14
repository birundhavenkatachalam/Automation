package com.birundha.controller;

import com.birundha.daoimplementation.*;
import com.birundha.model.*;



public class EmployeeController {
EmployeeDao empDao=null;
public EmployeeController() throws Exception{
empDao=new EmployeeDao();
}
public void addEmployee(String UFN, String ULN, String UID, String UP, String UR, String UG){
Employee emp=new Employee();

emp.setFirstName(UFN);
emp.setLastName(ULN);
emp.setUserId(UID);
emp.setPassword(UP);
emp.setRole(UR);
emp.setGender(UG);
empDao.addEmployee(emp);
}
public Employee checkLogin(String UID,String PWD) {
Employee emp = new Employee();
emp.setUserId(UID);
emp.setPassword(PWD);
empDao.checkLogin(emp);
return emp;
}
public Employee activateEmployee(String UID) {
Employee emp = new Employee();
emp.setUserId(UID);
empDao.activateEmployee(emp);
return emp;
}
public Employee deactivateEmployee(String UID) {
Employee emp = new Employee();
emp.setUserId(UID);
empDao.deactivateEmployee(emp);
return emp;
}


}
	

