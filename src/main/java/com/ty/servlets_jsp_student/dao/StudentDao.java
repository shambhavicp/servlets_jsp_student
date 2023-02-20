package com.ty.servlets_jsp_student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.servlets_jsp_student.dto.Student;

public class StudentDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public Student saveStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}

	public Student loginStudentByEmail(String email) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select s from Student s where s.email=?1");
		query.setParameter(1, email);
		Student student = (Student) query.getSingleResult();
		return student;

	}

	public List<Student> getAllStudents() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select s from Student s ");
		List<Student> list = query.getResultList();
		return list;

	}

	public boolean deleteStudent(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = entityManager.find(Student.class, id);
		if (student != null) {

			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public Student getStudentById(int id) {
		return getEntityManager().find(Student.class, id);
	}

	public Student updateStudent(Student student) {

		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}

}
