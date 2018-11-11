package com.Letort.web.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Test {
	public static void main(String[] args) {
		 
		StudentDBUtil dao=new StudentDBUtil();
		List<Student> students = dao.loadStudents();
		for(int i=0;i<students.size();i++)
		{
			System.out.println(students.get(i));
		}
        
}

}
