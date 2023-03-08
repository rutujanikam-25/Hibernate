package com.HibernateAssignment1.EmployeeProjectManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Employee {
	  @Id
	  private int id;
	   private String name;
	   @ManyToMany @JoinTable(name="Project_Department",
				joinColumns= {@JoinColumn(name="id")},
				inverseJoinColumns= {@JoinColumn(name="pid")})
	   private List<Project> project;
	   //getter setter method
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}
	//constructor
	public Employee(int id, String name, List<Project> project) {
		super();
		this.id = id;
		this.name = name;
		this.project = project;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	   
}
