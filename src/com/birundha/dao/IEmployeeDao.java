package com.birundha.dao;

import com.birundha.model.*;

public interface IEmployeeDao {
void addEmployee(Employee emp);
public Employee checkLogin(Employee emp);
public void activateEmployee(Employee emp);
public void deactivateEmployee(Employee emp);

}

