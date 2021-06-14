package com.birundha.daoimplementation;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.birundha.dao.*;
import com.birundha.config.*;
import com.birundha.model.*;



public class EmployeeDao implements IEmployeeDao{

Connection conn=null;
public EmployeeDao() throws Exception{
conn=jdbcconnection.getDBConnection();
}

@Override
public void addEmployee(Employee emp){
try {
PreparedStatement pst=conn.prepareStatement("insert into Employee(FirstName, LastName, UserId, Password, Role, Gender, Active) values (?,?,?,?,?,?,?)");
pst.setString(1, emp.getFirstName());
pst.setString(2, emp.getLastName());
pst.setString(3, emp.getUserId());
pst.setString(4, emp.getPassword());
pst.setString(5, emp.getRole());
pst.setString(6, emp.getGender());
pst.setString(7, emp.getActive());
int i=pst.executeUpdate();
JFrame g=new JFrame();

if(i==1){
JOptionPane.showConfirmDialog(g, "successfully Added ...");
}

else {

JOptionPane.showConfirmDialog(g, " Retry.");
}

}
catch(SQLException ex) {
System.out.println(ex.getMessage());

}
}

@Override
public Employee checkLogin(Employee emp ) {
//Employee emp=new Employee();
try {
PreparedStatement pst=conn.prepareStatement("select * from Employee where  UserId=? and Password=?");
pst.setString(1, emp.getUserId());
pst.setString(2, emp.getPassword());
ResultSet rst=pst.executeQuery();
if(rst!=null) {
if(rst.next()) {
// emp.setEmpId(rst.getInt(1));
emp.setFirstName(rst.getString(2));
emp.setLastName(rst.getString(3));
emp.setUserId(rst.getString(4));
emp.setPassword(rst.getString(5));
emp.setRole(rst.getString(6));
emp.setGender(rst.getString(7));
emp.setActive(rst.getString(8));

}}}
catch (SQLException e) {
e.printStackTrace();
}
return emp;

}

@Override
public void activateEmployee(Employee emp) {
PreparedStatement ps;
try {
ps = conn.prepareStatement("select UserId from Employee where UserId=?");
ps.setString(1, emp.getUserId());
ResultSet rs= ps.executeQuery();
if(rs!=null) {
if(rs.next()) {
ps = conn.prepareStatement("update Employee set Active= 'YES' where  UserId=?");
ps.setString(1, emp.getUserId());
ps.executeUpdate();
}}}
catch (SQLException e) {
e.printStackTrace();
}}

@Override
public void deactivateEmployee(Employee emp) {
PreparedStatement ps;
try {
ps = conn.prepareStatement("select UserId from Employee where UserId=?");
ps.setString(1, emp.getUserId());
ResultSet rs= ps.executeQuery();
if(rs!=null) {
if(rs.next()) {
ps = conn.prepareStatement("update Employee set Active= 'NO' where  UserId=?");
ps.setString(1, emp.getUserId());
ps.executeUpdate();
}}}
catch (SQLException e) {
e.printStackTrace();
}}





}
