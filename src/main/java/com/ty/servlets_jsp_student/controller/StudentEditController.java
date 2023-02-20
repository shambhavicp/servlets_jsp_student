package com.ty.servlets_jsp_student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.servlets_jsp_student.dao.StudentDao;
import com.ty.servlets_jsp_student.dto.Student;

@WebServlet("/edit")
public class StudentEditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String fatherName = req.getParameter("fathername");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));
		long fees = Long.parseLong(req.getParameter("fees"));

		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setFatherName(fatherName);
		student.setEmail(email);
		student.setPassword(password);
		student.setPhone(phone);
		student.setFees(fees);

		StudentDao studentDao = new StudentDao();
		Student updatedStudent = studentDao.updateStudent(student);

		if (updatedStudent != null) {
			List<Student> list = studentDao.getAllStudents();
			req.setAttribute("list", list);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("display.jsp");
			requestDispatcher.forward(req, resp);

		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);

		}

	}

}
