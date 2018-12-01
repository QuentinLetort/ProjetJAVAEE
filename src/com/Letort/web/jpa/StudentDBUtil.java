package com.Letort.web.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentDBUtil {
	private static final String JPA_UNIT_NAME = "JSFJPA";
	private static EntityManager entityManager;

	protected static EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(JPA_UNIT_NAME).createEntityManager();
		}
		return entityManager;
	}

	public static List<Student> loadStudents() {
		EntityManager em = getEntityManager();
		Query query = em.createQuery("SELECT s FROM Student s");
		List<Student> result = query.getResultList();
		return result;
	}

	public static Student fetchStudent(int id) {
		EntityManager em = getEntityManager();
		Student student = em.find(Student.class, id);
		return student;
	}

	public static void updateStudent(Student student) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		student = em.merge(student);
		em.getTransaction().commit();
	}

	public static void deleteStudent(int id) {
		EntityManager em = getEntityManager();
		Student student = em.find(Student.class, id);
		try {
			em.getTransaction().begin();
			em.remove(student);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				em.getTransaction().rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	public static void addStudent(Student student) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(student);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				em.getTransaction().rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
