package com.ty.servlets_jsp_student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.servlets_jsp_student.dao.StudentDao;
import com.ty.servlets_jsp_student.dto.Student;

@WebServlet("/save")
public class StudentSaveController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String fatherName = req.getParameter("fathername");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));

		Student student = new Student();
		student.setName(name);
		student.setFatherName(fatherName);
		student.setEmail(email);
		student.setPassword(password);
		student.setPhone(phone);

		ServletContext context = getServletContext();
		long fees = Long.parseLong(context.getInitParameter("fees"));
		student.setFees(fees);

		StudentDao studentDao = new StudentDao();
		Student savedStudent = studentDao.saveStudent(student);
		if (savedStudent != null) {
			req.setAttribute("message", "signed up successfully");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
		}

	}

}
