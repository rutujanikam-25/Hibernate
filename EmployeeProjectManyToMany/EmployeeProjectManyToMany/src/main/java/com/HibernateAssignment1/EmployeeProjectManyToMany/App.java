package com.HibernateAssignment1.EmployeeProjectManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
    	//Configuration class object created
    	Configuration cfg=new Configuration();
    	//configure hibernate.cfg.xml file
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        Employee e=new Employee();
        e.setId(101);
        e.setName("Rutuja");
        
        Employee e1=new Employee();
        e1.setId(102);
        e1.setName("Jayshri");
        
        Project p=new Project();
        p.setId(111);
        p.setName("java");
        
        Project p1=new Project();
        p1.setId(112);
        p1.setName("Python");
        
        List<Project> prj=new ArrayList<Project>();
        List<Employee> emp=new ArrayList<Employee>();
        prj.add(p1);
        prj.add(p);
        emp.add(e1);
        emp.add(e);
        e.setProject(prj);
        p.setEmployee(emp);
        e1.setProject(prj);
        p1.setEmployee(emp);
      
       Session session=factory.openSession();
       //begin transaction 
       Transaction  tx=session.beginTransaction();
       //save object
       session.save(e);
       session.save(e1);
       session.save(p1);
       session.save(p);
      
       
       tx.commit();
       session.close();
       factory.close();
   	
    }
}
