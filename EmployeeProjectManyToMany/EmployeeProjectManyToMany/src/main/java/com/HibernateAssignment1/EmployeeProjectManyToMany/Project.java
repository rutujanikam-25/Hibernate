package com.HibernateAssignment1.EmployeeProjectManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
   private int pid;
   private String pname;
   @ManyToMany (mappedBy="project")
   private List<Employee> employee;
   
   //Getter setter method
public int getId() {
	return pid;
}
public void setId(int pid) {
	this.pid = pid;
}
public String getName() {
	return pname;
}
public void setName(String name) {
	this.pname = name;
}
public List<Employee> getEmployee() {
	return employee;
}
public void setEmployee(List<Employee> employee) {
	this.employee = employee;
}

//Constructor
public Project(int id, String name, List<Employee> employee) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.employee = employee;
}
public Project() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
}
