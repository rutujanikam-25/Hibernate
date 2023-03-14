package com.StudentHibernate.Hibernate11;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory=cfg.buildSessionFactory();
    	//is the session factory closed?
    	//System.out.println(factory.isClosed());
    	
    	Student s=new Student();
    	s.setId(101);
    	s.setName("Pooja");
    	
    	Course c=new Course();
    	c.setId(999);
    	c.setName("java");
    	c.setStudent(s);
    	
    	Course c1=new Course();
    	c1.setId(888);
    	c1.setName("cpp");
    	c1.setStudent(s);
    	
    	Course c2=new Course();
    	c2.setId(777);
    	c2.setName("python");
    	c2.setStudent(s);
    	
    	List<Course> list=new ArrayList<Course>();
    	list.add(c1);
    	list.add(c2);
    	list.add(c);
    	
    	s.setCourse(list);
    	
    	Session session=factory.openSession();
        //begin the transaction
        Transaction tx=session.beginTransaction();
        session.save(s);
        session.save(c);
        session.save(c1);
        session.save(c2);
        
        tx.commit();
        session.close();
        factory.close();
    	
    	
    	
    	
    }
}
